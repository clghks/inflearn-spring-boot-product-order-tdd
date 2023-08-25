package com.clghks.tdd.order.application.service

import org.springframework.util.Assert

class CreateOrderRequest {
    val productId: Long
    val quantity: Int

    constructor(productId: Long, quantity: Int) {
        Assert.notNull(productId, "상품 ID는 필수입니다.")
        Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다.")

        this.productId = productId
        this.quantity = quantity
    }
}