package com.vk.demo.gadgetdistributor.handler.mocks;

import com.vk.demo.gadgetdistributor.models.Gadget;
import com.vk.demo.gadgetdistributor.models.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;
import java.time.ZonedDateTime;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class WebClientMock implements WebClient {
    @Override
    public RequestHeadersUriSpec<?> get() {
        return new RequestHeadersUriSpecMock();
    }

    @Override
    public RequestHeadersUriSpec<?> head() {
        return null;
    }

    @Override
    public RequestBodyUriSpec post() {
        return null;
    }

    @Override
    public RequestBodyUriSpec put() {
        return null;
    }

    @Override
    public RequestBodyUriSpec patch() {
        return null;
    }

    @Override
    public RequestHeadersUriSpec<?> delete() {
        return null;
    }

    @Override
    public RequestHeadersUriSpec<?> options() {
        return null;
    }

    @Override
    public RequestBodyUriSpec method(HttpMethod method) {
        return null;
    }

    @Override
    public Builder mutate() {
        return null;
    }

    public static class ResponseSpecMock implements WebClient.ResponseSpec {

        @Override
        public ResponseSpec onStatus(Predicate<HttpStatus> statusPredicate, Function<ClientResponse, Mono<? extends Throwable>> exceptionFunction) {
            return null;
        }

        @Override
        public <T> Mono<T> bodyToMono(Class<T> bodyType) {
            if (bodyType.isAssignableFrom(User.class)) {
                return (Mono<T>) Mono.just(UserMock.createMock());
            }

            if (bodyType.isAssignableFrom(Gadget.class)) {
                return (Mono<T>) Mono.just(GadgetMock.createMock());
            }

            return Mono.empty();
        }

        @Override
        public <T> Mono<T> bodyToMono(ParameterizedTypeReference<T> typeReference) {
            return null;
        }

        @Override
        public <T> Flux<T> bodyToFlux(Class<T> elementType) {
            return null;
        }

        @Override
        public <T> Flux<T> bodyToFlux(ParameterizedTypeReference<T> typeReference) {
            return null;
        }
    }

    public static class RequestHeadersSpecMock implements WebClient.RequestHeadersSpec {

        @Override
        public RequestHeadersSpec accept(MediaType... acceptableMediaTypes) {
            return null;
        }

        @Override
        public RequestHeadersSpec acceptCharset(Charset... acceptableCharsets) {
            return null;
        }

        @Override
        public RequestHeadersSpec cookie(String name, String value) {
            return null;
        }

        @Override
        public RequestHeadersSpec ifModifiedSince(ZonedDateTime ifModifiedSince) {
            return null;
        }

        @Override
        public RequestHeadersSpec ifNoneMatch(String... ifNoneMatches) {
            return null;
        }

        @Override
        public RequestHeadersSpec header(String headerName, String... headerValues) {
            return null;
        }

        @Override
        public RequestHeadersSpec attribute(String name, Object value) {
            return null;
        }

        @Override
        public ResponseSpec retrieve() {
            return new ResponseSpecMock();
        }

        @Override
        public Mono<ClientResponse> exchange() {
            return null;
        }

        @Override
        public RequestHeadersSpec attributes(Consumer attributesConsumer) {
            return null;
        }

        @Override
        public RequestHeadersSpec headers(Consumer consumer) {
            return null;
        }

        @Override
        public RequestHeadersSpec cookies(Consumer cookiesConsumer) {
            return null;
        }
    }

}
