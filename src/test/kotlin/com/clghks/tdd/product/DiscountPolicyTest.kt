package com.clghks.tdd.product

import com.clghks.tdd.product.domain.DiscountPolicy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DiscountPolicyTest {
    @Test
    fun noneDiscountPolicy() {
        val price = 1000
        val discountPrice = DiscountPolicy.NONE.applyDiscount(price)

        assertThat(discountPrice).isEqualTo(price)
    }

    @Test
    fun fix1000DiscountPolicy() {
        val price = 2000
        val discountPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price)

        assertThat(discountPrice).isEqualTo(1000)
    }

    @Test
    fun overDiscountedPrice() {
        val price = 500
        val discountPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price)

        assertThat(discountPrice).isEqualTo(0)
    }
}