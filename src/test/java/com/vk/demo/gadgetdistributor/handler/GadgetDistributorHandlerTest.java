package com.vk.demo.gadgetdistributor.handler;

import com.vk.demo.gadgetdistributor.handler.mocks.GadgetDistributorRepositoryMock;
import com.vk.demo.gadgetdistributor.handler.mocks.UserGadgetsMock;
import com.vk.demo.gadgetdistributor.handler.mocks.webclient.WebClientBuilderMock;
import com.vk.demo.gadgetdistributor.models.UserGadgets;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
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
    private static final String FIND_ALL_USER_GADGETS = "/gadgetDistributor/findAll";
    private static final String SAVE_USER_GADGET_ENDPOINT = "/gadgetDistributor/saveUserGadget/{userId}/{gadgetId}";
    private static final String SAVE_USER_GADGET = "/gadgetDistributor/saveUserGadget/";
    private static final String SLASH = "/";
    private WebTestClient webTestClient;

    private WebClient.Builder webClientBuilder;

    @Test
    public void findAll() {
        webClientBuilder = new WebClientBuilderMock();

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
//                .expectBody().json("");
    }

/*    @Test
    public void findGadgetsByUser_returnWithHttpStatus200() {
        UserGadgets userGadget = UserGadgetsMock.createMock();
        List<UserGadgets> userGadgets = Collections.singletonList(userGadget);
        GadgetDistributorRepositoryMock gadgetDistributorRepositoryMock = new GadgetDistributorRepositoryMock(userGadgets);
        Api1ClientMock api1ClientMock = new Api1ClientMock();
        GadgetDistributorHandler gadgetHandler = new GadgetDistributorHandler(new WebClient.Builder(), gadgetDistributorRepositoryMock);
        webTestClient = WebTestClient.bindToRouterFunction(route(GET(FIND_GADGETS_BY_USER_ENDPOINT)
                .and(accept(MediaType.APPLICATION_JSON_UTF8)), gadgetHandler::findGadgetsByUser)).build();

        webTestClient.get().uri(FIND_GADGETS_BY_USER + userGadget.getUser().getId())
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody().json(UserGadgetsMock.createRawJsonArray());
    }
    */
    @Test
    public void saveUserGadgets_returnedSavedWithHttpStatus201() {
        webClientBuilder = new WebClientBuilderMock();

        UserGadgets userGadget = UserGadgetsMock.createMock();
        List<UserGadgets> userGadgets = Collections.singletonList(userGadget);
        GadgetDistributorRepositoryMock gadgetDistributorRepositoryMock = new GadgetDistributorRepositoryMock(userGadgets);
        GadgetDistributorHandler gadgetDistributorHandler = new GadgetDistributorHandler(webClientBuilder, gadgetDistributorRepositoryMock);
        webTestClient = WebTestClient.bindToRouterFunction(route(POST(SAVE_USER_GADGET_ENDPOINT)
                .and(accept(MediaType.APPLICATION_JSON_UTF8)), gadgetDistributorHandler::saveUserGadget)).build();

        webTestClient.post().uri(SAVE_USER_GADGET + userGadget.getUser().getId() + SLASH + userGadget.getGadgets().iterator().next().getId())
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isCreated()
                .expectBody().json(UserGadgetsMock.createRawJsonObject());
    }

    @Test
    public void saveUserGadget_whenAlreadyExists_deleteExistingAndSaveWithHttpStatus201() {

    }
}
