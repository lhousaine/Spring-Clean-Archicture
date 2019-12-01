package com.remote.united_shop.data.dto;

import com.remote.united_shop.data.entities.Address;
import com.remote.united_shop.data.entities.Coordinates;
import com.remote.united_shop.data.entities.Shop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private Coordinates coordinates;
    private Address address;
    private Set<Shop> likedShops;
    private Set<Shop> dislikedShops;
}
