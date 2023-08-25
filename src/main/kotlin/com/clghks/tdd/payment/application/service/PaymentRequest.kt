package com.clghks.tdd.payment.application.service

import org.springframework.util.Assert

class PaymentRequest {
    val orderId: Long
    val cardNumber: String
    constructor(orderId: Long, cardNumber: String) {
        Assert.notNull(orderId, "주문번호는 필수입니다.")
        Assert.hasText(cardNumber, "카드 번호는 필수입니다.")

        this.orderId = orderId
        this.cardNumber = cardNumber
    }
}