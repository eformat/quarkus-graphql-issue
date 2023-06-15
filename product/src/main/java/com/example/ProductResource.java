package com.example;

import com.example.domain.model.Product;
import com.example.service.ProductService;
import io.smallrye.graphql.api.federation.Provides;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;
import java.util.UUID;

@GraphQLApi
public class ProductResource {

    @Inject
    ProductService service;

    @Query("productById")
    @Description("Find product by ID")
    @Provides(fields = "id")
    public Uni<Product> getProductById(UUID id) {
        return service.findById(id);
    }

    @Query("allProducts")
    @Description("All Products")
    public List<Product> allProducts() {
        return service.allProducts();
    }

}
