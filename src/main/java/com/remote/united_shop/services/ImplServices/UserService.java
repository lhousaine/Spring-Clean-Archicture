package com.remote.united_shop.services.ImplServices;

import com.remote.united_shop.data.entities.User;
import com.remote.united_shop.data.repositories.UserRepository;
import com.remote.united_shop.services.AbstractService.AbstractUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements AbstractUserService {
    @Autowired
    private UserRepository userRepository;
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
        return userRepository.findAll();
    }

    @Override
    public User getByIdEntity(Long idEntity) {
        return userRepository.getOne(idEntity);
    }

    @Override
    public User createNewEntity(User user) {
        user=userRepository.save(user);
        return user;
    }

    @Override
    public void updateEntity(Long idEntity, User user) {

    }

    @Override
    public void deleteEntity(Long idEntity) {
        userRepository.deleteById(idEntity);
    }
}
