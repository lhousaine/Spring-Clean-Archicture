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
    ShopDto shopDto1;
    ShopDto shopDto2;
    List<ShopDto> shopDs;
    Coordinates coords;

    /***
     *!
     * @throws Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        shopDto1=new ShopDto();
        shopDto1.setName("shop_1");
        shopDto1.setDescription("shop 1 shop 1");
        shopDto1.setLogo("https://shop 1");
        shopDto1.setCoordinates(new Coordinates(50, 20));
        shopDto1.setAddress(new Address("12", "rue 40", "marrakech", "maroc"));

        shopDto2=new ShopDto();
        shopDto2.setName("shop_2");
        shopDto2.setDescription("shop 2 shop 2");
        shopDto2.setLogo("https://shop 2");
        shopDto2.setCoordinates(new Coordinates(30,20));
        shopDto2.setAddress(new Address("123","rue 20","marrakech","maroc"));

        coords=new Coordinates(10, 20);
        shopDs=new ArrayList<>();
        shopDs.add(shopDto1);
        shopDs.add(shopDto2);
    }

    /**
     *
     */
    @Test
    public void whenCalculeDistanceShopToCoordinates(){
        double result=Math.sqrt(Math.pow(shopDto1.getCoordinates().getLatitude()- coords.getLatitude(),2)
                +Math.pow(shopDto1.getCoordinates().getLongitude()-coords.getLongitude(),2));
        assertEquals(result,40);
    }

    /***
     *
     */
    @Test
    public void whenSortShopDtoList(){
        Collections.sort(shopDs, new Comparator<ShopDto>(){
            @Override
            public int compare(ShopDto shd1, ShopDto shd2) {
                int x=0;
                if(shd1.getDistanceToCoordinates(coords)<(shd2.getDistanceToCoordinates(coords)))
                    return 1;
                else
                    return 0;
            }
        });
        assertEquals(shopDs.get(0).getName(),"shop_1");
    }
}
