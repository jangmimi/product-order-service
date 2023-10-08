package com.tddpj.productorderservice.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void update() {
        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);

        product.update("상품 수정", 2000, DiscountPolicy.NONE);

        Assertions.assertThat(product.getName()).isEqualTo("상품 수정");
        Assertions.assertThat(product.getPrice()).isEqualTo(2000);
    }

    @Test
    void fix_discounted_product() {
        final Product product = new Product("상품명", 1000, DiscountPolicy.FIX_1000_AMOUNT);

        final int discountPrice = product.getDiscountedPrice();

        assertThat(discountPrice).isEqualTo(0);
    }
}
