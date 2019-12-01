package com.remote.united_shop.Core.Utils;

import com.remote.united_shop.data.dto.ShopDto;
import com.remote.united_shop.data.entities.Coordinates;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShopUtil {
    /***
     *
     * @param shopDto
     * @param coordinates
     * @return
     */
    public static double calculeDistanceShopToCoordinates(ShopDto shopDto, Coordinates coordinates){
        return Math.sqrt(Math.pow(shopDto.getCoordinates().getLatitude()-coordinates.getLatitude(),2)
                +Math.pow(shopDto.getCoordinates().getLongitude()-coordinates.getLongitude(),2));
    }

    /***
     *
     * @param shopDtos
     * @param coords
     * @return
     */
    public static List<ShopDto> sortShopDtoList(List<ShopDto> shopDtos,Coordinates coords){
        Collections.sort(shopDtos, new Comparator<ShopDto>(){
            @Override
            public int compare(ShopDto shd1, ShopDto shd2) {
                int x=0;
                if(shd1.getDistanceToCoordinates(coords)<(shd2.getDistanceToCoordinates(coords)))
                    return 1;
                else
                    return 0;
            }
        });
        return shopDtos;
    }
}
