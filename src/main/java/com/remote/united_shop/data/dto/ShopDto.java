package com.remote.united_shop.data.dto;


import com.remote.united_shop.Core.Utils.ShopUtil;
import com.remote.united_shop.data.entities.Address;
import com.remote.united_shop.data.entities.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShopDto{

    private String name;
    private String description;
    private String logo;
    private Coordinates coordinates;
    private Address address;

    /**
     *
     * @param coords
     * @return
     */
    public double getDistanceToCoordinates(Coordinates coords){
        return ShopUtil.calculeDistanceShopToCoordinates(this,coords);
    }
}
