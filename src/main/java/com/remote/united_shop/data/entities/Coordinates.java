package com.remote.united_shop.data.entities;

import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@Embeddable
public class Coordinates implements Serializable {
    @NotNull
   private long latitude;
    @NotNull
   private long longitude;
}
