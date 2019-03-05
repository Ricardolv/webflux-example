package com.richard.webflux.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Setter
@Getter
@Document
public class User {

    @Id
    private String id;
    private String name;
}
