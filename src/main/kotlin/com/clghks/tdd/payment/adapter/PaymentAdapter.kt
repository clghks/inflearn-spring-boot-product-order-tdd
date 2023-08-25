package com.clghks.tdd.payment.adapter

import com.clghks.tdd.order.domain.Order
import com.clghks.tdd.order.adapter.OrderRepository
import com.clghks.tdd.payment.application.port.PaymentPort
import com.clghks.tdd.payment.domain.Payment
import org.springframework.stereotype.Component

@Component
class PaymentAdapter(
    private val paymentGateway: PaymentGateway,
    private val paymentRepository: PaymentRepository,
    private val orderRepository: OrderRepository
): PaymentPort {
    override fun getOrder(orderId: Long): Order {
        return orderRepository.findById(orderId).orElseThrow { IllegalArgumentException("주문이 존재하지 않습니다.") }
    }

    override fun pay(price: Int, cardNumber: String) {
        paymentGateway.excute(price, cardNumber)
    }

    override fun save(payment: Payment) {
        paymentRepository.save(payment)
    }
}