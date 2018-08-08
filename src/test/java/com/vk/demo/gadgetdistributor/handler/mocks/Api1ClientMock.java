package com.vk.demo.gadgetdistributor.handler.mocks;

import com.vk.demo.gadgetdistributor.clients.Api1Client;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class Api1ClientMock implements Api1Client {
    @Override
    public Mono<ServerResponse> findAll() {
        return Mono.empty();
    }
}
