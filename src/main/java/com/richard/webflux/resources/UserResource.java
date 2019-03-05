package com.richard.webflux.resources;

import com.richard.webflux.model.User;
import com.richard.webflux.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RestController
//@RequestMapping(value = "/users")
public class UserResource {

    //@Autowired
    UserService userService;

    //@GetMapping
    public Flux<User> userList() {
        return  userService.findAll();
    }

    //@GetMapping(value = "/{id}")
    public Mono<User> userId(@PathVariable String id) {
        return userService.findById(id);
    }

    //@PostMapping
    public Mono<User> save(@RequestBody User user) {
        return userService.save(user);
    }

}
