package com.remote.united_shop.services.ImplServices;

import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.dto.ShopDto;
import com.remote.united_shop.data.dto.UserDto;
import com.remote.united_shop.data.entities.Address;
import com.remote.united_shop.data.entities.Coordinates;
import com.remote.united_shop.data.entities.User;
import com.remote.united_shop.data.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class ImplUserServiceTest {
    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    final void testGetByIdShop() throws NoDataFoundException {
        User user=new User();
        user.setFirstName("lhoussaine");
        user.setLastName("ouarhou");
        user.setEmail("em@gmail.com");
        user.setPassword("123456789");
        user.setAddress(new Address("123","rue 20","marrakech","maroc"));
        user.setCoordinates(new Coordinates(10.1,20.3));
        when(userRepository.getOne(anyLong())).thenReturn(user);
        UserDto sh=userService.getByIdEntity(1l);
        assertNotNull(sh);
        assertEquals("em@gmail.com",sh.getEmail());
    }

    @Test
    final void testGetByIdShopThrowingException()  {
        when(userRepository.getOne(anyLong())).thenReturn(null);
        assertThrows(Exception.class,
                ()->{
                    userService.getByIdEntity(1l);
                }
        );
    }
}
