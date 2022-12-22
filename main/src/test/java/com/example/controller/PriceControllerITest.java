package com.example.controller;

import com.example.data.PriceDto;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class PriceControllerITest {
  @LocalServerPort
  private int port;

  String baseUrl = "http://localhost:";
  RestTemplate restTemplate;
  private final LocalDateTime NOT_FOUND_APPLICATION_DATE = LocalDateTime.parse("2019-01-16T21:00:00");
  private final String PRODUCT_NOT_FOUND_ERROR = "Product not found";
  private int PRODUCT_ID = 35455;
  private final int BRAND_ID = 1;

  private Map<String, String> buildUrlVariables(String applicationDate) {
    Map<String, String> urlVariables = new HashMap<>();
    urlVariables.put("date", applicationDate);
    urlVariables.put("productId", Integer.toString(PRODUCT_ID));
    urlVariables.put("brandId", Integer.toString(BRAND_ID));

    return urlVariables;
  }

  private PriceDto productPriceFactory(int priceList, double productPrice, String startDate, String endDate) {
    return PriceDto
            .builder()
            .product_id(PRODUCT_ID)
            .brand_id(BRAND_ID)
            .price_list(priceList)
            .price(productPrice)
            .start_date(LocalDateTime.parse(startDate))
            .end_date(LocalDateTime.parse(endDate))
            .build();
  }

  @BeforeEach
  void setup() {
    restTemplate = new RestTemplate();
    baseUrl =  baseUrl + port;
  }

  @Test
  @DisplayName("Request at 10:00 on 14th to product 35355 and brand 1")
  void testGetPrices1() {
    Map<String, String> urlVariables = buildUrlVariables("2020-06-14T10:00:00.000Z");
    PriceDto expectedProductPrice = productPriceFactory(
            1,
            35.5,
            "2020-06-14T02:00:00",
            "2021-01-01T00:59:59");

    ResponseEntity<PriceDto> response = restTemplate
            .getForEntity(
                    (baseUrl + "/api/prices?date={date}&productId={productId}&brandId={brandId}"),
                    PriceDto.class, urlVariables);

    assert(response.getStatusCode()).equals(HttpStatus.OK);
    assert(response.getBody()).equals(expectedProductPrice);
  }

  @Test
  @DisplayName("Request at 16:00 on 14th to product 35355 and brand 1")
  void testGetPrices2() {
    Map<String, String> urlVariables = buildUrlVariables("2020-06-14T16:00:00.000Z");
    PriceDto expectedProductPrice = productPriceFactory(
            1,
            35.5,
            "2020-06-14T02:00:00",
            "2021-01-01T00:59:59");


    ResponseEntity<PriceDto> response = restTemplate
            .getForEntity(
                    (baseUrl + "/api/prices?date={date}&productId={productId}&brandId={brandId}"),
                    PriceDto.class, urlVariables);

    assert(response.getStatusCode()).equals(HttpStatus.OK);
    assert(response.getBody()).equals(expectedProductPrice);
  }

  @Test
  @DisplayName("Request at 21:00 on 14th to product 35355 and brand 1")
  void testGetPrices3() {
    Map<String, String> urlVariables = buildUrlVariables("2020-06-14T21:00:00.000Z");
    PriceDto expectedProductPrice = productPriceFactory(
            1,
            35.5,
            "2020-06-14T02:00:00",
            "2021-01-01T00:59:59");


    ResponseEntity<PriceDto> response = restTemplate
            .getForEntity(
                    (baseUrl + "/api/prices?date={date}&productId={productId}&brandId={brandId}"),
                    PriceDto.class, urlVariables);

    assert(response.getStatusCode()).equals(HttpStatus.OK);
    assert(response.getBody()).equals(expectedProductPrice);
  }

  @Test
  @DisplayName("Request at 10:00 on 15th to product 35355 and brand 1")
  void testGetPrices4() {
    Map<String, String> urlVariables = buildUrlVariables("2020-06-15T10:00:00.000Z");
    PriceDto expectedProductPrice = productPriceFactory(
            3,
            30.5,
            "2020-06-15T02:00:00",
            "2020-06-15T13:00:00");


    ResponseEntity<PriceDto> response = restTemplate
            .getForEntity(
                    (baseUrl + "/api/prices?date={date}&productId={productId}&brandId={brandId}"),
                    PriceDto.class, urlVariables);

    assert(response.getStatusCode()).equals(HttpStatus.OK);
    assert(response.getBody()).equals(expectedProductPrice);
  }

  @Test
  @DisplayName("Request at 21:00 on 16th to product 35355 and brand 1")
  void testGetPrices5() {
    Map<String, String> urlVariables = buildUrlVariables("2020-06-16T21:00:00.000Z");
    PriceDto expectedProductPrice = productPriceFactory(
            4,
            38.95,
            "2020-06-15T18:00:00",
            "2021-01-01T00:59:59");


    ResponseEntity<PriceDto> response = restTemplate
            .getForEntity(
                    (baseUrl + "/api/prices?date={date}&productId={productId}&brandId={brandId}"),
                    PriceDto.class, urlVariables);

    assert(response.getStatusCode()).equals(HttpStatus.OK);
    assert(response.getBody()).equals(expectedProductPrice);
  }



}
