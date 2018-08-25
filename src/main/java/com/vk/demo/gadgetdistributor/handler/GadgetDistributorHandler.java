package com.vk.demo.gadgetdistributor.handler;

import com.vk.demo.gadgetdistributor.models.Gadget;
import com.vk.demo.gadgetdistributor.models.User;
import com.vk.demo.gadgetdistributor.models.UserGadgets;
import com.vk.demo.gadgetdistributor.repositories.GadgetDistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;
import java.net.URI;

@Component
public class GadgetDistributorHandler {

    private GadgetDistributorRepository gadgetDistributorRepository;
    private WebClient.Builder webClientBuilder;

    @Autowired
    public GadgetDistributorHandler(WebClient.Builder webClientBuilder, GadgetDistributorRepository gadgetDistributorRepository) {
        this.webClientBuilder = webClientBuilder;
        this.gadgetDistributorRepository = gadgetDistributorRepository;
    }

    @NonNull
    public Mono<ServerResponse> findAll(ServerRequest request) {
        Flux<UserGadgets> userGadgets = gadgetDistributorRepository.findAll();
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(userGadgets, UserGadgets.class);
    }

    @NotNull
    public Mono<ServerResponse> findGadgetsByUser(ServerRequest request) {
        String userId = request.pathVariable("userId");
        Flux<Gadget> userGadgets = gadgetDistributorRepository.findAll()
                .filter(ug -> ug.getUser().getId().equals(userId))
                .flatMap(ug -> Flux.fromIterable(ug.getGadgets()));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(userGadgets, Gadget.class);
    }

    @NotNull
    public Mono<ServerResponse> saveUserGadget(ServerRequest request) {
        String userId = request.pathVariable("userId");
        String gadgetId = request.pathVariable("gadgetId");
        Mono<User> user = webClientBuilder.build().get()
                .uri("http://api1/api1/findUser/{id}", userId)
                .retrieve()
                .bodyToMono(User.class);
        Mono<Gadget> gadget = webClientBuilder.build().get()
                        .uri("http://api2/api2/findGadget/{id}", gadgetId)
                        .retrieve()
                        .bodyToMono(Gadget.class);
        Mono<UserGadgets> userGadgets = Mono.zip(user, gadget, UserGadgets::new);
        Mono<UserGadgets> saved = userGadgets.flatMap(gadgetDistributorRepository::save);
        return saved.flatMap(ug -> ServerResponse.created(URI.create("/gadgetDistribution/save/" + ug.getId())).body(Mono.just(ug), UserGadgets.class));
    }

    @NonNull
    public Mono<ServerResponse> deleteUserGadgetsByUser(ServerRequest request) {
        String userId = request.pathVariable("userId");
        Mono<UserGadgets> userGadgets = gadgetDistributorRepository.findAll()
                .filter(ug -> ug.getUser().getId().equals(userId)).next();
        return userGadgets.flatMap(ug -> gadgetDistributorRepository.delete(ug))
                .then(ServerResponse.noContent().build())
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
