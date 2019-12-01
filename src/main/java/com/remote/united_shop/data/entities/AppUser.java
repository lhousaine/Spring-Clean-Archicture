package com.remote.united_shop.data.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Getter
@Setter
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
    private Set<Shop> likedShops;

    @ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="dislikedShops", joinColumns=@JoinColumn(name="userId"),
            inverseJoinColumns=@JoinColumn(name="shopName"))
    private Set<Shop> dislikedShops;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles=new HashSet<>();
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
