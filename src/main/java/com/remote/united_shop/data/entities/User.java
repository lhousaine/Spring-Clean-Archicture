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
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
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

}
