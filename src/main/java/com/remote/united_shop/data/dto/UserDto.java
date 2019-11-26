package com.remote.united_shop.data.dto;

import com.remote.united_shop.data.entities.Address;
import com.remote.united_shop.data.entities.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class UserDto {
    private long userId;
    private String email;
    private String firstName;
    private String lastName;
    private Coordinates coordinates;
    private Address address;

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
