package com.tddpj.productorderservice.payment;

import com.tddpj.productorderservice.order.Order;

interface PaymentPort {
    Order getOrder(Long aLong);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}
