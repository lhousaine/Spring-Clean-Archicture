package com.remote.united_shop.services.ImplServices;

import com.remote.united_shop.Core.Converters.AbstractConverters.AbstractUserConverter;
import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.dto.UserDto;
import com.remote.united_shop.data.entities.Shop;
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
    @Autowired
    private AbstractUserConverter userConverter;
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
    public UserDto createNewEntity(UserDto userDto) throws Exception {
        User us=userRepository.save(userConverter.convertToEntity(userDto));
        if(us==null)
            throw new Exception("user is saved");
        return userConverter.convertToDto(us);
    }

    @Override
    public void updateEntity(Long idEntity, UserDto userDto) throws NoDataFoundException {
        User us=userRepository.getOne(idEntity);
        if(us==null)
            throw new NoDataFoundException("No User was identified by "+idEntity);
        userRepository.save(userConverter.convertToEntity(userDto));
    }

    @Override
    public void deleteEntity(Long idEntity) {
        userRepository.deleteById(idEntity);
    }
}
