package com.clghks.tdd.payment

import com.clghks.tdd.ApiTest
import com.clghks.tdd.order.OrderSteps
import com.clghks.tdd.product.ProductSteps
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus

class PaymentApiTest: ApiTest() {
    @Test
    fun `상품주문`() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성())
        OrderSteps.상품주문요청(OrderSteps.상품주문요청_생성())
        val response = PaymentSteps.주문결제요청(PaymentSteps.주문결제요청_생성())

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value())
    }
}