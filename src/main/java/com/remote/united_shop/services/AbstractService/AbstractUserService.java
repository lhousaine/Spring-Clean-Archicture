package com.remote.united_shop.services.AbstractService;

import com.remote.united_shop.data.dto.UserDto;
import com.remote.united_shop.data.entities.Coordinates;
import com.remote.united_shop.data.entities.Shop;
import com.remote.united_shop.data.entities.User;

import java.util.List;

public interface AbstractUserService extends AbstractService<User,Long, UserDto> {
    public void likeNewShop(String ShopName);
    public void dislikeShop(String ShopName);
    public void removeShopFromPreferredShops(String ShopName);
}
