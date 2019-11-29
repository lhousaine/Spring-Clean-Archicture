package com.remote.united_shop.data.repositories;

import com.remote.united_shop.data.entities.Shop;
import com.remote.united_shop.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop,String> {
    public List<Shop> findByAddress_City(String city);
    public List<Shop> f
}
