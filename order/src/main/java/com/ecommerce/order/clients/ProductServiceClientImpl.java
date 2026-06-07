package com.ecommerce.order.clients;

import com.ecommerce.order.dto.ProductResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@Component
public class ProductServiceClientImpl implements ProductServiceClient {

    private final RestClient restClient;

    public ProductServiceClientImpl(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("http://PRODUCT-SERVICE")
                .defaultStatusHandler(HttpStatusCode::is4xxClientError, ((request, response) -> Optional.empty()))
                .build();
    }

    @Override
    public ProductResponse getProductDetails(Long id) {
        return restClient.get()
                .uri("/api/products/{id}", id)
                .retrieve()
                .body(ProductResponse.class);
    }
}