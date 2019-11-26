package com.remote.united_shop.data.dto;


import com.remote.united_shop.data.entities.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@AllArgsConstructor
@Getter
public class ShopDto {
    private String name;
    private String description;
    private String logo;
    private Coordinates coordinates;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
