package com.clghks.tdd.payment.adapter

interface PaymentGateway {
    fun excute(price: Int, cardNumber: String)
}
