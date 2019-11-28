package com.remote.united_shop.services.ImplServices;

import com.remote.united_shop.Core.Converters.AbstractConverters.AbstractShopConverter;
import com.remote.united_shop.Core.Exceptions.FailedToSaveDataException;
import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.dto.ShopDto;
import com.remote.united_shop.data.entities.Coordinates;
import com.remote.united_shop.data.entities.Shop;
import com.remote.united_shop.data.repositories.ShopRepository;
import com.remote.united_shop.services.AbstractService.AbstractShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopService implements AbstractShopService {
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private AbstractShopConverter shopConverter;
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
     * @param shopDto
     * @return
     */
    @Override
    public ShopDto createNewEntity(ShopDto shopDto) throws FailedToSaveDataException {
        Shop sh=shopRepository.save(shopConverter.convertToEntity(shopDto));
        if(sh==null)
            throw new FailedToSaveDataException("Data does not saved");
        return shopConverter.convertToDto(sh);
    }

    @Override
    public void updateEntity(String idEntity, ShopDto shopDto) throws NoDataFoundException {
        Shop sh=shopRepository.getOne(idEntity);
        if(sh==null)
            throw new NoDataFoundException("No Shop was identified by "+idEntity);
        shopRepository.save(shopConverter.convertToEntity(shopDto));
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
