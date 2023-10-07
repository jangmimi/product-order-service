package com.tddpj.productorderservice.product;

import com.tddpj.productorderservice.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ProductApiTest extends ApiTest {

    @Autowired
    ProductService productService;

    @Test
    void 상품등록() {
        var request = ProductSteps.상품등록요청_생성();

        // API 요청
        var response = ProductSteps.상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
//        productService.addProduct(request);
    }

    @Test
    void 상품조회() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        Long productId = 1L;

        final ExtractableResponse<Response> response = RestAssured.given().log().all()
                .when()
                .get("/products/{productId}", productId)
                .then().log().all()
                .extract();
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
    }
}