package com.ecommerce.order.clients;

import com.ecommerce.order.dto.ProductResponse;

public interface ProductServiceClient {

    ProductResponse getProductDetails(Long id);
}