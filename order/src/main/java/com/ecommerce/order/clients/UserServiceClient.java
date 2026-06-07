package com.ecommerce.order.clients;

import com.ecommerce.order.dto.UserResponse;

public interface UserServiceClient {

    UserResponse getUserDetails(String userId);

}
