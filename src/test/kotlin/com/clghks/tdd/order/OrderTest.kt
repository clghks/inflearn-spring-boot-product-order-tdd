package com.clghks.tdd.order

import com.clghks.tdd.order.domain.Order
import com.clghks.tdd.product.domain.DiscountPolicy
import com.clghks.tdd.product.domain.Product
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OrderTest {
    @Test
    fun getTotalPrice() {
        val order = Order(Product("상품명", 1000, DiscountPolicy.NONE), 2)
        val totalPrice = order.getTotalPrice()

        assertThat(totalPrice).isEqualTo(2000)
    }

    @Test
    fun fix1000DiscountTotalPrice() {
        val order = Order(Product("상품명", 2000, DiscountPolicy.FIX_1000_AMOUNT), 2)
        val totalPrice = order.getTotalPrice()

        assertThat(totalPrice).isEqualTo(2000)
    }
}