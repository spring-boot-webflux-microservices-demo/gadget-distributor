package com.vk.demo.gadgetdistributor.repositories;

import com.vk.demo.gadgetdistributor.models.UserGadget;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface GadgetDistributorRepository extends ReactiveCrudRepository<UserGadget, String> {
    Flux<UserGadget> findAllByUserId(String userId);
}
