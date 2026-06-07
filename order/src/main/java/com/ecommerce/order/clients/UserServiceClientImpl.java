package com.ecommerce.order.clients;

import com.ecommerce.order.dto.UserResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@Component
public class UserServiceClientImpl implements UserServiceClient {

    private final RestClient restClient;

    public UserServiceClientImpl(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("http://USER-SERVICE")
                .defaultStatusHandler(HttpStatusCode::is4xxClientError, ((request, response) -> Optional.empty()))
                .build();
    }


    @Override
    public UserResponse getUserDetails(String userId) {
        return restClient.get()
                .uri("/api/users/{id}", userId)
                .retrieve()
                .body(UserResponse.class);
    }
}
