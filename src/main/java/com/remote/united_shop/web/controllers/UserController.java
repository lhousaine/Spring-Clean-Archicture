package com.remote.united_shop.web.controllers;

import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.dto.UserDto;
import com.remote.united_shop.data.entities.User;
import com.remote.united_shop.services.AbstractService.AbstractUserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final AbstractUserService userService;

    public UserController(AbstractUserService userService) {
        this.userService = userService;
    }
    @GetMapping(path = "/",produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UserDto> getAllUsers() throws NoDataFoundException {
        return userService.getAll();
    }
    @GetMapping(path = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserDto getUser(@PathVariable long id) throws NoDataFoundException {
        return userService.getByIdEntity(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces ={MediaType.APPLICATION_JSON_VALUE})
    public UserDto createUser(@RequestBody User user) throws Exception {
        return userService.createNewEntity(user);
    }

    @PatchMapping("/{id}")
    public boolean updateUser(@PathVariable long id,@RequestBody User user) throws NoDataFoundException {
        return userService.updateEntity(id,user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable long id){
        return userService.deleteEntity(id);
    }
}
