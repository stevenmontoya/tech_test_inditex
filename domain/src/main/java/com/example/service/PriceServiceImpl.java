package com.example.service;

import com.example.data.PriceDto;
import com.example.error.ProductNotFoundException;
import com.example.ports.PricePersistence;
import com.example.ports.PriceService;

import java.time.LocalDateTime;
import java.util.Optional;

public class PriceServiceImpl implements PriceService {
    private PricePersistence pricePersistence;

    public PriceServiceImpl(PricePersistence pricePersistence) {
        this.pricePersistence = pricePersistence;
    }
    @Override
    public PriceDto getProduct(LocalDateTime date, int productId, int brandId) {
         return  pricePersistence.getPriceByDateAndProductId(date, productId, brandId)
                .stream()
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(String.format("Product not found")));
    }
}
