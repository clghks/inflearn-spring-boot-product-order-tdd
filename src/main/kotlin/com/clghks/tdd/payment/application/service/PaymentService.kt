package com.clghks.tdd.payment.application.service

import com.clghks.tdd.payment.application.port.PaymentPort
import com.clghks.tdd.payment.domain.Payment
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/payments")
class PaymentService(
    private val paymentPort: PaymentPort
) {
    @PostMapping
    fun payment(@RequestBody request: PaymentRequest): ResponseEntity<Void> {
        val order = paymentPort.getOrder(request.orderId)

        val payment = Payment(order, request.cardNumber)
        paymentPort.pay(payment.getPrice(), payment.cardNumber)
        paymentPort.save(payment)

        return ResponseEntity.status(HttpStatus.OK).build()
    }
}