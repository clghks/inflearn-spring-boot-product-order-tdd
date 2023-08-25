package com.clghks.tdd.payment.application.port

import com.clghks.tdd.order.domain.Order
import com.clghks.tdd.payment.domain.Payment

interface PaymentPort {
    fun getOrder(orderId: Long): Order
    fun pay(price: Int, cardNumber: String)
    fun save(payment: Payment)
}