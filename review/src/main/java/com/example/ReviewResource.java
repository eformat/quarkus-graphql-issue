package com.example;

import com.example.domain.model.Product;
import com.example.domain.model.Review;
import com.example.service.ReviewService;
import io.smallrye.graphql.api.federation.Provides;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import java.util.UUID;

@GraphQLApi
public class ReviewResource {

    @Inject
    ReviewService service;

    @Query("reviewById")
    @Description("Find review by ID")
    public Uni<Review> getReviewById(UUID id) {
        return service.findById(id);
    }

    @Query("productById")
    @Description("Find product by ID")
    public Uni<Product> getProductById(UUID id) {
        return service.findProductById(id);
    }

}
