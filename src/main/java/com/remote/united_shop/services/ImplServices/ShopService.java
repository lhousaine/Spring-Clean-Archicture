package com.remote.united_shop.services.ImplServices;

import com.remote.united_shop.Core.Converters.AbstractConverters.AbstractShopConverter;
import com.remote.united_shop.Core.Exceptions.FailedToSaveDataException;
import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.Core.Utils.ShopUtil;
import com.remote.united_shop.data.dto.ShopDto;
import com.remote.united_shop.data.entities.Coordinates;
import com.remote.united_shop.data.entities.Shop;
import com.remote.united_shop.data.repositories.ShopRepository;
import com.remote.united_shop.services.AbstractService.AbstractShopService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class ShopService implements AbstractShopService {
    private ShopRepository shopRepository;
    private AbstractShopConverter shopConverter;

    /***
     *
     * @param shopRepository
     * @param shopConverter
     */
    public ShopService(ShopRepository shopRepository, @Qualifier("ShopConverter") AbstractShopConverter shopConverter) {
        this.shopRepository = shopRepository;
        this.shopConverter = shopConverter;
    }

    /***
     *
     * @param coords
     * @return
     * @throws NoDataFoundException
     */

    @Override
    public List<ShopDto> nearbyShopsToUser(Coordinates coords) throws NoDataFoundException {
        return ShopUtil.sortShopDtoList(this.getAll(),coords);
    }

    /***
     *
     * @return
     * @throws NoDataFoundException
     */
    @Override
    public List<ShopDto> getAll() throws NoDataFoundException {
        List<Shop> shops=shopRepository.findAll();
        if (shops==null)
            throw new NoDataFoundException("data does not found");
        return shopConverter.convertListToListDto(shops);
    }

    /**
     *
     * @param idEntity
     * @return
     * @throws NoDataFoundException
     */
    @Override
    public ShopDto getByIdEntity(String idEntity) throws NoDataFoundException {
        Shop shop=shopRepository.getOne(idEntity);
        if(shop==null){
            throw new NoDataFoundException("User identified"+idEntity+" by not exist");
        }
        return shopConverter.convertToDto(shop);
    }

    /**
     *
     * @param shop
     * @return
     * @throws FailedToSaveDataException
     */
    @Override
    public ShopDto createNewEntity(Shop shop) throws FailedToSaveDataException {
        Shop sh=shopRepository.save(shop);
        if(sh==null)
            throw new FailedToSaveDataException("Data does not saved");
        return shopConverter.convertToDto(sh);
    }

    /***
     *
     * @param idEntity
     * @param shop
     * @return
     * @throws NoDataFoundException
     */
    @Override
    public boolean updateEntity(String idEntity, Shop shop) throws NoDataFoundException {
        Shop sh=shopRepository.getOne(idEntity);
        if(sh==null)
            throw new NoDataFoundException("No Shop was identified by "+idEntity);
        sh=shopRepository.save(shop);
        return sh != null;
    }

    /**
     *
     * @param idEntity
     * @return
     */
    @Override
    public boolean deleteEntity(String idEntity) throws NoDataFoundException {
        boolean success=false;
        if(shopRepository.getOne(idEntity)==null)
            throw new NoDataFoundException("No Shop was identified by "+idEntity);
        try {
            shopRepository.deleteById(idEntity);
            success=true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return success;
    }
}
