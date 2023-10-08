package com.tddpj.productorderservice.payment;

import com.tddpj.productorderservice.order.Order;

interface PaymentPort {
    Order getOrder(Long orderId);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}
