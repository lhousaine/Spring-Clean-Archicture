package com.remote.united_shop.services.ImplServices;


import com.remote.united_shop.Core.Converters.AbstractConverters.AbstractShopConverter;
import com.remote.united_shop.Core.Converters.ImplConverters.ShopConverter;
import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.dto.ShopDto;
import com.remote.united_shop.data.entities.Address;
import com.remote.united_shop.data.entities.Coordinates;
import com.remote.united_shop.data.entities.Shop;
import com.remote.united_shop.data.repositories.ShopRepository;
import com.remote.united_shop.services.AbstractService.AbstractShopService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class ImplShopServiceTest {
    @InjectMocks
    ShopService shopService;

    @Mock
    ShopRepository shopRepository;

    @Mock
    AbstractShopConverter abstractShopConverter;
    Shop shop;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        abstractShopConverter=new ShopConverter();
        shop=new Shop();
        shop.setName("shop_1");
        shop.setDescription("shop 1 shop 1");
        shop.setLogo("https://shop 1");
        shop.setCoordinates(new Coordinates(10,20));
        shop.setAddress(new Address("123","rue 20","marrakech","maroc"));
    }

    @Test
    final void testGetByIdShop() throws NoDataFoundException {
        when(shopRepository.getOne(anyString())).thenReturn(shop);
        ShopDto sh=shopService.getByIdEntity("shop_1");
        assertNotNull(sh);
        assertEquals("shop_1",sh.getName());
    }

    @Test
    final void testGetByIdShopThrowingException()  {
        when(shopRepository.getOne(anyString())).thenReturn(null);
        assertThrows(Exception.class,
                ()->{
                    shopService.getByIdEntity("shop_1");
                }
        );
    }
}
