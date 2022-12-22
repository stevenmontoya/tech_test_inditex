package com.example.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceDto {
    private int product_id;
    private int brand_id;
    private int price_list;
    private double price;
    private LocalDateTime start_date;
    private LocalDateTime end_date;

}
