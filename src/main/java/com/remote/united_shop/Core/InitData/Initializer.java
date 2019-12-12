package com.remote.united_shop.Core.InitData;

import com.remote.united_shop.data.entities.*;
import com.remote.united_shop.data.repositories.RoleRepository;
import com.remote.united_shop.data.repositories.ShopRepository;
import com.remote.united_shop.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class Initializer {
    private static UserRepository userRepository;
    private static ShopRepository shopRepository;
    private static BCryptPasswordEncoder bCryptPasswordEncoder;
    private static RoleRepository roleRepository;

    /**
     *
     * @param shopRepository
     * @param userRepository
     * @param bCryptPasswordEncoder
     * @param roleRepository
     */
    @Autowired
    public Initializer(ShopRepository shopRepository, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository) {
        Initializer.shopRepository = shopRepository;
        Initializer.userRepository = userRepository;
        Initializer.bCryptPasswordEncoder = bCryptPasswordEncoder;
        Initializer.roleRepository = roleRepository;
    }

    /***
     * Initiliaze the data base with values for testing the api end-points
     */
    public static void InitBD(){
        Role r1=roleRepository.save(new Role("USER"));
        Role r2=roleRepository.save(new Role("ADMIN"));
        Shop shop1=new Shop();
        shop1.setName("shop_1");
        shop1.setDescription("tincidunt tempus. Donec vitae sapien ut libero \" +\n" +
                "                \"venenatis faucibus. Nullam quis ante.");
        shop1.setLogo("https://i.ibb.co/R9sc5vD/shop-1.jpg");
        shop1.setCoordinates(new Coordinates(32.5,8));
        shop1.setAddress(new Address("123","rue 20","marrakech","maroc"));
        shopRepository.save(shop1);

        Shop shop2=new Shop();
        shop2.setName("shop_2");
        shop2.setDescription(" Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero " +
                "venenatis faucibus. Nullam quis ante. Etiam sit");
        shop2.setLogo("https://i.ibb.co/6tSMk43/shop-2.jpg");
        shop2.setCoordinates(new Coordinates(35,8));
        shop2.setAddress(new Address("130","rue Asfi ","marrakech","maroc"));
        shopRepository.save(shop2);

        AppUser appUser1 =new AppUser();
        appUser1.setFirstName("lhoussaine");
        appUser1.setLastName("ouarhou");
        appUser1.setEmail("em@gmail.com");
        appUser1.setPassword(bCryptPasswordEncoder.encode("12345678"));
        appUser1.setAddress(new Address("123","rue 20","marrakech","maroc"));
        appUser1.setCoordinates(new Coordinates(31.6295,7.98));
        appUser1.getRoles().add(r1);

        userRepository.save(appUser1);

        AppUser appUser2 =new AppUser();
        appUser2.setFirstName("lhou");
        appUser2.setLastName("ouarhou");
        appUser2.setEmail("lhou@gmail.com");
        appUser2.setPassword(bCryptPasswordEncoder.encode("12345678"));
        appUser2.setAddress(new Address("130","rue 20","marrakech","maroc"));
        appUser2.setCoordinates(new Coordinates(31.625,7.98));
        appUser2.getRoles().add(r2);
        userRepository.save(appUser2);
    }
}
