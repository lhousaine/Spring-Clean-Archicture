package com.remote.united_shop.services.AbstractService;

import com.remote.united_shop.data.entities.Coordinates;
import com.remote.united_shop.data.entities.Shop;

import java.util.List;

public interface AbstractShopService extends AbstractService<Shop,String>{
    public List<Shop> nearbyShopsToUser(Coordinates coordinates);
    public List<Shop> preferredShopsUser(String username);
}
