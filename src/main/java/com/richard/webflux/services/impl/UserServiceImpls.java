package com.richard.webflux.services.impl;

import com.richard.webflux.model.User;
import com.richard.webflux.repositories.UserRepository;
import com.richard.webflux.services.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpls implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpls(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> save(User user){
        return userRepository.save(user);
    }

    public Flux<User> findAll(){
        return userRepository.findAll();
    }

    public Mono<User> findById(String id){
        return userRepository.findById(id);
    }


}
