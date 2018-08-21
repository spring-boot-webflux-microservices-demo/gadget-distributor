package com.vk.demo.gadgetdistributor.handler;

import com.vk.demo.gadgetdistributor.models.Gadget;
import com.vk.demo.gadgetdistributor.models.User;
import com.vk.demo.gadgetdistributor.models.UserGadgets;
import com.vk.demo.gadgetdistributor.repositories.GadgetDistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;
import java.net.URI;

@Component
public class GadgetDistributorHandler {

    private static final String SAVE_USER_GADGET = "/gadgetDistributor/saveUserGadget/";
    private static final String SLASH = "/";
    private GadgetDistributorRepository gadgetDistributorRepository;
    private WebClient.Builder webClientBuilder;

    @Autowired
    public GadgetDistributorHandler(WebClient.Builder webClientBuilder, GadgetDistributorRepository gadgetDistributorRepository) {
        this.webClientBuilder = webClientBuilder;
        this.gadgetDistributorRepository = gadgetDistributorRepository;
    }

    @NotNull
    public Mono<ServerResponse> findGadgetsByUser(ServerRequest request) {
        String userId = request.pathVariable("userId");

        Mono<User> userMono = webClientBuilder.build().get()
                .uri("http://api1/api1/findUser/{id}", userId)
                .retrieve()
                .bodyToMono(User.class);
        return userMono.flatMap(u -> ServerResponse.ok().body(Mono.just(u), User.class));
    }

    @NotNull
    public Mono<ServerResponse> saveUserGadget(ServerRequest request) {
        String userId = request.pathVariable("userId");
        String gadgetId = request.pathVariable("gadgetId");
        Mono<User> user = webClientBuilder.build().get().uri("http://api1/api1/findUser/{id}", userId).retrieve().bodyToMono(User.class);
        Mono<Gadget> gadget = webClientBuilder.build().get().uri("http://api2/api2/findGadget/{id}", gadgetId).retrieve().bodyToMono(Gadget.class);

        UserGadgets result = new UserGadgets();
        Mono<UserGadgets> userGadgets = Mono.zip(user, gadget, UserGadgets::new);
        userGadgets.subscribe(u -> {result.setUser(u.getUser()); result.setGadgets(u.getGadgets());});
        Mono<UserGadgets> saved = userGadgets.flatMap(gadgetDistributorRepository::save);
        return saved.flatMap(s -> ServerResponse.created(URI.create(SAVE_USER_GADGET + userId + SLASH + gadgetId))
                .body(saved, UserGadgets.class));
    }
}
