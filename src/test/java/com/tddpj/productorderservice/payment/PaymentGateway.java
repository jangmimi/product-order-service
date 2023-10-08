package com.tddpj.productorderservice.payment;

interface PaymentGateway {
    void excute(int totalPrice, String cardNumber);
}
