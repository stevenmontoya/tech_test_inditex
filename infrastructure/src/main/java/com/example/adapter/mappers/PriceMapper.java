package com.example.adapter.mappers;

import com.example.data.PriceDto;
import com.example.adapter.entity.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper()
public interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    @Mapping(source = "productId", target = "product_id")
    @Mapping(source = "brandId", target = "brand_id")
    @Mapping(source = "priceList", target = "price_list")
    @Mapping(source = "startDate", target = "start_date")
    @Mapping(source = "endDate", target = "end_date")
    PriceDto priceToPriceDto(PriceEntity priceEntity);
    List<PriceDto> priceListToPriceDtoList(List<PriceEntity> prices);
}
