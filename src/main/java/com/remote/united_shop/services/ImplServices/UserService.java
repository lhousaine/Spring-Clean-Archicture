package com.remote.united_shop.services.ImplServices;

import com.remote.united_shop.Core.Converters.AbstractConverters.AbstractUserConverter;
import com.remote.united_shop.Core.Converters.ImplConverters.ShopConverter;
import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.dto.ShopDto;
import com.remote.united_shop.data.dto.UserDto;
import com.remote.united_shop.data.entities.AppUser;
import com.remote.united_shop.data.entities.Role;
import com.remote.united_shop.data.entities.Shop;
import com.remote.united_shop.data.repositories.RoleRepository;
import com.remote.united_shop.data.repositories.ShopRepository;
import com.remote.united_shop.data.repositories.UserRepository;
import com.remote.united_shop.services.AbstractService.AbstractUserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserService implements AbstractUserService {
    private final UserRepository userRepository;
    private final AbstractUserConverter userConverter;
    private final ShopRepository shopRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleRepository roleRepository;
    private final ShopConverter shopConverter;
    /***
     * @param userRepository
     * @param userConverter
     * @param shopRepository
     * @param bCryptPasswordEncoder
     * @param roleRepository
     * @param shopConverter
     */

    public UserService(UserRepository userRepository, @Qualifier("UserConverter") AbstractUserConverter userConverter, ShopRepository shopRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository, ShopConverter shopConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.shopRepository = shopRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
        this.shopConverter = shopConverter;
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
    public AppUser loadUserByEmail(String email) throws NoDataFoundException {
        AppUser us=userRepository.findUserByEmail(email);
        if (us==null)
            throw new NoDataFoundException("User identify by "+email+" Not Exit");
        return us;
    }
    /***
     *
     * @param email
     * @return
     */
    @Override
    public UserDto findUserByEmail(String email) throws NoDataFoundException {
        AppUser us=userRepository.findUserByEmail(email);
        if (us==null)
            throw new NoDataFoundException("User identify by "+email+" Not Exit");
        return userConverter.convertToDto(us);
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
     * @param email
     * @param shopName
     * @return
     * @throws NoDataFoundException
     */
    @Override
    public ShopDto likeNewShop(String email, String shopName) throws Exception {
        return this.likeDislikeShops(email,shopName,"likeNewShop");
    }

    /***
     *
     * @param email
     * @param shopName
     * @return
     * @throws NoDataFoundException
     */
    @Override
    public ShopDto dislikeNewShop(String email, String shopName) throws Exception {
        return this.likeDislikeShops(email,shopName,"disLikeNewShop");
    }

    /***
     *
     * @param email
     * @param shopName
     * @return
     * @throws NoDataFoundException
     */
    @Override
    public ShopDto removeShopFromPreferredShops(String email,String shopName) throws Exception {
        return this.likeDislikeShops(email,shopName,"removeLikedShop");
    }

    @Override
    public List<ShopDto> preferredShopsToUser(String email) throws NoDataFoundException {
        AppUser appUser =userRepository.findUserByEmail(email);
        return shopConverter.convertListToListDto(appUser.getLikedShops());
    }

    /***
     *
     * @param email
     * @param shopName
     * @param operation
     * @return
     * @throws NoDataFoundException
     */
    public ShopDto likeDislikeShops(String email, String shopName, String operation) throws Exception {
        AppUser appUser =userRepository.findUserByEmail(email);
        if (appUser ==null)
            throw new NoDataFoundException("User identified by "+email+" Not exist");
        Shop shop=shopRepository.findShopByName(shopName);
        if (shop==null)
            throw new NoDataFoundException("Shop identified by "+shopName+" Not exist");
        switch (operation){
            case "likeNewShop": {
                if(appUser.getLikedShops().contains(shop))
                    throw new Exception("Already Liked Schop");
                appUser.addNewLikedShod(shop);
                break;
            }
            case "disLikeNewShop": {
                if(appUser.getLikedShops().contains(shop))
                    throw new Exception("Already Liked Schop");
                appUser.addNewDislikedShop(shop);
                break;
            }
            case "removeLikedShop":
                appUser.removeLikedShop(shop);
                break;
            default:
                break;
        }
        AppUser us=userRepository.save(appUser);
        return shopConverter.convertToDto(shop);
    }
}
