package com.vk.demo.gadgetdistributor.handler.mocks;

import com.vk.demo.gadgetdistributor.models.UserGadgets;
import com.vk.demo.gadgetdistributor.repositories.GadgetDistributorRepository;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class GadgetDistributorRepositoryMock implements GadgetDistributorRepository {

    private List<UserGadgets> userGadgets;
    public GadgetDistributorRepositoryMock(List<UserGadgets> userGadgets) {
        this.userGadgets = userGadgets;
    }

    @Override
    public <S extends UserGadgets> Mono<S> save(S s) {
        return Mono.just(s);
    }

    @Override
    public <S extends UserGadgets> Flux<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends UserGadgets> Flux<S> saveAll(Publisher<S> publisher) {
        return null;
    }

    @Override
    public Mono<UserGadgets> findById(String s) {
        return null;
    }

    @Override
    public Mono<UserGadgets> findById(Publisher<String> publisher) {
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
    public Flux<UserGadgets> findAll() {
        return Flux.fromIterable(userGadgets);
    }

    @Override
    public Flux<UserGadgets> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public Flux<UserGadgets> findAllById(Publisher<String> publisher) {
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
    public Mono<Void> delete(UserGadgets userGadgets) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Iterable<? extends UserGadgets> iterable) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Publisher<? extends UserGadgets> publisher) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll() {
        return null;
    }
}
