package com.example.domain.model;

import io.smallrye.graphql.api.federation.Extends;
import io.smallrye.graphql.api.federation.Key;
import org.eclipse.microprofile.graphql.Id;

import java.util.UUID;

@Extends
@Key(fields = "id")
public class Product {

    @Id
    private UUID id;

    private Review review;

    public UUID getId() {
        return id;
    }

    public Product setId(UUID id) {
        this.id = id;
        return this;
    }

    public Review getReview() {
        return review;
    }

    public Review setReview(Review review) {
        this.review = review;
        return this.getReview();
    }
}
