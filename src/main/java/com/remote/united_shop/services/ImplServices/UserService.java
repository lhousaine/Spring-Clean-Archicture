package com.remote.united_shop.services.ImplServices;

import com.remote.united_shop.Core.Converters.AbstractConverters.AbstractUserConverter;
import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.dto.UserDto;
import com.remote.united_shop.data.entities.Shop;
import com.remote.united_shop.data.entities.User;
import com.remote.united_shop.data.repositories.ShopRepository;
import com.remote.united_shop.data.repositories.UserRepository;
import com.remote.united_shop.services.AbstractService.AbstractUserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements AbstractUserService {
    private UserRepository userRepository;
    private AbstractUserConverter userConverter;
    private  ShopRepository shopRepository;

    @Autowired
    public UserService(UserRepository userRepository, @Qualifier("UserConverter") AbstractUserConverter userConverter, ShopRepository shopRepository) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.shopRepository = shopRepository;
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users=userRepository.findAll();
        return userConverter.convertListToListDto(users);
    }

    @Override
    public UserDto getByIdEntity(Long idEntity) throws NoDataFoundException {
        User user=userRepository.getOne(idEntity);
        if (user==null)
            throw new NoDataFoundException("User identify by "+idEntity+" Not Exit");
        return userConverter.convertToDto(user);
    }

    @Override
    public UserDto createNewEntity(User user) throws Exception {
        User us=userRepository.save(user);
        if(us==null)
            throw new Exception("user is saved");
        return userConverter.convertToDto(us);
    }

    @Override
    public boolean updateEntity(Long idEntity, User user) throws NoDataFoundException {
        User us=userRepository.getOne(idEntity);
        if(us==null)
            throw new NoDataFoundException("No User was identified by "+idEntity);
        us=userRepository.save(user);
        return
                us!=null;
    }

    @Override
    public boolean deleteEntity(Long idEntity) {
        try {
            userRepository.deleteById(idEntity);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public void likeNewShop(long idUser,String shopName) throws NoDataFoundException {
        this.likeDislikeShops(idUser,shopName,"likeNewShop");
    }

    @Override
    public void dislikeNewShop(long idUser,String shopName) throws NoDataFoundException {
        this.likeDislikeShops(idUser,shopName,"disLikeNewShop");
    }

    @Override
    public void removeShopFromPreferredShops(long idUser,String shopName) throws NoDataFoundException {
        this.likeDislikeShops(idUser,shopName,"removeLikedShop");
    }

    public void likeDislikeShops(long idUser,String shopName,String operation) throws NoDataFoundException {
        User user=userRepository.getOne(idUser);
        if (user==null)
            throw new NoDataFoundException("User identified by "+idUser+" Not exist");
        Shop shop=shopRepository.getOne(shopName);
        if (shop==null)
            throw new NoDataFoundException("Shop identified by "+shopName+" Not exist");
        switch (operation){
            case "likeNewShop":
                user.addNewDislikedShop(shop);
                break;
            case "disLikeNewShop":
                user.addNewDislikedShop(shop);
                break;
            case "removeLikedShop":
                user.removeLikedShop(shop);
                break;
            default:
                break;
        }
        userRepository.save(user);
    }
}
