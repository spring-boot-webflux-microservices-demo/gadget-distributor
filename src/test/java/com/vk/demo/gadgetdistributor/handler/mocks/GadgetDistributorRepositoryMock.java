package com.vk.demo.gadgetdistributor.handler.mocks;

import com.vk.demo.gadgetdistributor.models.UserGadget;
import com.vk.demo.gadgetdistributor.repositories.GadgetDistributorRepository;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class GadgetDistributorRepositoryMock implements GadgetDistributorRepository {

    public GadgetDistributorRepositoryMock(List<UserGadget> userGadget) {

    }

    @Override
    public Flux<UserGadget> findAllByUserId(String userId) {
        return null;
    }

    @Override
    public <S extends UserGadget> Mono<S> save(S s) {
        return null;
    }

    @Override
    public <S extends UserGadget> Flux<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends UserGadget> Flux<S> saveAll(Publisher<S> publisher) {
        return null;
    }

    @Override
    public Mono<UserGadget> findById(String s) {
        return null;
    }

    @Override
    public Mono<UserGadget> findById(Publisher<String> publisher) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(String s) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(Publisher<String> publisher) {
        return null;
    }

    @Override
    public Flux<UserGadget> findAll() {
        return null;
    }

    @Override
    public Flux<UserGadget> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public Flux<UserGadget> findAllById(Publisher<String> publisher) {
        return null;
    }

    @Override
    public Mono<Long> count() {
        return null;
    }

    @Override
    public Mono<Void> deleteById(String s) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(Publisher<String> publisher) {
        return null;
    }

    @Override
    public Mono<Void> delete(UserGadget userGadget) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Iterable<? extends UserGadget> iterable) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Publisher<? extends UserGadget> publisher) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll() {
        return null;
    }
}
