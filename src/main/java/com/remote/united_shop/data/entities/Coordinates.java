package com.remote.united_shop.data.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@Embeddable
public class Coordinates{
    @NotNull
   private long latitude;
    @NotNull
   private long longitude;
}
