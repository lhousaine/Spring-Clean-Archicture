package com.remote.united_shop.web.controllers;

import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.dto.ShopDto;
import com.remote.united_shop.data.entities.Address;
import com.remote.united_shop.data.entities.Coordinates;
import com.remote.united_shop.data.entities.Shop;
import com.remote.united_shop.services.AbstractService.AbstractShopService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


public class ShopControllerTest {
    @InjectMocks
    private ShopController shopController;

    @Mock
    private AbstractShopService shopService;

    String shopName="shop_1";
    ShopDto shopDto;
    Shop shop;
    List<ShopDto> shops;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        shopDto=new ShopDto();
        shopDto.setName("shop_1");
        shopDto.setDescription("shop 1 shop 1");
        shopDto.setLogo("https://shop 1");
        shopDto.setCoordinates(new Coordinates(10,20));
        shopDto.setAddress(new Address("123","rue 20","marrakech","maroc"));
        shops=new ArrayList<>();
        shops.add(shopDto);
    }

    @Test
    public void whenGetAll() throws NoDataFoundException {
        when(shopService.getAll()).thenReturn(shops);
        List<ShopDto> shs=shopController.getAll();
        assertNotNull(shs);
        assertEquals(shs.get(0).getName(),shops.get(0).getName());
        assertEquals(shs.get(0).getDescription(),shops.get(0).getDescription());
        assertEquals(shs.get(0).getLogo(),shops.get(0).getLogo());
        assertEquals(shs.get(0).getCoordinates(),shops.get(0).getCoordinates());
        assertEquals(shs.get(0).getAddress(),shops.get(0).getAddress());
    }

    @Test
    public void whenGetShop() throws NoDataFoundException {
    when(shopService.getByIdEntity(anyString())).thenReturn(shopDto);
     ShopDto sh=shopController.getShop("shop_1");
     assertNotNull(sh);
     assertEquals(shopDto.getName(),sh.getName());
    }

    @Test
    public void whenCreateShop() throws Exception {
        when(shopService.createNewEntity(anyObject())).thenReturn(shopDto);
        ShopDto sh=shopController.createShop(shop);
        assertNotNull(sh);
        assertEquals(shopDto.getName(),sh.getName());
    }

    @Test
    public void  whenUpdateShop() throws Exception {
        when(shopService.updateEntity(anyString(),anyObject())).thenReturn(true);
        boolean done=shopController.updateShop(shopName,shop);
        assertEquals(done,true);
    }


    @Test
    public void whenDeleteShop() {
        when(shopService.deleteEntity(anyString())).thenReturn(true);
        boolean done=shopController.deleteShop(shopName);
        assertEquals(done,true);
    }
}
