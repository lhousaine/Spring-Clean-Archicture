package com.remote.united_shop.data.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    @NotNull
    @Size(max =50,min = 3)
    private String firstName;
    @NotNull
    @Size(max =50,min = 3)
    private String lastName;
    @NotNull
    @Email
    @Column(unique = true)
    private String email;
    @NotNull
    @Size(min = 8,max=20)
    private String password;
    private Coordinates coordinates;
    private Address address;
    private Collection<Shop> likedShops;
    private Collection<Shop> unlikedShops;
}
