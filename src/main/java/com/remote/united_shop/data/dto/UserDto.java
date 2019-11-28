package com.remote.united_shop.data.dto;

import com.remote.united_shop.data.entities.Address;
import com.remote.united_shop.data.entities.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private long userId;
    private String email;
    private String firstName;
    private String lastName;
    private Coordinates coordinates;
    private Address address;
}
