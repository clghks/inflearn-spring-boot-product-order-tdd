package com.clghks.tdd.product

import com.clghks.tdd.product.domain.DiscountPolicy
import com.clghks.tdd.product.domain.Product
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProductTest {

    @Test
    fun update() {
        val product = Product("상품명", 1000, DiscountPolicy.NONE)
        product.update("상품 수정", 2000, DiscountPolicy.NONE)

        assertThat(product.name).isEqualTo("상품 수정")
        assertThat(product.price).isEqualTo(2000)
    }

    @Test
    fun noneDiscountedProduct() {
        val product = Product("상품명", 1000, DiscountPolicy.NONE)
        val discountedPrice = product.getDiscountedPrice()

        assertThat(discountedPrice).isEqualTo(1000)
    }

    @Test
    fun fix1000DiscountedProduct() {
        val product = Product("상품명", 1000, DiscountPolicy.FIX_1000_AMOUNT)
        val discountedPrice = product.getDiscountedPrice()

        assertThat(discountedPrice).isEqualTo(0)
    }
}