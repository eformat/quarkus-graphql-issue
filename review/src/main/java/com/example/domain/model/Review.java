package com.example.domain.model;

import io.smallrye.graphql.api.federation.*;
import org.eclipse.microprofile.graphql.Id;

import java.util.UUID;

@Key(fields = "id")
public class Review {

    @Id
    private UUID id;

    private String text;

    private Integer rating;

    private Product product;

    public UUID getId() {
        return id;
    }

    public Review setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getText() {
        return text;
    }

    public Review setText(String text) {
        this.text = text;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public Review setProduct(Product product) {
        this.product = product;
        return this;
    }

    public Integer getRating() {
        return rating;
    }

    public Review setRating(Integer rating) {
        this.rating = rating;
        return this;
    }
}
