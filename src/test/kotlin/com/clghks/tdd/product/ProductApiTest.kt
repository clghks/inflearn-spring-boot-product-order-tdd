package com.clghks.tdd.product

import com.clghks.tdd.ApiTest
import com.clghks.tdd.product.adpater.ProductRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus

class ProductApiTest: ApiTest() {

    @Autowired
    private lateinit var productRepository: ProductRepository

    @Test
    fun `상품등록`() {
        val request = ProductSteps.상품등록요청_생성()
        val response = ProductSteps.상품등록요청(request)

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value())
    }

    @Test
    fun `상품조회`() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성())
        val productId = 1L

        val response = ProductSteps.상품조회요청(productId)

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value())
        assertThat(response.jsonPath().getString("name")).isEqualTo("상품명")
    }

    @Test
    fun `상품수정`() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성())
        val productId = 1L

        val response = ProductSteps.상품수정요청(productId)

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value())
        assertThat(productRepository.findById(productId).get().name).isEqualTo("상품 수정")
    }
}