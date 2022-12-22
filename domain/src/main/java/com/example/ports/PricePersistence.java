package com.example.ports;

import com.example.data.PriceDto;

import java.time.LocalDateTime;
import java.util.List;

public interface PricePersistence {
    List<PriceDto> getPriceByDateAndProductId(LocalDateTime date, int productId, int brandId);
}
