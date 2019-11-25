package com.remote.united_shop.data.entities;

import lombok.Builder;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Builder
@Embeddable
public class Address implements Serializable {
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
