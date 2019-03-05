package com.richard.webflux.config.routers;

import com.richard.webflux.config.handlers.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class UserRouter {

    public static final String USERS = "/users";

    @Bean
    public RouterFunction<ServerResponse> router(UserHandler handler) {
        return RouterFunctions
                .route(GET(USERS).and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET(USERS.concat("/{id}")).and(accept(MediaType.APPLICATION_JSON)), handler::findById)
                .andRoute(POST(USERS).and(accept(MediaType.APPLICATION_JSON)), handler::save);
    }
}
