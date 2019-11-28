package com.remote.united_shop.services.AbstractService;

import com.remote.united_shop.data.dto.ShopDto;
import com.remote.united_shop.data.entities.Coordinates;
import com.remote.united_shop.data.entities.Shop;

import java.util.List;

public interface AbstractShopService extends AbstractService<Shop,String, ShopDto>{
    public List<ShopDto> nearbyShopsToUser(Coordinates coordinates);
    public List<ShopDto> preferredShopsUser(String username);
}
