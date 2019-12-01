package com.remote.united_shop.data.entities;

import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Coordinates{

    @NotNull
   private double latitude;

    @NotNull
   private double longitude;
}
