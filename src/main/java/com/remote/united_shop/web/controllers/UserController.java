package com.remote.united_shop.web.controllers;

import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.dto.ShopDto;
import com.remote.united_shop.data.dto.UserDto;
import com.remote.united_shop.data.entities.AppUser;
import com.remote.united_shop.services.AbstractService.AbstractUserService;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final AbstractUserService userService;
    /**
     *
     * @param userService
     */
    public UserController(AbstractUserService userService) {
        this.userService = userService;
    }

    /***
     *
     * @return
     * @throws NoDataFoundException
     */
    @GetMapping(path = "/",produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UserDto> getAll() throws NoDataFoundException {
        return userService.getAll();
    }

    /***
     *
     * @param id
     * @return
     * @throws NoDataFoundException
     */
    @GetMapping(path = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserDto getUser(@PathVariable long id) throws NoDataFoundException {
        return userService.getByIdEntity(id);
    }
    /***
     *
     * @param appUser
     * @return
     * @throws Exception
     */
    @PostMapping(path ="/register",consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces ={MediaType.APPLICATION_JSON_VALUE})
    public UserDto createUser(@RequestBody AppUser appUser) throws Exception {
        System.out.println(appUser.toString());
        return userService.createNewEntity(appUser);
    }
    /***
     *
     * @param id
     * @param appUser
     * @return
     * @throws NoDataFoundException
     */
    @PatchMapping("/{id}")
    public boolean updateUser(@PathVariable long id,@RequestBody AppUser appUser) throws NoDataFoundException {
        return userService.updateEntity(id, appUser);
    }

    /***
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable long id) throws NoDataFoundException {
        return userService.deleteEntity(id);
    }
    /***
     *
     * @param content
     * @return
     */
    @PostMapping(value = "/user",consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserDto getUserByMail(@RequestBody Map<String,String> content) throws NoDataFoundException {
        return userService.findUserByEmail(content.get("email"));
    }
    /***
     *
     * @param content
     * @return
     * @throws NoDataFoundException
     */
    @PostMapping(path = "/like-shop",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ShopDto userLikeNewShop(@RequestBody Map<String,String> content) throws NoDataFoundException {
         return userService.likeNewShop(content.get("email"),content.get("shopName"));
    }
    /***
     *
     * @param content
     * @return
     * @throws NoDataFoundException
     */
    @PostMapping(path = "/preferred-shops",produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ShopDto> preferredShopsToUser(@RequestBody Map<String,String> content) throws NoDataFoundException {
        return userService.preferredShopsToUser(content.get("email"));
    }

    /***
     *
     * @param content
     * @return
     * @throws NoDataFoundException
     */
    @PostMapping(path = "/preferred-shops/remove",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ShopDto userRemoveLikedShop(@RequestBody Map<String,String> content) throws NoDataFoundException {
        return userService.removeShopFromPreferredShops(content.get("email"),content.get("shopName"));
    }

    /***
     *
     * @param content
     * @return
     * @throws NoDataFoundException
     */
    @PostMapping(path = "/dislike-shop",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ShopDto userDislikeShop(@RequestBody Map<String,String> content) throws NoDataFoundException {
        return userService.dislikeNewShop(content.get("email"),content.get("shopName"));
    }
}
