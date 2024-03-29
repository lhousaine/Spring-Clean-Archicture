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
    /**
     *
     * @param shop
     * @return
     */
    @Override
    public ShopDto convertToDto(Shop shop){
        ShopDto shopDto=new ShopDto();
        GlobalConverter.copyProperties(shop,shopDto);
        return shopDto;
    }

    /***
     *
     * @param shops
     * @return
     */
    @Override
    public List<ShopDto> convertListToListDto(List<Shop> shops) {
        List<ShopDto> shopDtos= new ArrayList<>();
        ShopDto shopDto=new ShopDto();
        for (Shop shop:shops) {
            GlobalConverter.copyProperties(shop,shopDto);
            shopDtos.add(shopDto);
        }
        return shopDtos;
    }

    /***
     *
     * @param shopDto
     * @return
     */
    @Override
    public Shop convertToEntity(ShopDto shopDto){
        Shop shop=new Shop();
        GlobalConverter.copyProperties(shopDto,shop);
        return  shop;
    }

    /***
     *
     * @param shopDtos
     * @return
     */
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
