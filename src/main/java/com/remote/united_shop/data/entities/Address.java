package com.remote.united_shop.data.entities;

import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address{
    @Size(max = 10)
    private String zipCode;
    @NotNull
    @Size(max = 100)
    private String addressLine;
    @NotNull
    @Size(max = 100)
    private String city;
    @NotNull
    @Size(max = 100)
    private String country;
}
