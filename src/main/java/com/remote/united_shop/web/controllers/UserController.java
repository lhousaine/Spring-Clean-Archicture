package com.remote.united_shop.web.controllers;

import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.dto.UserDto;
import com.remote.united_shop.data.entities.AppUser;
import com.remote.united_shop.services.AbstractService.AbstractUserService;
import org.springframework.http.MediaType;
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
     * @throws NoDataFoundException
     */
    @PostMapping(path = "/likeShop",produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean userLikeNewShop(@RequestBody Map<String,String> content) throws NoDataFoundException {
         return userService.likeNewShop(Long.parseLong(content.get("idUser")),content.get("shopName"));
    }

    /***
     *
     * @param content
     * @return
     * @throws NoDataFoundException
     */
    @PostMapping(path = "/likedShops/remove",produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean userRemoveLikedShop(@RequestBody Map<String,String> content) throws NoDataFoundException {
        return userService.removeShopFromPreferredShops(Long.parseLong(content.get("idUser")),content.get("shopName"));
    }

    /***
     *
     * @param content
     * @return
     * @throws NoDataFoundException
     */
    @PostMapping(path = "/dislikeShop",produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean userDislikeShop(@RequestBody Map<String,String> content) throws NoDataFoundException {
        return userService.dislikeNewShop(Long.parseLong(content.get("idUser")),content.get("shopName"));
    }
}
