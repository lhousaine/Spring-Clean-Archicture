package com.remote.united_shop.web.controllers;

import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.dto.ShopDto;
import com.remote.united_shop.data.entities.Shop;
import com.remote.united_shop.services.AbstractService.AbstractShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;

@RestController
@RequestMapping("/shops")
public class ShopController {
     private RestOperations restTemplate;
     private final AbstractShopService shopService;

    public ShopController(AbstractShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping(path = "/{name}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ShopDto getShop(@PathVariable String name) throws NoDataFoundException {
        return shopService.getByIdEntity(name);
    }

    @PostMapping(path = "/",consumes = {MediaType.APPLICATION_JSON_VALUE},
                produces ={MediaType.APPLICATION_JSON_VALUE})
    public ShopDto createShop(@RequestBody Shop shop) throws Exception {
        return shopService.createNewEntity(shop);
    }

    @PutMapping(path = "/{name}")
    public boolean updateShop(@PathVariable String name,@RequestBody Shop shop) throws NoDataFoundException {
        return shopService.updateEntity(name,shop);
    }

    @DeleteMapping("/{name}")
    public boolean deleteShop(@PathVariable String name) {
        return shopService.deleteEntity(name);
    }
}
