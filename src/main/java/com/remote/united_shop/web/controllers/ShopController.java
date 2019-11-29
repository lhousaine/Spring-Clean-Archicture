package com.remote.united_shop.web.controllers;

import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.dto.ShopDto;
import com.remote.united_shop.data.entities.Coordinates;
import com.remote.united_shop.data.entities.Shop;
import com.remote.united_shop.services.AbstractService.AbstractShopService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;

import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopController {
     private final AbstractShopService shopService;

    public ShopController(AbstractShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping(path = "/",produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<ShopDto> getAll() throws NoDataFoundException {
        return shopService.getAll();
    }

    @PostMapping(path = "/nearbyshops",produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<ShopDto> getNeabyShops(@RequestBody Coordinates coordinates) throws NoDataFoundException {
        return shopService.nearbyShopsToUser(coordinates);
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

    @PatchMapping(path = "/{name}")
    public boolean updateShop(@PathVariable String name,@RequestBody Shop shop) throws NoDataFoundException {
        return shopService.updateEntity(name,shop);
    }

    @DeleteMapping("/{name}")
    public boolean deleteShop(@PathVariable String name) {
        return shopService.deleteEntity(name);
    }
}
