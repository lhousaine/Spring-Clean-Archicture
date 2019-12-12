package com.remote.united_shop.data.dto;

import com.remote.united_shop.data.entities.Address;
import com.remote.united_shop.data.entities.Coordinates;
import com.remote.united_shop.data.entities.Role;
import com.remote.united_shop.data.entities.Shop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

public class UserDto {
    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private Coordinates coordinates;
    private Address address;
    private Set<Shop> likedShops;
    private Set<Shop> dislikedShops;

    public UserDto() {

    }

    public UserDto(long id, String email, String firstName, String lastName, Coordinates coordinates, Address address, Set<Shop> likedShops, Set<Shop> dislikedShops) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.coordinates = coordinates;
        this.address = address;
        this.likedShops = likedShops;
        this.dislikedShops = dislikedShops;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Address getAddress() {
        return address;
    }

    public Set<Shop> getLikedShops() {
        return likedShops;
    }

    public Set<Shop> getDislikedShops() {
        return dislikedShops;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setLikedShops(Set<Shop> likedShops) {
        this.likedShops = likedShops;
    }

    public void setDislikedShops(Set<Shop> dislikedShops) {
        this.dislikedShops = dislikedShops;
    }

}
