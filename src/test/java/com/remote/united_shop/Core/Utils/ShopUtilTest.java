package com.remote.united_shop.Core.Utils;

import com.remote.united_shop.data.dto.ShopDto;
import com.remote.united_shop.data.entities.Address;
import com.remote.united_shop.data.entities.Coordinates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ShopUtilTest {

    private ShopDto shopDto;

    private Coordinates coordinates;
    private List<ShopDto> shops;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        coordinates=new Coordinates(10,20);
        shopDto=new ShopDto();
        shopDto.setName("shop_1");
        shopDto.setDescription("shop 1 shop 1");
        shopDto.setLogo("https://shop 1");
        shopDto.setCoordinates(new Coordinates(50,20));
        shopDto.setAddress(new Address("123","rue 20","marrakech","maroc"));
        ShopDto shopDto1=new ShopDto();
        shopDto1.setName("shop_2");
        shopDto1.setDescription("shop 2 shop 2");
        shopDto1.setLogo("https://shop 2");
        shopDto1.setCoordinates(new Coordinates(30,20));
        shopDto1.setAddress(new Address("123","rue 20","marrakech","maroc"));
        shops=new ArrayList<>();
        shops.add(shopDto1);
        shops.add(shopDto);
    }
    @Test
    public void whenCalculeDistanceShopToCoordinates(){
        double result=Math.sqrt(Math.pow(shopDto.getCoordinates().getLatitude()-coordinates.getLatitude(),2)
                +Math.pow(shopDto.getCoordinates().getLongitude()-coordinates.getLongitude(),2));
        assertEquals(result,Math.sqrt(2));
    }

    @Test
    public void whenSortShopDtoList(){
        Collections.sort(shops, new Comparator<ShopDto>(){
            @Override
            public int compare(ShopDto shd1, ShopDto shd2) {
                int x=0;
                if(shd1.getDistanceToCoordinates(coordinates)<(shd2.getDistanceToCoordinates(coordinates)))
                    return 1;
                else
                    return 0;
            }
        });
        assertEquals(shops.get(0).getName(),"shop_2");
    }
}
