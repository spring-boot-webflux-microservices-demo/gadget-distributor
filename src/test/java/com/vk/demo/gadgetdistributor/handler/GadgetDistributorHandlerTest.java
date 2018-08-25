package com.vk.demo.gadgetdistributor.handler;

import com.vk.demo.gadgetdistributor.handler.mocks.GadgetDistributorRepositoryMock;
import com.vk.demo.gadgetdistributor.handler.mocks.GadgetMock;
import com.vk.demo.gadgetdistributor.handler.mocks.UserGadgetsMock;
import com.vk.demo.gadgetdistributor.handler.mocks.webclient.WebClientBuilderMock;
import com.vk.demo.gadgetdistributor.models.UserGadgets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@WebFluxTest
@SpringBootTest
public class GadgetDistributorHandlerTest {

    private static final String FIND_GADGETS_BY_USER_ENDPOINT = "/gadgetDistributor/findGadgetsByUser/{userId}";
    private static final String FIND_ALL_USER_GADGETS = "/gadgetDistributor/findAll";
    private static final String SAVE_USER_GADGET_ENDPOINT = "/gadgetDistributor/saveUserGadget/user/{userId}/gadget/{gadgetId}";
    private static final String SAVE_USER_GADGET = "/gadgetDistributor/saveUserGadgets/";
    private static final String DELETE_USER_GADGETS_BY_USER_ENDPOINT = "/gadgetDistributor/deleteUserGadgetsByUser/{userId}";
    private static final String USER_ID_NOT_EXIST = "userIdNotExist";
    private static final String USER = "user/";
    private static final String GADGET = "/gadget/";
    private static final String EMPTY_JSON_LIST = "[]";
    private WebTestClient webTestClient;

    private WebClient.Builder webClientBuilder;

    @BeforeEach
    public void setup() {
        webClientBuilder = new WebClientBuilderMock();
    }

    @Test
    public void findAll() {
        List<UserGadgets> userGadgets = Arrays.asList(UserGadgetsMock.createMock(), UserGadgetsMock.createMock());
        GadgetDistributorRepositoryMock gadgetDistributorRepositoryMock = new GadgetDistributorRepositoryMock(userGadgets);
        GadgetDistributorHandler gadgetDistributorHandler = new GadgetDistributorHandler(webClientBuilder, gadgetDistributorRepositoryMock);

        webTestClient = WebTestClient.bindToRouterFunction(route(GET(FIND_ALL_USER_GADGETS)
                .and(accept(MediaType.APPLICATION_JSON_UTF8)), gadgetDistributorHandler::findAll)).build();

        webTestClient.get().uri(FIND_ALL_USER_GADGETS)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody().json("[" + UserGadgetsMock.createRawJsonObject() + ", " + UserGadgetsMock.createRawJsonObject() + "]");
    }

    @Test
    public void findGadgetsByUser_whenGadgetsExistByUserId_returnGadgetsWithHttpStatus200() {
        List<UserGadgets> userGadgets = Arrays.asList(UserGadgetsMock.createMock(), UserGadgetsMock.createMock());
        GadgetDistributorRepositoryMock gadgetDistributorRepositoryMock = new GadgetDistributorRepositoryMock(userGadgets);
        GadgetDistributorHandler gadgetDistributorHandler = new GadgetDistributorHandler(webClientBuilder, gadgetDistributorRepositoryMock);

        webTestClient = WebTestClient.bindToRouterFunction(route(GET(FIND_GADGETS_BY_USER_ENDPOINT)
                .and(accept(MediaType.APPLICATION_JSON_UTF8)), gadgetDistributorHandler::findGadgetsByUser)).build();

        webTestClient.get().uri(FIND_GADGETS_BY_USER_ENDPOINT, UserGadgetsMock.createMock().getUser().getId())
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody().json("[" + GadgetMock.createRawJsonObject() + ", " + GadgetMock.createRawJsonObject() + "]");
    }

    @Test
    public void findGadgetsByUser_whenUserIdNotExist_returnEmptyWithHttpStatus200() {
        List<UserGadgets> userGadgets = Arrays.asList(UserGadgetsMock.createMock(), UserGadgetsMock.createMock());
        GadgetDistributorRepositoryMock gadgetDistributorRepositoryMock = new GadgetDistributorRepositoryMock(userGadgets);
        GadgetDistributorHandler gadgetDistributorHandler = new GadgetDistributorHandler(webClientBuilder, gadgetDistributorRepositoryMock);

        webTestClient = WebTestClient.bindToRouterFunction(route(GET(FIND_GADGETS_BY_USER_ENDPOINT)
                .and(accept(MediaType.APPLICATION_JSON_UTF8)), gadgetDistributorHandler::findGadgetsByUser)).build();


        webTestClient.get().uri(FIND_GADGETS_BY_USER_ENDPOINT, USER_ID_NOT_EXIST)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody().json(EMPTY_JSON_LIST);

    }

    @Test
    public void saveUserGadgets_returnedSavedWithHttpStatus201() {
        UserGadgets userGadget = UserGadgetsMock.createMock();
        GadgetDistributorRepositoryMock gadgetDistributorRepositoryMock = new GadgetDistributorRepositoryMock(Collections.singletonList(userGadget));
        GadgetDistributorHandler gadgetDistributorHandler = new GadgetDistributorHandler(webClientBuilder, gadgetDistributorRepositoryMock);

        webTestClient = WebTestClient.bindToRouterFunction(route(POST(SAVE_USER_GADGET_ENDPOINT)
                .and(accept(MediaType.APPLICATION_JSON_UTF8)), gadgetDistributorHandler::saveUserGadget)).build();

        webTestClient.post().uri(SAVE_USER_GADGET + USER + userGadget.getUser().getId() + GADGET + userGadget.getGadgets().iterator().next().getId())
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isCreated()
                .expectBody().json(UserGadgetsMock.createRawJsonObject());
    }

    @Test
    public void saveUserGadget_whenAlreadyExists_deleteExistingAndSaveWithHttpStatus201() {
        UserGadgets userGadgets = UserGadgetsMock.createMock();
        GadgetDistributorRepositoryMock gadgetDistributorRepositoryMock = new GadgetDistributorRepositoryMock(Collections.singletonList(userGadgets));
        GadgetDistributorHandler gadgetDistributorHandler = new GadgetDistributorHandler(webClientBuilder, gadgetDistributorRepositoryMock);

        webTestClient = WebTestClient.bindToRouterFunction(route(DELETE(DELETE_USER_GADGETS_BY_USER_ENDPOINT)
                .and(accept(MediaType.APPLICATION_JSON_UTF8)), gadgetDistributorHandler::deleteUserGadgetsByUser)).build();

        webTestClient.delete().uri(DELETE_USER_GADGETS_BY_USER_ENDPOINT, userGadgets.getUser().getId())
                .exchange()
                .expectStatus().isNoContent();
    }
}
