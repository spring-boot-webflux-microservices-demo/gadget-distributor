package com.vk.demo.gadgetdistributor.handler.mocks;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.charset.Charset;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class RequestHeadersUriSpecMock implements WebClient.RequestHeadersUriSpec {
    @Override
    public WebClient.RequestHeadersSpec accept(MediaType... acceptableMediaTypes) {
        return null;
    }

    @Override
    public WebClient.RequestHeadersSpec acceptCharset(Charset... acceptableCharsets) {
        return null;
    }

    @Override
    public WebClient.RequestHeadersSpec cookie(String name, String value) {
        return null;
    }

    @Override
    public WebClient.RequestHeadersSpec ifModifiedSince(ZonedDateTime ifModifiedSince) {
        return null;
    }

    @Override
    public WebClient.RequestHeadersSpec ifNoneMatch(String... ifNoneMatches) {
        return null;
    }

    @Override
    public WebClient.RequestHeadersSpec header(String headerName, String... headerValues) {
        return null;
    }

    @Override
    public WebClient.RequestHeadersSpec attribute(String name, Object value) {
        return null;
    }

    @Override
    public WebClient.ResponseSpec retrieve() {
        return new WebClientMock.ResponseSpecMock();
    }

    @Override
    public Mono<ClientResponse> exchange() {
        return null;
    }

    @Override
    public WebClient.RequestHeadersSpec attributes(Consumer attributesConsumer) {
        return null;
    }

    @Override
    public WebClient.RequestHeadersSpec headers(Consumer consumer) {
        return null;
    }

    @Override
    public WebClient.RequestHeadersSpec cookies(Consumer cookiesConsumer) {
        return null;
    }

    @Override
    public WebClient.RequestHeadersSpec<?> uri(URI uri) {
        return null;
    }

    @Override
    public WebClient.RequestHeadersSpec<?> uri(String uri, Object... uriVariables) {
        return new WebClientMock.RequestHeadersSpecMock();
    }

    @Override
    public WebClient.RequestHeadersSpec<?> uri(Function function) {
        return null;
    }

    @Override
    public WebClient.RequestHeadersSpec<?> uri(String uri, Map uriVariables) {
        return null;
    }
}
