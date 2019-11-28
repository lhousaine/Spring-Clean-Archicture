package com.remote.united_shop.Core.Converters.ImplConverters;

import com.remote.united_shop.Core.Converters.AbstractConverters.AbstractUserConverter;
import com.remote.united_shop.Core.Converters.Converter;
import com.remote.united_shop.data.dto.UserDto;
import com.remote.united_shop.data.entities.User;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class UserConverter implements AbstractUserConverter {
    public UserConverter() {
    }

    @Override
    public UserDto convertToDto(User user) {
        UserDto userDto=new UserDto();
        Converter.copyNonNullProperties(user,userDto);
        return userDto;
    }

    @Override
    public List<UserDto> convertListToListDto(List<User> users) {
        List<UserDto> userDtos=new ArrayList<>();
        UserDto userDto=new UserDto();
        for (User user:users) {
            Converter.copyNonNullProperties(user,userDto);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    public User convertToEntity(UserDto userDto) {
        User user=new User();
        Converter.copyNonNullProperties(userDto,user);
        return user;
    }

    @Override
    public List<User> convertListDtoToListEntity(List<UserDto> userDtos) {
        List<User> users=new ArrayList<>();
        User user=new User();
        for (UserDto userDto:userDtos) {
            Converter.copyNonNullProperties(userDto,user);
            users.add(user);
        }
        return users;
    }
}
