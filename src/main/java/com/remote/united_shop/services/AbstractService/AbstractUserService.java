package com.remote.united_shop.services.AbstractService;

import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.dto.ShopDto;
import com.remote.united_shop.data.dto.UserDto;
import com.remote.united_shop.data.entities.AppUser;

import java.util.List;

public interface AbstractUserService extends AbstractService<AppUser,Long, UserDto> {
    public ShopDto likeNewShop(String email, String shopName) throws Exception;
    public ShopDto dislikeNewShop(String email, String shopName) throws Exception;
    public ShopDto removeShopFromPreferredShops(String email, String shopName) throws Exception;
    public List<ShopDto> preferredShopsToUser(String email) throws NoDataFoundException;
    public AppUser loadUserByEmail(String email) throws NoDataFoundException;
    public UserDto findUserByEmail(String email) throws NoDataFoundException;
    public void addRoleToUser(String username, String rolename);
}
