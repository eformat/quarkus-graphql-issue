package com.example.domain.model;

import io.smallrye.graphql.api.federation.Key;
import org.eclipse.microprofile.graphql.Id;

import java.util.UUID;

@Key(fields = "id")
public class Product {

    @Id
    private UUID id;

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    private String name;

    public UUID getId() {
        return id;
    }

    public Product setId(UUID id) {
        this.id = id;
        return this;
    }
}
