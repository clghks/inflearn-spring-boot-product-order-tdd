package com.clghks.tdd.order.domain

import com.clghks.tdd.product.domain.Product
import jakarta.persistence.*
import org.springframework.util.Assert

@Entity
@Table(name = "Orders")
class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L

    @OneToOne
    val product: Product
    val quantity: Int

    constructor(product: Product, quantity: Int) {
        Assert.notNull(product, "상품은 필수입니다.")
        Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다.")

        this.product = product
        this.quantity = quantity
    }

    fun getTotalPrice(): Int {
        return product.getDiscountedPrice() * quantity
    }
}
