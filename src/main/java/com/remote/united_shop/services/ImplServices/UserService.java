package com.remote.united_shop.services.ImplServices;

import com.remote.united_shop.data.entities.User;
import com.remote.united_shop.services.AbstractService.AbstractUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements AbstractUserService {

    @Override
    public void likeNewShop(String ShopName) {

    }

    @Override
    public void dislikeShop(String ShopName) {

    }

    @Override
    public void removeShopFromPreferredShops(String ShopName) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getByIdEntity(String idEntity) {
        return null;
    }

    @Override
    public User createNewEntity(User user) {
        return null;
    }

    @Override
    public void updateEntity(String idEntity, User user) {

    }

    @Override
    public String deleteEntity(String idEntity) {
        return null;
    }
}
