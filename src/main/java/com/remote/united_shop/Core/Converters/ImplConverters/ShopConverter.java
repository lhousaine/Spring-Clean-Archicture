package com.remote.united_shop.Core.Converters.ImplConverters;

import com.remote.united_shop.Core.Converters.AbstractConverters.AbstractShopConverter;
import com.remote.united_shop.Core.Converters.GlobalConverter;
import com.remote.united_shop.data.dto.ShopDto;
import com.remote.united_shop.data.entities.Shop;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Qualifier("ShopConverter")
public class ShopConverter implements AbstractShopConverter {
    public ShopConverter() {

    }

    @Override
    public ShopDto convertToDto(Shop shop){
        ShopDto shopDto=new ShopDto();
        GlobalConverter.copyProperties(shop,shopDto);
        return shopDto;
    }

    @Override
    public List<ShopDto> convertListToListDto(List<Shop> shops) {
        List<ShopDto> shopDtos=new ArrayList<>();
        ShopDto shopDto=new ShopDto();
        for (Shop user:shops) {
            GlobalConverter.copyProperties(user,shopDto);
            shopDtos.add(shopDto);
        }
        return shopDtos;
    }

    @Override
    public Shop convertToEntity(ShopDto shopDto){
        Shop shop=new Shop();
        GlobalConverter.copyProperties(shopDto,shop);
        return  shop;
    }

    @Override
    public List<Shop> convertListDtoToListEntity(List<ShopDto> shopDtos){
        List<Shop> shops=new ArrayList<>();
        Shop shop=new Shop();
        for (ShopDto shopDto:shopDtos){
            GlobalConverter.copyProperties(shopDto,shop);
            shops.add(shop);
        }
        return shops;
    }
}
