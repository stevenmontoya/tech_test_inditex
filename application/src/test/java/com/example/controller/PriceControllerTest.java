package com.example.controller;

import com.example.data.PriceDto;
import com.example.error.ProductNotFoundException;
import com.example.ports.PriceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceControllerTest {
    private final LocalDateTime APPLICATION_DATE = LocalDateTime.parse("2020-06-16T21:00:00");
    private final LocalDateTime NOT_FOUND_APPLICATION_DATE = LocalDateTime.parse("2019-01-16T21:00:00");
    private final LocalDateTime START_DATE = LocalDateTime.parse("2020-06-15T18:00:00");
    private final LocalDateTime END_DATE = LocalDateTime.parse("2021-01-01T00:59:59");

    private final String PRODUCT_NOT_FOUND_ERROR = "Product not found";
    private int PRODUCT_ID = 35455;
    private final int BRAND_ID = 1;
    private double PRODUCT_PRICE = 38.95;
    private final int PRICE_LIST = 4;
    private final PriceDto EXPECTED_PRICE_DTO = PriceDto
            .builder()
            .product_id(PRODUCT_ID)
            .brand_id(BRAND_ID)
            .price_list(PRICE_LIST)
            .price(PRODUCT_PRICE)
            .start_date(START_DATE)
            .end_date(END_DATE)
            .build();

    @Mock
    private PriceService priceService;

    @InjectMocks
    private PriceController priceController;

    @Test
    public void shouldReturnOkStatusCode() {
        when(priceService.getProduct(APPLICATION_DATE, PRODUCT_ID,  BRAND_ID)
        ).thenReturn(EXPECTED_PRICE_DTO);

        ResponseEntity<PriceDto> response =  priceController.getPrice(APPLICATION_DATE, Integer.toString(PRODUCT_ID), Integer.toString(BRAND_ID));

        assert(response.getStatusCode()).equals(HttpStatus.OK);
    }

    @Test
    public void shouldReturnExpectedProductPrice() {
        when(priceService.getProduct(APPLICATION_DATE, PRODUCT_ID,  BRAND_ID)
        ).thenReturn(EXPECTED_PRICE_DTO);

        ResponseEntity<PriceDto> response = priceController.getPrice(
                APPLICATION_DATE,
                Integer.toString(PRODUCT_ID),
                Integer.toString(BRAND_ID));

        assert(response.getBody()).equals(EXPECTED_PRICE_DTO);
    }

    @Test()
    public void shouldReturnExpectedProductNotFoundException() throws RuntimeException {
        when(priceService.getProduct(NOT_FOUND_APPLICATION_DATE, PRODUCT_ID,  BRAND_ID)
        ).thenThrow(new ProductNotFoundException(PRODUCT_NOT_FOUND_ERROR));

        try {
            priceController.getPrice(
                  NOT_FOUND_APPLICATION_DATE,
                  Integer.toString(PRODUCT_ID),
                  Integer.toString(BRAND_ID));

        } catch (ProductNotFoundException e) {
            assert(e.getMessage()).equals(PRODUCT_NOT_FOUND_ERROR);
        }

    }

}
