package com.clghks.tdd.payment.adapter

import org.springframework.stereotype.Component

@Component
class ConsolePaymentGateway: PaymentGateway {
    override fun excute(price: Int, cardNumber: String) {
        print("결제 완료")
    }
}