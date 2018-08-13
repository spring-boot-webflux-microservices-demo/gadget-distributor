package com.vk.demo.gadgetdistributor.handler.mocks.webclient;

import com.vk.demo.gadgetdistributor.handler.mocks.webclient.WebClientMock;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilderFactory;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class WebClientBuilderMock implements WebClient.Builder {
    @Override
    public WebClient.Builder baseUrl(String baseUrl) {
        return null;
    }

    @Override
    public WebClient.Builder defaultUriVariables(Map<String, ?> defaultUriVariables) {
        return null;
    }

    @Override
    public WebClient.Builder uriBuilderFactory(UriBuilderFactory uriBuilderFactory) {
        return null;
    }

    @Override
    public WebClient.Builder defaultHeader(String headerName, String... headerValues) {
        return null;
    }

    @Override
    public WebClient.Builder defaultHeaders(Consumer<HttpHeaders> headersConsumer) {
        return null;
    }

    @Override
    public WebClient.Builder defaultCookie(String cookieName, String... cookieValues) {
        return null;
    }

    @Override
    public WebClient.Builder defaultCookies(Consumer<MultiValueMap<String, String>> cookiesConsumer) {
        return null;
    }

    @Override
    public WebClient.Builder clientConnector(ClientHttpConnector connector) {
        return null;
    }

    @Override
    public WebClient.Builder filter(ExchangeFilterFunction filter) {
        return null;
    }

    @Override
    public WebClient.Builder filters(Consumer<List<ExchangeFilterFunction>> filtersConsumer) {
        return null;
    }

    @Override
    public WebClient.Builder exchangeFunction(ExchangeFunction exchangeFunction) {
        return null;
    }

    @Override
    public WebClient.Builder exchangeStrategies(ExchangeStrategies strategies) {
        return null;
    }

    @Override
    public WebClient.Builder clone() {
        return null;
    }

    @Override
    public WebClient.Builder apply(Consumer<WebClient.Builder> builderConsumer) {
        return null;
    }

    @Override
    public WebClient build() {
        return new WebClientMock();
    }
}
