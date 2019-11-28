package com.remote.united_shop.services.ImplServices;

import com.remote.united_shop.data.entities.Coordinates;
import com.remote.united_shop.data.entities.Shop;
import com.remote.united_shop.data.repositories.ShopRepository;
import com.remote.united_shop.services.AbstractService.AbstractShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService implements AbstractShopService {
    @Autowired
    private ShopRepository shopRepository;
    /**+
     *
     * @param coordinates
     * @return
     */

    @Override
    public List<Shop> nearbyShopsToUser(Coordinates coordinates) {
        return null;
    }

    /**+
     *
     * @param username
     * @return
     */
    @Override
    public List<Shop> preferredShopsUser(String username) {
        return null;
    }

    /**+
     *
     * @return
     */
    @Override
    public List<Shop> getAll() {
        return shopRepository.findAll();
    }

    @Override
    public Shop getByIdEntity(String idEntity) {
        return shopRepository.getOne(idEntity);
    }

    public List<Shop> getShopByCity(String city) throws Exception {
         List<Shop> shops=shopRepository.findByAddress_City(city);
         if(shops==null)
             throw new Exception();
         return shops;
    }
    /**+
     *
     * @param shop
     * @return
     */
    @Override
    public Shop createNewEntity(Shop shop) {
        return shop;
    }

    /**+
     *
     * @param idEntity
     * @param shop
     */
    @Override
    public void updateEntity(String idEntity, Shop shop) {
        Shop sh=shopRepository.getOne(idEntity);
        Shop s=shopRepository.save(shop);
    }

    /***
     *
     * @param idEntity
     * @return
     */
    @Override
    public void deleteEntity(String idEntity) {
        shopRepository.deleteById(idEntity);
    }
}
