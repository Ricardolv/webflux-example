package com.richard.webflux.services;

import com.richard.webflux.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<User> save(User user);

    Flux<User> findAll();

    Mono<User> findById(String id);

}
