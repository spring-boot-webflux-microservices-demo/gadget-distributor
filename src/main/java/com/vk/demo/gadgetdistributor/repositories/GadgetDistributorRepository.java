package com.vk.demo.gadgetdistributor.repositories;

import com.vk.demo.gadgetdistributor.models.UserGadgets;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GadgetDistributorRepository extends ReactiveCrudRepository<UserGadgets, String> {

}
