package com.example.adapter.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "brand_id")
    private int brandId;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column(name = "price_list")
    private int priceList;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "priority")
    private int priority;
    @Column(name = "price")
    private double price;
    @Column(name = "curr")
    private String currency;

    public int getBrandId() {
        return brandId;
    }
    public LocalDateTime getStartDate() {
        return startDate;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public int getPriceList() {
        return priceList;
    }
    public int getProductId() {
        return productId;
    }
    public double getPrice() {
        return price;
    }
    public static class PriceEntityBuilder {};

}
