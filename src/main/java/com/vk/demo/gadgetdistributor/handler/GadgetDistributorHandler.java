package com.vk.demo.gadgetdistributor.handler;

import com.vk.demo.gadgetdistributor.models.User;
import com.vk.demo.gadgetdistributor.models.UserGadget;
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
        Mono<User> user = webClientBuilder.build().get().uri("http://api1/api1/findUser/{id}", userId).retrieve().bodyToMono(User.class);
        return user.flatMap(a -> ServerResponse.ok().body(user, User.class));
    }

    @NotNull
    public Mono<ServerResponse> saveUserGadget(ServerRequest request) {
        String userId = request.pathVariable("userId");
        String gadgetid = request.pathVariable("gadgetId");

//        api1Client.findUser();

        UserGadget userGadget = new UserGadget();

        Mono<UserGadget> saved = gadgetDistributorRepository.save(userGadget);
        return saved.flatMap(s -> ServerResponse.created(URI.create(SAVE_USER_GADGET + s.getUser().getId() + SLASH + s.getGadget().getId()))
                .body(Mono.just(userGadget), UserGadget.class));
    }

}
