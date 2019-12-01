package com.remote.united_shop.Core.Converters.EntityConverters;

import com.remote.united_shop.Core.Converters.GlobalConverter;
import com.remote.united_shop.data.dto.UserDto;
import com.remote.united_shop.data.entities.Address;
import com.remote.united_shop.data.entities.AppUser;
import com.remote.united_shop.data.entities.Coordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppUserConverterDtoTest {
    /***
     * test if the converting from User entity to User dto was succeful or failed
     */
    @Test
    public void whenConvertingUserEntityToDto() {
        AppUser appUser =new AppUser();
        appUser.setFirstName("lhoussaine");
        appUser.setLastName("ouarhou");
        appUser.setEmail("em@gmail.com");
        appUser.setPassword("123456789");
        appUser.setAddress(new Address("123","rue 20","marrakech","maroc"));
        appUser.setCoordinates(new Coordinates(10.1,20.3));

        UserDto userDto=new UserDto();

        GlobalConverter.copyProperties(appUser,userDto);

        assertEquals(appUser.getId(), userDto.getId());
        assertEquals(appUser.getFirstName(), userDto.getFirstName());
        assertEquals(appUser.getLastName(), userDto.getLastName());
        assertEquals(appUser.getEmail(), userDto.getEmail());
        assertEquals(appUser.getAddress(), userDto.getAddress());
        assertEquals(appUser.getCoordinates(), userDto.getCoordinates());
    }

    /***
     * test if the converting from User dto to User entity was succeful or failed
     */
    @Test
    public void whenConvertingDtoToEntity() {
        UserDto userd=new UserDto();
        userd.setFirstName("lhoussaine");
        userd.setLastName("ouarhou");
        userd.setEmail("em@gmail.com");
        userd.setAddress(new Address("123","rue 20","marrakech","maroc"));
        userd.setCoordinates(new Coordinates(10.1,20.3));

        AppUser appUser =new AppUser();

        GlobalConverter.copyProperties(userd, appUser);

        assertEquals(appUser.getId(), userd.getId());
        assertEquals(appUser.getFirstName(), userd.getFirstName());
        assertEquals(appUser.getLastName(), userd.getLastName());
        assertEquals(appUser.getEmail(), userd.getEmail());
        assertEquals(appUser.getAddress(), userd.getAddress());
        assertEquals(appUser.getCoordinates(), userd.getCoordinates());
    }
}
