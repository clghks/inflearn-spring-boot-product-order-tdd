package com.clghks.tdd.order

import com.clghks.tdd.ApiTest
import com.clghks.tdd.product.ProductSteps
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus

class OrderApiTest: ApiTest() {
    @Test
    fun `상품주문`() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성())
        val response = OrderSteps.상품주문요청(OrderSteps.상품주문요청_생성())

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value())
    }
}