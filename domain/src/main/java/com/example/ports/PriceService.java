package com.example.ports;

import com.example.data.PriceDto;

import java.time.LocalDateTime;

public interface PriceService {
    PriceDto getProduct(LocalDateTime date, int productId, int brandId);
}
