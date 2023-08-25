package com.clghks.tdd.payment.domain

import com.clghks.tdd.order.domain.Order
import jakarta.persistence.*
import org.springframework.util.Assert

@Entity
@Table(name = "payments")
class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L

    @OneToOne
    val order: Order
    val cardNumber: String
    constructor(order: Order, cardNumber: String) {
        Assert.notNull(order, "주문은 필수입니다.")
        Assert.hasText(cardNumber, "카드 번호는 필수입니다.")

        this.order = order
        this.cardNumber = cardNumber
    }

    fun getPrice(): Int {
        return order.getTotalPrice()
    }
}