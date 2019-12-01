package com.remote.united_shop.web.controllers;

import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.dto.UserDto;
import com.remote.united_shop.data.entities.Address;
import com.remote.united_shop.data.entities.Coordinates;
import com.remote.united_shop.data.entities.AppUser;
import com.remote.united_shop.services.AbstractService.AbstractUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AppUserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private AbstractUserService userService;

    long idUser=1;
    String shopName="shop_1";
    Map<String,String> datas;
    UserDto userDto;
    AppUser appUser;
    List<UserDto> userDtos;

    /***
     *
     * @throws Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        datas=new HashMap<String,String>();
        datas.put("idUser",idUser+"");
        datas.put("shopName",shopName);
        userDto=new UserDto();
        userDto.setFirstName("lhoussaine");
        userDto.setLastName("ouarhou");
        userDto.setEmail("em@gmail.com");
        userDto.setAddress(new Address("123","rue 20","marrakech","maroc"));
        userDto.setCoordinates(new Coordinates(10.1,20.3));

        userDtos= new ArrayList<>();
        userDtos.add(userDto);

        appUser =new AppUser();
        appUser.setFirstName("lhoussaine");
        appUser.setLastName("ouarhou");
        appUser.setEmail("em@gmail.com");
        appUser.setAddress(new Address("123","rue 20","marrakech","maroc"));
        appUser.setCoordinates(new Coordinates(10.1,20.3));
    }

    @Test
    public void whenGetAll() throws NoDataFoundException {
        when(userService.getAll()).thenReturn(userDtos);
        List<UserDto> urs=userController.getAll();
        assertNotNull(urs);
        assertEquals(urs.get(0).getFirstName(),userDtos.get(0).getFirstName());
        assertEquals(urs.get(0).getEmail(),userDtos.get(0).getEmail());
    }

    /***
     *
     * @throws NoDataFoundException
     */
    @Test
    final void testGetAllUsersThrowingException() throws NoDataFoundException {
        when(userService.getAll()).thenThrow();
        assertThrows(Exception.class,
                ()->{
                    userController.getAll();
                }
        );
    }

    /***
     *
     * @throws NoDataFoundException
     */
    @Test
    public void whenGetUser() throws NoDataFoundException {
        when(userService.getByIdEntity(anyLong())).thenReturn(userDto);
        UserDto usD = userController.getUser(idUser);
        assertNotNull(userDto);
        assertEquals(userDto.getEmail(),usD.getEmail());
    }

    /***
     *
     * @throws NoDataFoundException
     */
    @Test
    final void testGetUserThrowingException() throws NoDataFoundException {
        when(userService.getByIdEntity(anyLong())).thenThrow();
        assertThrows(Exception.class,
                ()->{
                    userController.getUser(idUser);
                }
        );
    }

    @Test
    public void whenCreateNewUser() throws Exception {
        when(userService.createNewEntity(anyObject())).thenReturn(userDto);
        UserDto usD = userController.createUser(appUser);
        assertNotNull(usD);
        assertEquals(userDto.getEmail(),usD.getEmail());
    }

    /***
     *
     * @throws Exception
     */
    @Test
    final void testCreateUserThrowingException() throws Exception {
        when(userService.createNewEntity(anyObject())).thenThrow();
        assertThrows(Exception.class,
                ()->{
                    userService.createNewEntity(appUser);
                }
        );
    }

    /***
     *
     * @throws Exception
     */
    @Test
    public void  whenUpdateUser() throws Exception {
        when(userService.updateEntity(anyLong(),anyObject())).thenReturn(true);
        boolean done=userController.updateUser(idUser, appUser);
        verify(userService).updateEntity(anyLong(),anyObject());
        assertEquals(done,true);
    }

    /***
     *
     * @throws NoDataFoundException
     */
    @Test
    final void testUpdateUserThrowingException() throws NoDataFoundException {
        when(userService.updateEntity(anyLong(),anyObject())).thenThrow();
        assertThrows(Exception.class,
                ()->{
                    userService.updateEntity(idUser, appUser);
                }
        );
    }

    /***
     *
     * @throws NoDataFoundException
     */
    @Test
    public void whenDeleteUser() throws NoDataFoundException {
        when(userService.deleteEntity(anyLong())).thenReturn(true);
        boolean done=userController.deleteUser(idUser);
        verify(userService).deleteEntity(anyLong());
        assertEquals(done,true);
    }

    /***
     *
     * @throws NoDataFoundException
     */
    @Test
    final void testDeleteUserThrowingException() throws NoDataFoundException {
        when(userService.deleteEntity(anyLong())).thenThrow();
        assertThrows(Exception.class,
                ()->{
                    userController.deleteUser(idUser);
                }
        );
    }

    /***
     *
     * @throws NoDataFoundException
     */
    @Test
    public void whenLikeNewShop() throws NoDataFoundException {
        when(userService.likeNewShop(anyLong(),anyString())).thenReturn(true);
        boolean done=userController.userLikeNewShop(datas);
        verify(userService).likeNewShop(idUser,shopName);
        assertEquals(done,true);
    }

    /***
     *
     * @throws NoDataFoundException
     */
    @Test
    final void testLikeNewShopThrowingException() throws NoDataFoundException {
        when(userService.likeNewShop(anyLong(),anyString())).thenThrow();
        assertThrows(Exception.class,
                ()->{
                    userController.userLikeNewShop(datas);
                }
        );
    }

    /***
     *
     * @throws NoDataFoundException
     */
    @Test
    public void whenDislikeNewShop() throws NoDataFoundException {
        when(userService.dislikeNewShop(anyLong(),anyString())).thenReturn(true);
        boolean done=userController.userDislikeShop(datas);
        verify(userService).dislikeNewShop(idUser,shopName);
        assertEquals(done,true);
    }

    /***
     *
     * @throws NoDataFoundException
     */
    @Test
    final void testDislikeNewShopThrowingException() throws NoDataFoundException {
        when(userService.dislikeNewShop(anyLong(),anyString())).thenThrow();
        assertThrows(Exception.class,
                ()->{
                    userController.userDislikeShop(datas);
                }
        );
    }

    /**
     *
     * @throws NoDataFoundException
     */
    @Test
    public void whenRemoveLikedShop() throws NoDataFoundException {
        when(userService.removeShopFromPreferredShops(anyLong(),anyString())).thenReturn(true);
        boolean done=userController.userRemoveLikedShop(datas);
        verify(userService).removeShopFromPreferredShops(idUser,shopName);
        assertEquals(done,true);
    }

    /***
     *
     * @throws NoDataFoundException
     */
    @Test
    final void testRemoveLikedShopThrowingException() throws NoDataFoundException {
        when(userService.removeShopFromPreferredShops(anyLong(),anyString())).thenThrow();
        assertThrows(Exception.class,
                ()->{
                    userController.userRemoveLikedShop(datas);
                }
        );
    }
}
