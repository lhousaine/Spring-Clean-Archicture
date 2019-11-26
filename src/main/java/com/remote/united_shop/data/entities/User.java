package com.remote.united_shop.data.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Email
    @Column(unique = true)
    private String email;
    @NotNull
    @Size(max =50,min = 3)
    private String firstName;
    @NotNull
    @Size(max =50,min = 3)
    private String lastName;
    @NotNull
    @Size(min = 8,max=20)
    private String password;
    @Embedded
    private Coordinates coordinates;
    @Embedded
    private Address address;
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="likedShops", joinColumns=@JoinColumn(name="userId"),
            inverseJoinColumns=@JoinColumn(name="shopName"))
    private Set<Shop> likedShops;
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="dislikedShops", joinColumns=@JoinColumn(name="userEmail"),
            inverseJoinColumns=@JoinColumn(name="shopName"))
    private Set<Shop> dislikedShops;

    public void setPassword(String password) {
        this.password = password;
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
