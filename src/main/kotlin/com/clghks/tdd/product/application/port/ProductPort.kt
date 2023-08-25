package com.clghks.tdd.product.application.port

import com.clghks.tdd.product.domain.Product

interface ProductPort {
    fun save(product: Product)
    fun getProduct(productId: Long): Product
}