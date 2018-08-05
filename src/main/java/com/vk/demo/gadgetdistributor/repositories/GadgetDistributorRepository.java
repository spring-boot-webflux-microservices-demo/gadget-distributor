package com.vk.demo.gadgetdistributor.repositories;

import com.vk.demo.gadgetdistributor.models.GadgetUser;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface GadgetDistributorRepository extends ReactiveCrudRepository<GadgetUser, String> {
    Flux<GadgetUser> findAllByUserId(String userId);
}
