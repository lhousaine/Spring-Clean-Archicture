package com.remote.united_shop.Core.Converters.ImplConverters;

import com.remote.united_shop.Core.Converters.AbstractConverters.AbstractUserConverter;
import com.remote.united_shop.Core.Converters.GlobalConverter;
import com.remote.united_shop.data.dto.UserDto;
import com.remote.united_shop.data.entities.AppUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Qualifier("UserConverter")
public class UserConverter implements AbstractUserConverter {
    public UserConverter() {
    }

    /***
     *
     * @param appUser
     * @return
     */
    @Override
    public UserDto convertToDto(AppUser appUser) {
        UserDto userDto=new UserDto();
        GlobalConverter.copyProperties(appUser,userDto);
        return userDto;
    }

    /***
     *
     * @param appUsers
     * @return
     */
    @Override
    public List<UserDto> convertListToListDto(List<AppUser> appUsers) {
        List<UserDto> userDtos=new ArrayList<>();
        UserDto userDto=new UserDto();
        for (AppUser appUser : appUsers) {
            GlobalConverter.copyProperties(appUser,userDto);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    /**+
     *
     * @param userDto
     * @return
     */
    @Override
    public AppUser convertToEntity(UserDto userDto) {
        AppUser appUser =new AppUser();
        GlobalConverter.copyProperties(userDto, appUser);
        return appUser;
    }

    /***
     *
     * @param userDtos
     * @return
     */
    @Override
    public List<AppUser> convertListDtoToListEntity(List<UserDto> userDtos) {
        List<AppUser> appUsers =new ArrayList<>();
        AppUser appUser =new AppUser();
        for (UserDto userDto:userDtos) {
            GlobalConverter.copyProperties(userDto, appUser);
            appUsers.add(appUser);
        }
        return appUsers;
    }
}
