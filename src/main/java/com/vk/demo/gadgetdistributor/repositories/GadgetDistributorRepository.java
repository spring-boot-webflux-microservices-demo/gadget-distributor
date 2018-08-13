package com.vk.demo.gadgetdistributor.repositories;

import com.vk.demo.gadgetdistributor.models.UserGadgets;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface GadgetDistributorRepository extends ReactiveCrudRepository<UserGadgets, String> {
    Mono<UserGadgets> findByUserId(String userId);
}
