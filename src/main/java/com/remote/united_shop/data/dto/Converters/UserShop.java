package com.remote.united_shop.data.dto.Converters;

import com.remote.united_shop.data.dto.UserDto;
import com.remote.united_shop.data.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;

public class UserShop implements AbstractConverter<User, UserDto>{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto convertToDto(User user) {
        UserDto userDto= modelMapper.map(user,UserDto.class);
        return userDto;
    }

    @Override
    public User convertToEntity(UserDto userDto) throws ParseException {
        User user=modelMapper.map(userDto,User.class);
        return  user;
    }
}
