package com.clghks.tdd.product.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.util.Assert

@Entity
@Table(name = "Products")
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var name: String
    var price: Int
    var discountPolicy: DiscountPolicy

    constructor(name: String, price: Int, discountPolicy: DiscountPolicy) {
        Assert.hasText(name, "상품명은 필수입니다.")
        Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.")
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.")

        this.name = name
        this.price = price
        this.discountPolicy = discountPolicy
    }

    fun update(name: String, price: Int, discountPolicy: DiscountPolicy) {
        Assert.hasText(name, "상품명은 필수입니다.")
        Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.")
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.")

        this.name = name
        this.price = price
        this.discountPolicy = discountPolicy
    }

    fun getDiscountedPrice(): Int {
        return discountPolicy.applyDiscount(price)
    }
}