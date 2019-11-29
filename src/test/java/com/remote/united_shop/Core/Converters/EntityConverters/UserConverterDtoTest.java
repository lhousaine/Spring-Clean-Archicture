package com.remote.united_shop.Core.Converters.EntityConverters;

import com.remote.united_shop.Core.Converters.GlobalConverter;
import com.remote.united_shop.data.dto.UserDto;
import com.remote.united_shop.data.entities.Address;
import com.remote.united_shop.data.entities.Coordinates;
import com.remote.united_shop.data.entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserConverterDtoTest {
    @Test
    public void whenConvertingUserEntityToDto() {
        User user=new User();
        user.setFirstName("lhoussaine");
        user.setLastName("ouarhou");
        user.setEmail("em@gmail.com");
        user.setPassword("123456789");
        user.setAddress(new Address("123","rue 20","marrakech","maroc"));
        user.setCoordinates(new Coordinates(10.1,20.3));

        UserDto userDto=new UserDto();

        GlobalConverter.copyProperties(user,userDto);

        assertEquals(user.getUserId(), userDto.getUserId());
        assertEquals(user.getFirstName(), userDto.getFirstName());
        assertEquals(user.getLastName(), userDto.getLastName());
        assertEquals(user.getEmail(), userDto.getEmail());
        assertEquals(user.getAddress(), userDto.getAddress());
        assertEquals(user.getCoordinates(), userDto.getCoordinates());
    }

    @Test
    public void whenConvertingDtoToEntity() {
        UserDto userd=new UserDto();
        userd.setFirstName("lhoussaine");
        userd.setLastName("ouarhou");
        userd.setEmail("em@gmail.com");
        userd.setAddress(new Address("123","rue 20","marrakech","maroc"));
        userd.setCoordinates(new Coordinates(10.1,20.3));

        User user=new User();

        GlobalConverter.copyProperties(userd,user);

        assertEquals(user.getUserId(), userd.getUserId());
        assertEquals(user.getFirstName(), userd.getFirstName());
        assertEquals(user.getLastName(), userd.getLastName());
        assertEquals(user.getEmail(), userd.getEmail());
        assertEquals(user.getAddress(), userd.getAddress());
        assertEquals(user.getCoordinates(), userd.getCoordinates());
    }
}
