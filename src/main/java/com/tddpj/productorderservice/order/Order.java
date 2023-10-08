package com.tddpj.productorderservice.order;

import com.tddpj.productorderservice.product.Product;
import org.springframework.util.Assert;

class Order {
    private Long id;
    private final Product product;
    private final int quantity;

    public Order(Product product, int quantity) {
        Assert.notNull(product, "상품은 필수입니다.");
        Assert.isTrue(quantity > 0, "수량은 0보다 커야힙니다.");
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
