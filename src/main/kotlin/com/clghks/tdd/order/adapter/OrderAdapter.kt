package com.clghks.tdd.order.adapter

import com.clghks.tdd.order.domain.Order
import com.clghks.tdd.order.application.port.OrderPort
import com.clghks.tdd.product.domain.Product
import com.clghks.tdd.product.adpater.ProductRepository
import org.springframework.stereotype.Component

@Component
class OrderAdapter(
    private val productRepository: ProductRepository,
    private val orderRepository: OrderRepository
): OrderPort {
    override fun getProductById(productId: Long): Product {
        return productRepository.findById(productId).orElseThrow {
            IllegalArgumentException("상품이 존재하지 않습니다.")
        }
    }

    override fun save(order: Order) {
        orderRepository.save(order)
    }
}
