package com.remote.united_shop.services.ImplServices;

import com.remote.united_shop.Core.Converters.AbstractConverters.AbstractShopConverter;
import com.remote.united_shop.Core.Exceptions.FailedToSaveDataException;
import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.dto.ShopDto;
import com.remote.united_shop.data.entities.Coordinates;
import com.remote.united_shop.data.entities.Shop;
import com.remote.united_shop.data.repositories.ShopRepository;
import com.remote.united_shop.services.AbstractService.AbstractShopService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@NoArgsConstructor
public class ShopService implements AbstractShopService {
    private ShopRepository shopRepository;
    private AbstractShopConverter shopConverter;

    @Autowired
    public ShopService(@Qualifier("ShopConverter") AbstractShopConverter shopConverter, ShopRepository shopRepository) {
        this.shopConverter = shopConverter;
        this.shopRepository = shopRepository;
    }

    /**+
     *
     * @param coordinates
     * @return
     */

    @Override
    public List<ShopDto> nearbyShopsToUser(Coordinates coordinates) {
        return null;
    }

    /**+
     *
     * @param username
     * @return
     */
    @Override
    public List<ShopDto> preferredShopsUser(String username) {
        return null;
    }

    /**+
     *
     * @return
     */
    @Override
    public List<ShopDto> getAll() throws NoDataFoundException {
        List<Shop> shops=shopRepository.findAll();
        if (shops==null)
            throw new NoDataFoundException("data does not found");
        return shopConverter.convertListToListDto(shops);
    }

    @Override
    public ShopDto getByIdEntity(String idEntity) throws NoDataFoundException {
        Shop shop=shopRepository.getOne(idEntity);
        if(shop==null){
            throw new NoDataFoundException("User identified"+idEntity+" by not exist");
        }
        return shopConverter.convertToDto(shop);
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
    public ShopDto createNewEntity(Shop shop) throws FailedToSaveDataException {
        Shop sh=shopRepository.save(shop);
        if(sh==null)
            throw new FailedToSaveDataException("Data does not saved");
        return shopConverter.convertToDto(sh);
    }

    @Override
    public boolean updateEntity(String idEntity, Shop shop) throws NoDataFoundException {
        Shop sh=shopRepository.getOne(idEntity);
        if(sh==null)
            throw new NoDataFoundException("No Shop was identified by "+idEntity);
        sh=shopRepository.save(shop);
        return sh != null;
    }
    /***
     *
     * @param idEntity
     * @return
     */
    @Override
    public boolean deleteEntity(String idEntity) {
        try {
            shopRepository.deleteById(idEntity);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
