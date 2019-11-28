package com.remote.united_shop.Core.Converters.ImplConverters;

import com.remote.united_shop.Core.Converters.AbstractConverters.AbstractUserConverter;
import com.remote.united_shop.Core.Converters.Converter;
import com.remote.united_shop.data.dto.UserDto;
import com.remote.united_shop.data.entities.User;

import java.text.ParseException;

public class UserConverter implements AbstractUserConverter {

    @Override
    public UserDto convertToDto(User user) {
        UserDto userDto=new UserDto();
        Converter.copyNonNullProperties(user,userDto);
        return userDto;
    }

    @Override
    public User convertToEntity(UserDto userDto) {
        User user=new User();
        Converter.copyNonNullProperties(userDto,user);
        return user;
    }
}
