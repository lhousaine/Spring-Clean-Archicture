package com.remote.united_shop.data.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "shops")
public class Shop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    @Size(min = 100)
    private String description;

    @NotNull
    private String logo;

    @Embedded
    private Coordinates coordinates;

    @Embedded
    private Address address;

    public Shop() {
    }

    public Shop(@NotNull String name, @NotNull @Size(min = 100) String description, @NotNull String logo, Coordinates coordinates, Address address) {
        this.name = name;
        this.description = description;
        this.logo = logo;
        this.coordinates = coordinates;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLogo() {
        return logo;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Address getAddress() {
        return address;
    }
}
