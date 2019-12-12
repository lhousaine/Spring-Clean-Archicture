package com.remote.united_shop.services.ImplServices;

import com.remote.united_shop.Core.Converters.AbstractConverters.AbstractUserConverter;
import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.dto.UserDto;
import com.remote.united_shop.data.entities.Address;
import com.remote.united_shop.data.entities.AppUser;
import com.remote.united_shop.data.entities.Coordinates;
import com.remote.united_shop.data.entities.Role;
import com.remote.united_shop.data.repositories.RoleRepository;
import com.remote.united_shop.data.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AppUserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Mock
    RoleRepository roleRepository;

    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Mock
    @Qualifier("UserConverter")
    AbstractUserConverter userConverter;

    AppUser appUser;
    UserDto userDto;
    List<UserDto> userDtos;
    long idUser=1;
    String email="em@gmail.com";
    String rolename="USER";
    Role role;

    /**
     *
     * @throws Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        role=new Role(rolename);
        userDtos=new ArrayList<>();
        appUser =new AppUser();
        appUser.setFirstName("lhoussaine");
        appUser.setLastName("ouarhou");
        appUser.setEmail("em@gmail.com");
        appUser.setPassword("123456789");
        appUser.setAddress(new Address("123","rue 20","marrakech","maroc"));
        appUser.setCoordinates(new Coordinates(10.1,20.3));

        userDto=new UserDto();
        userDto.setFirstName("lhoussaine");
        userDto.setLastName("ouarhou");
        userDto.setEmail("em@gmail.com");
        userDto.setAddress(new Address("123","rue 20","marrakech","maroc"));
        userDto.setCoordinates(new Coordinates(10.1,20.3));
    }

    /**
     *
     * @throws NoDataFoundException
     */
    @Test
    final void testGetByIdUser() throws NoDataFoundException {
        when(userRepository.getOne(anyLong())).thenReturn(appUser);
        UserDto usd=userService.getByIdEntity(idUser);
        verify(userRepository).getOne(idUser);
        verify(userConverter).convertToDto(appUser);
        assertNotNull(usd);
        assertEquals("em@gmail.com",usd.getEmail());
    }

    /***
     *
     */
    @Test
    final void testGetByIdUserThrowingException()  {
        when(userRepository.getOne(anyLong())).thenReturn(null);
        assertThrows(NoDataFoundException.class,
                ()->{
                    userService.getByIdEntity(idUser);
                }
        );
    }

    /**
     *
     */
    @Test
    public void whenLoadUserByEmail() throws NoDataFoundException {
        when(userRepository.findUserByEmail(anyString())).thenReturn(appUser);
        AppUser us=userService.loadUserByEmail(email);
        verify(userRepository).findUserByEmail(email);
        assertNotNull(us);
        assertEquals(email,us.getEmail());
    }

    @Test
    public void addRoleToUser() {
        when(userRepository.findUserByEmail(anyString())).thenReturn(appUser);
        when(roleRepository.findRoleByName(anyString())).thenReturn(role);
        userService.addRoleToUser(email,rolename);
        verify(userRepository).findUserByEmail(email);
        verify(roleRepository).findRoleByName(rolename);
        assertEquals(appUser.getRoles().contains(role),true);
    }
    /***
     *
     * @throws Exception
     */

    @Test
    public void whenCreateUser() throws Exception {
        when(userRepository.save(anyObject())).thenReturn(appUser);
        when(userConverter.convertToDto(anyObject())).thenReturn(userDto);

        UserDto usD=userService.createNewEntity(appUser);
        verify(userRepository).save(appUser);
        verify(bCryptPasswordEncoder).encode(appUser.getPassword());
        verify(userService).addRoleToUser(email,rolename);
        verify(userConverter).convertToDto(appUser);

        assertNotNull(usD);
        assertEquals((appUser).getId(),usD.getId());
        assertEquals((appUser).getEmail(),usD.getEmail());
    }

    /**
     *
     */
    @Test
    final void testCreateExistingUserThrowingException()  {
        when(userRepository.findUserByEmail(anyString())).thenReturn(null);
        assertThrows(Exception.class,
                ()->{
                    userService.createNewEntity(appUser);
                }
        );
    }

    @Test
    final void testUserNotSavedThrowingException()  {
        when(userRepository.save(anyObject())).thenReturn(null);
        assertThrows(Exception.class,
                ()->{
                    userService.createNewEntity(appUser);
                }
        );
    }
    /**
     *
     * @throws Exception
     */
    @Test
    public void  whenUpdateUser() throws Exception {
        when(userRepository.getOne(anyLong())).thenReturn(appUser);
        when(userRepository.save(anyObject())).thenReturn(appUser);
        boolean done=userService.updateEntity(idUser, appUser);
        verify(userRepository).getOne(idUser);
        verify(userRepository).save(appUser);
        assertEquals(done,true);
    }

    /**
     *
     */
    @Test
    final void testUpdateUserThrowingException()  {
        when(userRepository.save(appUser)).thenReturn(null);
        when(userConverter.convertToDto(appUser)).thenReturn(null);
        assertThrows(NoDataFoundException.class,
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
        when(userRepository.getOne(idUser)).thenReturn(appUser);
        boolean done=userService.deleteEntity(idUser);
        verify(userRepository).deleteById(idUser);
        assertEquals(done,true);
    }

    /***
     *
     */
    @Test
    final void testDeleteUserThrowingException()  {
        when(userRepository.getOne(idUser)).thenReturn(null);
        assertThrows(NoDataFoundException.class,
                ()->{
                    userService.deleteEntity(idUser);
                }
        );
    }
}
