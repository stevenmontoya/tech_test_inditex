package com.example.configuration;

import com.example.adapter.PriceJpaAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.ports.PricePersistence;
import com.example.ports.PriceService;
import com.example.service.PriceServiceImpl;

@Configuration
public class PriceConfig {
    @Bean
    public PricePersistence pricePersistence() {
        return new PriceJpaAdapter();
    }

    @Bean
    public PriceService priceService() {
        return new PriceServiceImpl(pricePersistence());
    }
}
