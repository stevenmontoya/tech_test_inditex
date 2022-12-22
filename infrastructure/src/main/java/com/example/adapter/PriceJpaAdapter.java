package com.example.adapter;

import com.example.data.PriceDto;
import com.example.adapter.mappers.PriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ports.PricePersistence;
import com.example.adapter.respository.PriceRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceJpaAdapter implements PricePersistence {
    @Autowired
    private PriceRepository priceRepository;

    @Override
    public List<PriceDto> getPriceByDateAndProductId(LocalDateTime date, int productId, int brandId) {
        List<PriceDto> priceDtoList = PriceMapper.INSTANCE.priceListToPriceDtoList(priceRepository.findPriceByProductIdAndBrandIdAndDate(date, productId, brandId));
        System.out.println(priceDtoList);
        return priceDtoList;
    }
}
