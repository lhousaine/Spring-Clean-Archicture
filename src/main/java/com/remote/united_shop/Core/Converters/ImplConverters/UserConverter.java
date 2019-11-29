package com.remote.united_shop.Core.Converters.ImplConverters;

import com.remote.united_shop.Core.Converters.AbstractConverters.AbstractUserConverter;
import com.remote.united_shop.Core.Converters.GlobalConverter;
import com.remote.united_shop.data.dto.UserDto;
import com.remote.united_shop.data.entities.User;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Qualifier("UserConverter")
public class UserConverter implements AbstractUserConverter {
    public UserConverter() {
    }

    @Override
    public UserDto convertToDto(User user) {
        UserDto userDto=new UserDto();
        GlobalConverter.copyProperties(user,userDto);
        return userDto;
    }

    @Override
    public List<UserDto> convertListToListDto(List<User> users) {
        List<UserDto> userDtos=new ArrayList<>();
        UserDto userDto=new UserDto();
        for (User user:users) {
            GlobalConverter.copyProperties(user,userDto);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    public User convertToEntity(UserDto userDto) {
        User user=new User();
        GlobalConverter.copyProperties(userDto,user);
        return user;
    }

    @Override
    public List<User> convertListDtoToListEntity(List<UserDto> userDtos) {
        List<User> users=new ArrayList<>();
        User user=new User();
        for (UserDto userDto:userDtos) {
            GlobalConverter.copyProperties(userDto,user);
            users.add(user);
        }
        return users;
    }
}
