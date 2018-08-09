package com.vk.demo.gadgetdistributor.handler;

import com.vk.demo.gadgetdistributor.clients.Api1Client;
import com.vk.demo.gadgetdistributor.models.User;
import com.vk.demo.gadgetdistributor.models.UserGadget;
import com.vk.demo.gadgetdistributor.repositories.GadgetDistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;
import java.net.URI;

@Component
public class GadgetDistributorHandler {

    private static final String SAVE_USER_GADGET = "/gadgetDistributor/saveUserGadget/";
    private static final String SLASH = "/";
    private GadgetDistributorRepository gadgetDistributorRepository;
    private Api1Client api1Client;

    @Autowired
    public GadgetDistributorHandler(Api1Client api1Client, GadgetDistributorRepository gadgetDistributorRepository) {
        this.api1Client = api1Client;
        this.gadgetDistributorRepository = gadgetDistributorRepository;
    }

    @NotNull
    public Mono<ServerResponse> findGadgetsByUser(ServerRequest request) {
        String userId = request.pathVariable("userId");
        User user = api1Client.findUser(userId);

        Flux<UserGadget> gadgets = gadgetDistributorRepository.findAllByUserId(userId);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(gadgets, UserGadget.class);
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
