package com.example.adapter.mappers;

import com.example.adapter.entity.PriceEntity;
import com.example.data.PriceDto;
import com.example.data.PriceDto.PriceDtoBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-22T11:56:09+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Homebrew)"
)
public class PriceMapperImpl implements PriceMapper {

    @Override
    public PriceDto priceToPriceDto(PriceEntity priceEntity) {
        if ( priceEntity == null ) {
            return null;
        }

        PriceDtoBuilder priceDto = PriceDto.builder();

        priceDto.product_id( priceEntity.getProductId() );
        priceDto.brand_id( priceEntity.getBrandId() );
        priceDto.price_list( priceEntity.getPriceList() );
        priceDto.start_date( priceEntity.getStartDate() );
        priceDto.end_date( priceEntity.getEndDate() );
        priceDto.price( priceEntity.getPrice() );

        return priceDto.build();
    }

    @Override
    public List<PriceDto> priceListToPriceDtoList(List<PriceEntity> prices) {
        if ( prices == null ) {
            return null;
        }

        List<PriceDto> list = new ArrayList<PriceDto>( prices.size() );
        for ( PriceEntity priceEntity : prices ) {
            list.add( priceToPriceDto( priceEntity ) );
        }

        return list;
    }
}
