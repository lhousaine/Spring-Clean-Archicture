package com.remote.united_shop.services.ImplServices;


import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.dto.ShopDto;
import com.remote.united_shop.data.entities.Coordinates;
import com.remote.united_shop.data.entities.Shop;
import com.remote.united_shop.data.repositories.ShopRepository;
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

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    final void testGetByIdShop() throws NoDataFoundException {
       Shop shop=new Shop();
       shop.setName("shop 1");
       shop.setDescription("shop 1 shop 1");
       shop.setLogo("https://shop 1");
       shop.setCoordinates(new Coordinates(10,20));
       when(shopRepository.getOne(anyString())).thenReturn(shop);
       ShopDto sh=shopService.getByIdEntity("shop 1");
       assertNotNull(sh);
       assertEquals("shop 1",sh.getName());
    }

    @Test
    final void testGetByIdShopThrowingException()  {
        when(shopRepository.getOne(anyString())).thenReturn(null);
        assertThrows(Exception.class,
                ()->{
                    shopService.getByIdEntity("shop 1");
                }
        );
    }
}
