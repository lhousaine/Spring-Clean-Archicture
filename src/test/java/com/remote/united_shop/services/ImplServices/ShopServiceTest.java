package com.remote.united_shop.services.ImplServices;


import com.remote.united_shop.Core.Converters.AbstractConverters.AbstractShopConverter;
import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.dto.ShopDto;
import com.remote.united_shop.data.entities.Address;
import com.remote.united_shop.data.entities.Coordinates;
import com.remote.united_shop.data.entities.Shop;
import com.remote.united_shop.data.repositories.ShopRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShopServiceTest {
    @InjectMocks
    ShopService shopService;

    @Mock
    ShopRepository shopRepository;

    @Mock
    @Qualifier("ShopConverter")
    AbstractShopConverter abstractShopConverter;

    Shop shop;
    ShopDto shopDto;
    List<Shop> shops;
    List<ShopDto> shopDtos;
    private final String shopName="shop_1";

    /***
     *
     * @throws Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        shop=new Shop();
        shop.setName("shop_1");
        shop.setDescription("shop 1 shop 1");
        shop.setLogo("https://shop 1");
        shop.setCoordinates(new Coordinates(10,20));
        shop.setAddress(new Address("123","rue 20","marrakech","maroc"));
        shopDto=new ShopDto();
        shopDto.setName("shop_1");
        shopDto.setDescription("shop 1 shop 1");
        shopDto.setLogo("https://shop 1");
        shopDto.setCoordinates(new Coordinates(10,20));
        shopDto.setAddress(new Address("123","rue 20","marrakech","maroc"));
        shops=new ArrayList<>();
        shops.add(shop);
        shopDtos=new ArrayList<>();
        shopDtos.add(shopDto);
    }

    /**
     *
     * @throws NoDataFoundException
     */
    @Test
    final void testGetByIdShop() throws NoDataFoundException {
        when(shopRepository.getOne(1l)).thenReturn(shop);
        ShopDto sh=shopService.getByIdEntity(1l);
        verify(shopRepository).getOne(1l);
        verify(abstractShopConverter).convertToDto(shop);
        assertNotNull(sh);
        assertEquals("shop_1",sh.getName());
    }

    /***
     *
     */
    @Test
    final void testGetByIdShopThrowingException()  {
        when(shopRepository.getOne(anyLong())).thenReturn(null);
        assertThrows(Exception.class,
                ()->{
                    shopService.getByIdEntity(1l);
                }
        );
    }

    /**
     *
     * @throws NoDataFoundException
     */
    @Test
    public void whenGetAllShops() throws NoDataFoundException {
        when(shopRepository.findAll()).thenReturn(shops);

        List<ShopDto> shs=shopService.getAll();
        verify(shopRepository).findAll();
        verify(abstractShopConverter).convertListToListDto(shops);
        assertNotNull(shs);
        assertEquals(shs.get(0).getName(),shops.get(0).getName());
    }

    /**
     *
     */
    @Test
    final void testGetAllShopsThrowingException()  {
        when(shopRepository.findAll()).thenReturn(null);
        when(abstractShopConverter.convertListToListDto(anyList())).thenReturn(null);
        assertThrows(Exception.class,
                ()->{
                    shopService.getAll();
                }
        );
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void whenCreateShop() throws Exception {
        when(shopRepository.save(anyObject())).thenReturn(shop);
        ShopDto shD=shopService.createNewEntity(shop);
        verify(shopRepository).save(shop);
        verify(abstractShopConverter).convertToDto(shop);
        assertNotNull(shD);
        assertEquals(shop.getName(),shD.getName());
    }

    /**
     *
     */
    @Test
    final void testCreateShopThrowingException()  {
        when(shopRepository.save(shop)).thenReturn(null);
        when(abstractShopConverter.convertToDto(shop)).thenReturn(null);
        assertThrows(Exception.class,
                ()->{
                    shopService.createNewEntity(shop);
                }
        );
    }

    /***
     *
     * @throws Exception
     */
    @Test
    public void  whenUpdateShop() throws Exception {
        when(shopRepository.getOne(anyLong())).thenReturn(shop);
        when(shopRepository.save(anyObject())).thenReturn(shop);
        boolean done=shopService.updateEntity(1l,shop);
        verify(shopRepository).getOne(1l);
        verify(shopRepository).save(shop);
        assertEquals(done,true);
    }

    /**
     *
     */
    @Test
    final void testUpdateShopThrowingException()  {
        when(shopRepository.save(shop)).thenReturn(null);
        when(abstractShopConverter.convertToDto(shop)).thenReturn(null);
        assertThrows(Exception.class,
                ()->{
                    shopService.updateEntity(1l,shop);
                }
        );
    }

    /**
     *
     * @throws NoDataFoundException
     */
    @Test
    public void whenDeleteShop() throws NoDataFoundException {
        when(shopRepository.getOne(1l)).thenReturn(shop);
        boolean done=shopService.deleteEntity(1l);
        verify(shopRepository).deleteById(1l);
        assertEquals(done,true);
    }

    /**
     *
     */
    @Test
    final void testDeleteShopThrowingException()  {
        when(shopRepository.getOne(1l)).thenReturn(null);
        assertThrows(Exception.class,
                ()->{
                    shopService.deleteEntity(1l);
                }
        );
    }
}
