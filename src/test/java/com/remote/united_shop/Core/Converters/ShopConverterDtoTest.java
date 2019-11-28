package com.remote.united_shop.Core.Converters;

import com.remote.united_shop.Core.Converters.ImplConverters.ShopConverter;
import com.remote.united_shop.data.dto.ShopDto;
import com.remote.united_shop.data.entities.Coordinates;
import com.remote.united_shop.data.entities.Shop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopConverterDtoTest {
    @Test
    public void whenConvertingShopEntityToDto(){
        Shop shop=new Shop();
        shop.setName("shop 1");
        shop.setDescription("shop 1 shop 1");
        shop.setLogo("https://shop 1");
        shop.setCoordinates(new Coordinates(10,20));
        ShopDto shopDto=new ShopDto();
        Converter.copyProperties(shop,shopDto);
        assertEquals(shop.getName(), shopDto.getName());
        assertEquals(shop.getDescription(), shop.getDescription());
        assertEquals(shop.getLogo(), shop.getLogo());
        assertEquals(shop.getCoordinates(), shop.getCoordinates());
        assertEquals(shop.getAddress(), shop.getAddress());
    }

    @Test
    public void whenConvertingShopDtoToEntity(){
        ShopDto shopd=new ShopDto();
        shopd.setName("shop 1");
        shopd.setDescription("shop 1 shop 1");
        shopd.setLogo("https://shop 1");
        shopd.setCoordinates(new Coordinates(10,20));
        Shop shop=new Shop();
        Converter.copyNonNullProperties(shopd,shop);
        assertEquals(shopd.getName(), shop.getName());
        assertEquals(shopd.getDescription(), shop.getDescription());
        assertEquals(shopd.getLogo(), shop.getLogo());
        assertEquals(shopd.getCoordinates(), shop.getCoordinates());
        assertEquals(shopd.getAddress(), shop.getAddress());
    }
}
