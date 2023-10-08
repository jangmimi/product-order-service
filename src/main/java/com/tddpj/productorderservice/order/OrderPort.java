package com.tddpj.productorderservice.order;

import com.tddpj.productorderservice.product.Product;

interface OrderPort {
    Product getProductById(Long productId);

    void save(Order order);
}
