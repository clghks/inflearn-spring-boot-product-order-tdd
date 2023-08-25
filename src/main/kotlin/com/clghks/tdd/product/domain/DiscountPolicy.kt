package com.clghks.tdd.product.domain

enum class DiscountPolicy {
    NONE {
        override fun applyDiscount(price: Int): Int {
            return price
        }
    },
    FIX_1000_AMOUNT {
        override fun applyDiscount(price: Int): Int {
            return (price - 1000).coerceAtLeast(0)
        }
    };

    abstract fun applyDiscount(price: Int): Int
}