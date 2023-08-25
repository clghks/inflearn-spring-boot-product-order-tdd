package com.clghks.tdd.order.application.port

import com.clghks.tdd.order.domain.Order
import com.clghks.tdd.product.domain.Product

interface OrderPort {
    fun getProductById(productId: Long): Product
    fun save(order: Order)
}