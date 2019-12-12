package com.remote.united_shop.data.entities;

import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Coordinates{

    @NotNull
   private double latitude;

    @NotNull
   private double longitude;

    public Coordinates() {
    }

    public Coordinates(@NotNull double latitude, @NotNull double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
