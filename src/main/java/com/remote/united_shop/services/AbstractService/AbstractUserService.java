package com.remote.united_shop.services.AbstractService;

import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.dto.UserDto;
import com.remote.united_shop.data.entities.AppUser;

public interface AbstractUserService extends AbstractService<AppUser,Long, UserDto> {
    public boolean likeNewShop(long idUser,String shopName) throws NoDataFoundException;
    public boolean dislikeNewShop(long idUser,String shopName) throws NoDataFoundException;
    public boolean removeShopFromPreferredShops(long idUser,String shopName) throws NoDataFoundException;
    public AppUser loadUserByEmail(String email);
    public void addRoleToUser(String username, String rolename);
}
