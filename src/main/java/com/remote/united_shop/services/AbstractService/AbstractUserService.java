package com.remote.united_shop.services.AbstractService;

import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.dto.UserDto;
import com.remote.united_shop.data.entities.User;

public interface AbstractUserService extends AbstractService<User,Long, UserDto> {
    public void likeNewShop(long idUser,String shopName) throws NoDataFoundException;
    public void dislikeNewShop(long idUser,String shopName) throws NoDataFoundException;
    public void removeShopFromPreferredShops(long idUser,String shopName) throws NoDataFoundException;
}
