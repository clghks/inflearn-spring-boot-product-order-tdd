package com.clghks.tdd.product.adpater

import com.clghks.tdd.product.domain.Product
import com.clghks.tdd.product.application.port.ProductPort
import org.springframework.stereotype.Component
import java.lang.IllegalArgumentException

@Component
class ProductAdapter(
    private val productRepository: ProductRepository
): ProductPort {
    override fun save(product: Product) {
        productRepository.save(product)
    }

    override fun getProduct(productId: Long): Product {
        return productRepository.findById(productId).orElseThrow { throw IllegalArgumentException("상품이 존재하지 않습니다.") }
    }
}