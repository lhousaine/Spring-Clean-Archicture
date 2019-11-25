package com.remote.united_shop.data.repositories;

import com.remote.united_shop.data.entities.Shop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends MongoRepository<Shop,Long> {

}
