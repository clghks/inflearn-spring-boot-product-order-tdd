package com.clghks.tdd.product.application.service

import com.clghks.tdd.product.domain.DiscountPolicy
import org.springframework.util.Assert

class GetProductResponse {
    var id: Long = 0
    val name: String
    val price: Int
    val discountPolicy: DiscountPolicy

    constructor(id: Long, name: String, price: Int, discountPolicy: DiscountPolicy) {
        Assert.notNull(id, "상품 ID는 필수입니다.")
        Assert.hasText(name, "상품명은 필수입니다.")
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.")

        this.id = id
        this.name = name
        this.price = price
        this.discountPolicy = discountPolicy
    }
}