package com.vk.demo.gadgetdistributor.handler;

import com.vk.demo.gadgetdistributor.models.UserGadget;
import com.vk.demo.gadgetdistributor.repositories.GadgetDistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class GadgetDistributorHandler {

    private GadgetDistributorRepository gadgetDistributorRepository;

    @Autowired
    public GadgetDistributorHandler(GadgetDistributorRepository gadgetDistributorRepository) {
        this.gadgetDistributorRepository = gadgetDistributorRepository;
    }

    public Mono<ServerResponse> findGadgetsByUser(ServerRequest request) {
        String userId = request.pathVariable("userId");
        Flux<UserGadget> gadgets = gadgetDistributorRepository.findAllByUserId(userId);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(gadgets, UserGadget.class);
    }

}
