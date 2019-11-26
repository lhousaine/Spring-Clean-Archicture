package com.remote.united_shop.services.ImplServices;

import com.remote.united_shop.data.entities.Coordinates;
import com.remote.united_shop.data.entities.Shop;
import com.remote.united_shop.services.AbstractService.AbstractShopService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService implements AbstractShopService {

    @Override
    public List<Shop> nearbyShopsToUser(Coordinates coordinates) {
        return null;
    }

    @Override
    public List<Shop> preferredShopsUser(String username) {
        return null;
    }

    @Override
    public List<Shop> getAll() {
        return null;
    }

    @Override
    public Shop getByIdEntity(String idEntity) {
        return null;
    }

    @Override
    public Shop createNewEntity(Shop shop) {
        return null;
    }

    @Override
    public void updateEntity(String idEntity, Shop shop) {

    }

    @Override
    public String deleteEntity(String idEntity) {
        return null;
    }
}
