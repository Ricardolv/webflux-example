package com.richard.webflux.services;

import com.richard.webflux.model.User;
import com.richard.webflux.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

//@Component
public class Data implements CommandLineRunner {

    private final UserRepository userRepository;

    public Data(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        this.userRepository.deleteAll()
                .thenMany(
                        Flux.just("Geraldo","Rosa", "Leonardo",
                                  "Richard", "Liliane", "Bernardo", "Maressa",
                                  "Allan", "Fernanda", "Hadassa", "Yohana")
                        .map(name -> new User(UUID.randomUUID().toString(), name))
                        .flatMap(userRepository::save))
                        .subscribe(System.out::println);
    }
}
