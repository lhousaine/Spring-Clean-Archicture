package com.remote.united_shop.data.dto.Converters;

import com.remote.united_shop.data.dto.ShopDto;
import com.remote.united_shop.data.entities.Shop;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;


public class ShopConverter implements AbstractConverter<Shop, ShopDto> {
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ShopDto convertToDto(Shop shop) {
        ShopDto shopDto= modelMapper.map(shop,ShopDto.class);
        return shopDto;
    }

    @Override
    public Shop convertToEntity(ShopDto shopDto) throws ParseException {
        Shop shop=modelMapper.map(shopDto,Shop.class);
        return  shop;
    }
}
