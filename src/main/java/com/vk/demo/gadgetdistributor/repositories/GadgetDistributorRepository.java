package com.vk.demo.gadgetdistributor.repositories;

import com.vk.demo.gadgetdistributor.models.UserGadgets;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface GadgetDistributorRepository extends ReactiveCrudRepository<UserGadgets, String> {
    Mono<UserGadgets> findByUserId(String userId);
}
