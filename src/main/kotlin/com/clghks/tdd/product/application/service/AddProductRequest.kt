package com.clghks.tdd.product.application.service

import com.clghks.tdd.product.domain.DiscountPolicy
import org.springframework.util.Assert

class AddProductRequest {
    val name: String
    val price: Int
    val discountPolicy: DiscountPolicy
    constructor(name: String, price: Int, discountPolicy: DiscountPolicy) {
        Assert.hasText(name, "상품명은 필수입니다.")
        Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.")
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.")

        this.name = name
        this.price = price
        this.discountPolicy = discountPolicy
    }
}