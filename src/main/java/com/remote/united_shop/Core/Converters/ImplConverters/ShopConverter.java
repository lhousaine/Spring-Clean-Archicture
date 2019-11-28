package com.remote.united_shop.Core.Converters.ImplConverters;

import com.remote.united_shop.Core.Converters.AbstractConverters.AbstractShopConverter;
import com.remote.united_shop.Core.Converters.Converter;
import com.remote.united_shop.data.dto.ShopDto;
import com.remote.united_shop.data.entities.Shop;

import java.text.ParseException;


public class ShopConverter implements AbstractShopConverter {

    @Override
    public ShopDto convertToDto(Shop shop){
        ShopDto shopDto=new ShopDto();
        Converter.copyProperties(shop,shopDto);
        return shopDto;
    }

    @Override
    public Shop convertToEntity(ShopDto shopDto){
        Shop shop=new Shop();
        Converter.copyNonNullProperties(shopDto,shop);
        return  shop;
    }
}
