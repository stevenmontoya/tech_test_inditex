package com.example.controller;

import com.example.data.PriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ports.PriceService;


import java.time.LocalDateTime;
import java.util.stream.Stream;

@RestController
@RequestMapping("/")
public class PriceController {
    @Autowired
    PriceService priceService;
    @GetMapping("/prices")
    @ResponseBody
    public ResponseEntity<PriceDto> getPrice(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @RequestParam("productId") String productId,
            @RequestParam("brandId") String brandId ) {

        return ResponseEntity.ok(
                priceService.getProduct(date,
                Integer.parseInt(productId),
                Integer.parseInt(brandId)));
    }
}
