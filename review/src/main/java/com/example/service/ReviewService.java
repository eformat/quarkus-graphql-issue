package com.example.service;

import com.example.domain.model.Product;
import com.example.domain.model.Review;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class ReviewService {

    private static Map<UUID, Review> reviewMap;

    static {
        Review review1 = new Review()
                .setId(UUID.fromString("bfcd3cc0-dc58-4e20-8c4c-a313de3ad8d9"))
                .setText("Nice!")
                .setRating(3)
                .setProduct(new Product()
                        .setId(UUID.fromString("bfcd3cc0-dc58-4e20-8c4c-a313de3ad8d9")));
        review1.getProduct().setReview(review1);
        reviewMap = Map.of(
            UUID.fromString("bfcd3cc0-dc58-4e20-8c4c-a313de3ad8d9"), review1);
    }

    public Uni<Review> findById(UUID id) {
        return Uni.createFrom().item(Optional.ofNullable(reviewMap.get(id)).orElseThrow());
    }

    public Uni<Product> findProductById(UUID id) {
        return Uni.createFrom().item(Optional.ofNullable(reviewMap.get(id).getProduct()).orElseThrow());
    }
}
