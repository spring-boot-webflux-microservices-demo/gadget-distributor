package com.vk.demo.gadgetdistributor.router;

import com.vk.demo.gadgetdistributor.handler.GadgetDistributorHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RoutingConfig {

    public RouterFunction<ServerResponse> routeGadgetDistributions(GadgetDistributorHandler handler) {
        return route(GET("/gadgetDistributor/findGadgetsByUser/{userId}").and(accept(MediaType.APPLICATION_JSON_UTF8)), handler::findGadgetsByUser)
                .andRoute(POST("/gadgetDistributor/saveUserGadget/{userId}/{gadgetId}").and(accept(MediaType.APPLICATION_JSON_UTF8)), handler::saveUserGadget);
    }
}
