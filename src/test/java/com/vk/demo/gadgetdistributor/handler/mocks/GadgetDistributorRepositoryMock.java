package com.vk.demo.gadgetdistributor.handler.mocks;

import com.vk.demo.gadgetdistributor.models.GadgetUser;
import com.vk.demo.gadgetdistributor.repositories.GadgetDistributorRepository;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class GadgetDistributorRepositoryMock implements GadgetDistributorRepository {

    public GadgetDistributorRepositoryMock(List<GadgetUser> gadgetUser) {

    }

    @Override
    public Flux<GadgetUser> findAllByUserId(String userId) {
        return null;
    }

    @Override
    public <S extends GadgetUser> Mono<S> save(S s) {
        return null;
    }

    @Override
    public <S extends GadgetUser> Flux<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends GadgetUser> Flux<S> saveAll(Publisher<S> publisher) {
        return null;
    }

    @Override
    public Mono<GadgetUser> findById(String s) {
        return null;
    }

    @Override
    public Mono<GadgetUser> findById(Publisher<String> publisher) {
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
    public Flux<GadgetUser> findAll() {
        return null;
    }

    @Override
    public Flux<GadgetUser> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public Flux<GadgetUser> findAllById(Publisher<String> publisher) {
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
    public Mono<Void> delete(GadgetUser gadgetUser) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Iterable<? extends GadgetUser> iterable) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Publisher<? extends GadgetUser> publisher) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll() {
        return null;
    }
}
