package com.remote.united_shop.data.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ToString
@Entity
@Table(name = "users")
public class AppUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max =50,min = 3)
    private String firstName;

    @NotNull
    @Size(max =50,min = 3)
    private String lastName;

    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(min = 8)

    private String password;

    @Embedded
    private Coordinates coordinates;

    @Embedded
    private Address address;

    @ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="likedShops", joinColumns=@JoinColumn(name="userId"),
            inverseJoinColumns=@JoinColumn(name="shopName"))
    private List<Shop> likedShops=new ArrayList<>();

    @ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="dislikedShops", joinColumns=@JoinColumn(name="userId"),
            inverseJoinColumns=@JoinColumn(name="shopName"))
    private List<Shop> dislikedShops=new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles=new ArrayList<>();

    public AppUser() {
    }

    public AppUser(@NotNull @Size(max = 50, min = 3) String firstName, @NotNull @Size(max = 50, min = 3) String lastName, @Email String email, @NotNull @Size(min = 8) String password, Coordinates coordinates, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.coordinates = coordinates;
        this.address = address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setLikedShops(List<Shop> likedShops) {
        this.likedShops = likedShops;
    }

    public void setDislikedShops(List<Shop> dislikedShops) {
        this.dislikedShops = dislikedShops;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Address getAddress() {
        return address;
    }

    public List<Shop> getLikedShops() {
        return likedShops;
    }

    public List<Shop> getDislikedShops() {
        return dislikedShops;
    }

    public List<Role> getRoles() {
        return roles;
    }

    /***
     *
     * @param shop
     */
    public void addNewLikedShod(Shop shop){
        this.likedShops.add(shop);
    }
    /***
     *
     * @param shop
     */
    public void removeLikedShop(Shop shop) {
        this.likedShops.remove(shop);
    }

    /***
     *
     * @param shop
     */
    public void addNewDislikedShop(Shop shop) {
        this.dislikedShops.add(shop);
    }
}
