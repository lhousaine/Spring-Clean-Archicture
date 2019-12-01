package com.remote.united_shop.services.ImplServices;

import com.remote.united_shop.Core.Converters.AbstractConverters.AbstractUserConverter;
import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.dto.UserDto;
import com.remote.united_shop.data.entities.AppUser;
import com.remote.united_shop.data.entities.Role;
import com.remote.united_shop.data.entities.Shop;
import com.remote.united_shop.data.repositories.RoleRepository;
import com.remote.united_shop.data.repositories.ShopRepository;
import com.remote.united_shop.data.repositories.UserRepository;
import com.remote.united_shop.services.AbstractService.AbstractUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements AbstractUserService {
    private final UserRepository userRepository;
    private final AbstractUserConverter userConverter;
    private final ShopRepository shopRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleRepository roleRepository;

    /***
     *
     * @param userRepository
     * @param userConverter
     * @param shopRepository
     * @param bCryptPasswordEncoder
     * @param roleRepository
     */

    public UserService(UserRepository userRepository, @Qualifier("UserConverter") AbstractUserConverter userConverter, ShopRepository shopRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.shopRepository = shopRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }

    /**
     *
     * @return
     */
    @Override
    public List<UserDto> getAll() {
        List<AppUser> appUsers =userRepository.findAll();
        return userConverter.convertListToListDto(appUsers);
    }

    /**
     *
     * @param idEntity
     * @return
     * @throws NoDataFoundException
     */
    @Override
    public UserDto getByIdEntity(Long idEntity) throws NoDataFoundException {
        AppUser appUser =userRepository.getOne(idEntity);
        if (appUser==null)
            throw new NoDataFoundException("User identify by "+idEntity+" Not Exit");
        return userConverter.convertToDto(appUser);
    }

    /***
     *
     * @param email
     * @return
     */
    @Override
    public AppUser loadUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    /**
     *
     * @param appUser
     * @return
     * @throws Exception
     */
    @Override
    public UserDto createNewEntity(AppUser appUser) throws Exception {
        AppUser  user=userRepository.findUserByEmail(appUser.getEmail());
        if(user!=null)
            throw new RuntimeException("User already exists");
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        AppUser us=userRepository.save(appUser);
        addRoleToUser(appUser.getEmail(),"USER");
        if(us==null)
            throw new Exception("user is not saved");
        return userConverter.convertToDto(us);
    }

    /**
     *
     * @param email
     * @param rolename
     */
    @Override
    public void addRoleToUser(String email, String rolename) {
        AppUser appUser=userRepository.findUserByEmail(email);
        Role role=roleRepository.findRoleByName(rolename);
        appUser.getRoles().add(role);
    }

    /***
     *
     * @param idEntity
     * @param appUser
     * @return
     * @throws NoDataFoundException
     */
    @Override
    public boolean updateEntity(Long idEntity, AppUser appUser) throws NoDataFoundException {
        AppUser us=userRepository.getOne(idEntity);
        if(us==null)
            throw new NoDataFoundException("No User was identified by "+idEntity);
        us=userRepository.save(appUser);
        return
                us!=null;
    }

    /***
     *
     * @param idEntity
     * @return
     */
    @Override
    public boolean deleteEntity(Long idEntity) {
        try {
            userRepository.deleteById(idEntity);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /***
     *
     * @param idUser
     * @param shopName
     * @return
     * @throws NoDataFoundException
     */
    @Override
    public boolean likeNewShop(long idUser,String shopName) throws NoDataFoundException {
        return this.likeDislikeShops(idUser,shopName,"likeNewShop");
    }

    /***
     *
     * @param idUser
     * @param shopName
     * @return
     * @throws NoDataFoundException
     */
    @Override
    public boolean dislikeNewShop(long idUser,String shopName) throws NoDataFoundException {
        return this.likeDislikeShops(idUser,shopName,"disLikeNewShop");
    }

    /***
     *
     * @param idUser
     * @param shopName
     * @return
     * @throws NoDataFoundException
     */
    @Override
    public boolean removeShopFromPreferredShops(long idUser,String shopName) throws NoDataFoundException {
        return this.likeDislikeShops(idUser,shopName,"removeLikedShop");
    }

    /***
     *
     * @param idUser
     * @param shopName
     * @param operation
     * @return
     * @throws NoDataFoundException
     */
    public boolean likeDislikeShops(long idUser,String shopName,String operation) throws NoDataFoundException {
        AppUser appUser =userRepository.getOne(idUser);
        if (appUser ==null)
            throw new NoDataFoundException("User identified by "+idUser+" Not exist");
        Shop shop=shopRepository.getOne(shopName);
        if (shop==null)
            throw new NoDataFoundException("Shop identified by "+shopName+" Not exist");
        switch (operation){
            case "likeNewShop":
                appUser.addNewLikedShod(shop);
                break;
            case "disLikeNewShop":
                appUser.addNewDislikedShop(shop);
                break;
            case "removeLikedShop":
                appUser.removeLikedShop(shop);
                break;
            default:
                break;
        }
        AppUser us=userRepository.save(appUser);
        return us != null;
    }
}
