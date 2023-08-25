package com.clghks.tdd.product.application.service

import com.clghks.tdd.product.domain.Product
import com.clghks.tdd.product.application.port.ProductPort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductService(
    private val productPort: ProductPort
) {
    @PostMapping
    fun addProduct(@RequestBody request: AddProductRequest): ResponseEntity<Void> {
        val product = Product(request.name, request.price, request.discountPolicy)
        productPort.save(product)

        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @GetMapping("/{productId}")
    fun getProduct(@PathVariable productId: Long): ResponseEntity<GetProductResponse> {
        val product = productPort.getProduct(productId)
        return ResponseEntity.ok(GetProductResponse(product.id, product.name, product.price, product.discountPolicy))
    }

    @PatchMapping("/{productId}")
    @Transactional
    fun updateProduct(@PathVariable productId: Long, @RequestBody request: UpdateProductRequest): ResponseEntity<Void> {
        val product = productPort.getProduct(productId)
        product.update(request.name, request.price, request.discountPolicy)

        productPort.save(product)

        return ResponseEntity.ok().build()
    }
}