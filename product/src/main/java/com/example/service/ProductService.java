package com.example.service;

import com.example.domain.model.Product;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class ProductService {

    private static final Map<UUID, Product> productMap = Map.of(
            UUID.fromString("bfcd3cc0-dc58-4e20-8c4c-a313de3ad8d9"), new Product()
                    .setName("foo")
                    .setId(UUID.fromString("bfcd3cc0-dc58-4e20-8c4c-a313de3ad8d9")));

    public Uni<Product> findById(UUID id) {
        return Uni.createFrom().item(Optional.ofNullable(productMap.get(id)).orElseThrow());
    }

    public List<Product> allProducts() {
       return productMap.values().stream().toList();
    }
}
