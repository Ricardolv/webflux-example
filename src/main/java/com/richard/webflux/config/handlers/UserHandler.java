package com.richard.webflux.config.handlers;


import com.richard.webflux.model.User;
import com.richard.webflux.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    @Autowired
    UserService userService;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok()
               .contentType(MediaType.APPLICATION_JSON)
               .body(userService.findAll(), User.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userService.findById(id), User.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<User> user = request.bodyToMono(User.class);
        return ok()
               .contentType(MediaType.APPLICATION_JSON)
               .body(fromPublisher(user.flatMap(userService::save), User.class));
    }
}
