package com.remote.united_shop.web.controllers;

import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.dto.ShopDto;
import com.remote.united_shop.data.entities.Coordinates;
import com.remote.united_shop.data.entities.Shop;
import com.remote.united_shop.services.AbstractService.AbstractShopService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopController {
     private final AbstractShopService shopService;

    /**
     *
     * @param shopService
     */
    public ShopController(AbstractShopService shopService) {
        this.shopService = shopService;
    }

    /**
     *
     * @return
     * @throws NoDataFoundException
     */
    @GetMapping(path = "/",produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<ShopDto> getAll() throws NoDataFoundException {
        return shopService.getAll();
    }

    /**
     *
     * @param coordinates
     * @return
     * @throws NoDataFoundException
     */
    @PostMapping(path = "/nearbyshops",produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<ShopDto> getNeabyShops(@RequestBody Coordinates coordinates) throws NoDataFoundException {
        return shopService.nearbyShopsToUser(coordinates);
    }

    /**
     *
     * @param name
     * @return
     * @throws NoDataFoundException
     */
    @GetMapping(path = "/{name}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ShopDto getShop(@PathVariable String name) throws NoDataFoundException {
        return shopService.getByIdEntity(name);
    }

    /***
     *
     * @param shop
     * @return
     * @throws Exception
     */
    @PostMapping(path = "/",consumes = {MediaType.APPLICATION_JSON_VALUE},
                produces ={MediaType.APPLICATION_JSON_VALUE})
    public ShopDto createShop(@RequestBody Shop shop) throws Exception {
        return shopService.createNewEntity(shop);
    }

    /**
     *
     * @param name
     * @param shop
     * @return
     * @throws NoDataFoundException
     */
    @PatchMapping(path = "/{name}")
    public boolean updateShop(@PathVariable String name,@RequestBody Shop shop) throws NoDataFoundException {
        return shopService.updateEntity(name,shop);
    }

    /**
     *
     * @param name
     * @return
     */
    @DeleteMapping("/{name}")
    public boolean deleteShop(@PathVariable String name) throws NoDataFoundException {
        return shopService.deleteEntity(name);
    }
}
