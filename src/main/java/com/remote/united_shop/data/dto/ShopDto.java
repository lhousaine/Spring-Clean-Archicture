package com.remote.united_shop.data.dto;


import com.remote.united_shop.data.entities.Address;
import com.remote.united_shop.data.entities.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@NoArgsConstructor
@Getter
@Setter
public class ShopDto {

    private String name;
    private String description;
    private String logo;
    private Coordinates coordinates;
    private Address address;
}
