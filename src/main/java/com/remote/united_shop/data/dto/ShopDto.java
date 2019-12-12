package com.remote.united_shop.data.dto;


import com.remote.united_shop.Core.Utils.ShopUtil;
import com.remote.united_shop.data.entities.Address;
import com.remote.united_shop.data.entities.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class ShopDto{
    private long id;
    private String name;
    private String description;
    private String logo;
    private Coordinates coordinates;
    private Address address;

    public ShopDto() {

    }

    public ShopDto(long id, String name, String description, String logo, Coordinates coordinates, Address address) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.logo = logo;
        this.coordinates = coordinates;
        this.address = address;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLogo() {
        return logo;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Address getAddress() {
        return address;
    }

    /**
     *
     * @param coords
     * @return
     */
    public double getDistanceToCoordinates(Coordinates coords){
        return ShopUtil.calculeDistanceShopToCoordinates(this,coords);
    }
}
