package com.vk.demo.gadgetdistributor.handler;

import com.vk.demo.gadgetdistributor.handler.mocks.GadgetDistributorRepositoryMock;
import com.vk.demo.gadgetdistributor.handler.mocks.UserGadgetMock;
import com.vk.demo.gadgetdistributor.models.UserGadget;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Collections;
import java.util.List;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@WebFluxTest
@SpringBootTest
public class GadgetDistributorHandlerTest {

    private static final String FIND_GADGETS_BY_USER_ENDPOINT = "/gadgetDistributor/findGadgetsByUser/{userId}";
    private static final String FIND_GADGETS_BY_USER = "/gadgetDistributor/findGadgetsByUser/";
    private static final String SAVE_USER_GADGET_ENDPOINT = "/gadgetDistributor/saveUserGadget/{userId}/{gadgetId}";
    private static final String SAVE_USER_GADGET = "/gadgetDistributor/saveUserGadget/";
    private static final String SLASH = "/";
    private WebTestClient webTestClient;

    @Test
    public void findGadgetsByUser_returnWithHttpStatus200() {
        UserGadget userGadget = UserGadgetMock.createMock();
        List<UserGadget> userGadgets = Collections.singletonList(userGadget);
        GadgetDistributorRepositoryMock gadgetDistributorRepositoryMock = new GadgetDistributorRepositoryMock(userGadgets);
        GadgetDistributorHandler gadgetHandler = new GadgetDistributorHandler(gadgetDistributorRepositoryMock);
        webTestClient = WebTestClient.bindToRouterFunction(route(GET(FIND_GADGETS_BY_USER_ENDPOINT)
                .and(accept(MediaType.APPLICATION_JSON_UTF8)), gadgetHandler::findGadgetsByUser)).build();

        webTestClient.get().uri(FIND_GADGETS_BY_USER + userGadget.getUserId())
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody().json(UserGadgetMock.createRawJsonArray());
    }

    @Test
    public void saveUserGadget_returnedSavedWithHttpStatus201() {
        UserGadget userGadget = UserGadgetMock.createMock();
        List<UserGadget> userGadgets = Collections.singletonList(userGadget);
        GadgetDistributorRepositoryMock gadgetDistributorRepositoryMock = new GadgetDistributorRepositoryMock(userGadgets);
        GadgetDistributorHandler gadgetDistributorHandler = new GadgetDistributorHandler(gadgetDistributorRepositoryMock);
        webTestClient = WebTestClient.bindToRouterFunction(route(POST(SAVE_USER_GADGET_ENDPOINT)
                .and(accept(MediaType.APPLICATION_JSON_UTF8)), gadgetDistributorHandler::saveUserGadget)).build();

        webTestClient.post().uri(SAVE_USER_GADGET + userGadget.getUserId() + SLASH + userGadget.getGadgetId())
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isCreated()
                .expectBody().json(UserGadgetMock.createRawJsonObject());
    }

    @Test
    public void saveUserGadget_whenAlreadyExists_deleteExistingAndSaveWithHttpStatus201() {

    }
}
