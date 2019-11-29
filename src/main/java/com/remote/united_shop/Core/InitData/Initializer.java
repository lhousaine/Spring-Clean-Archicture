package com.remote.united_shop.Core.InitData;

import com.remote.united_shop.data.dto.UserDto;
import com.remote.united_shop.data.entities.Address;
import com.remote.united_shop.data.entities.Coordinates;
import com.remote.united_shop.data.entities.Shop;
import com.remote.united_shop.data.entities.User;
import com.remote.united_shop.data.repositories.ShopRepository;
import com.remote.united_shop.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
@Transactional
public class Initializer {
    private static UserRepository userRepository;
    private static ShopRepository shopRepository;

    @Autowired
    public Initializer(ShopRepository shopRepository, UserRepository userRepository) {
        Initializer.shopRepository = shopRepository;
        Initializer.userRepository = userRepository;
    }

    public static void InitBD(){
        Shop shop1=new Shop();
        shop1.setName("shop 1");
        shop1.setDescription(" Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero \" +\n" +
                "                \"venenatis faucibus. Nullam quis ante.");
        shop1.setLogo("https://shop1");
        shop1.setCoordinates(new Coordinates(32.5,8));
        shop1.setAddress(new Address("123","rue 20","marrakech","maroc"));
        shopRepository.save(shop1);

        Shop shop2=new Shop();
        shop2.setName("shop 2");
        shop2.setDescription(" Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero " +
                "venenatis faucibus. Nullam quis ante. Etiam sit");
        shop2.setLogo("https://shop 2");
        shop2.setCoordinates(new Coordinates(35,8));
        shop2.setAddress(new Address("130","rue Asfi ","marrakech","maroc"));
        shopRepository.save(shop2);

        User user1=new User();
        user1.setFirstName("lhoussaine");
        user1.setLastName("ouarhou");
        user1.setEmail("em@gmail.com");
        user1.setPassword("123456789");
        user1.setAddress(new Address("123","rue 20","marrakech","maroc"));
        user1.setCoordinates(new Coordinates(31.6295,7.98));

        userRepository.save(user1);

        User user2=new User();
        user2.setFirstName("lhou");
        user2.setLastName("ouarhou");
        user2.setEmail("lhou@gmail.com");
        user2.setPassword("12345678");
        user2.setAddress(new Address("130","rue 20","marrakech","maroc"));
        user2.setCoordinates(new Coordinates(31.625,7.98));

        userRepository.save(user2);
    }
}
