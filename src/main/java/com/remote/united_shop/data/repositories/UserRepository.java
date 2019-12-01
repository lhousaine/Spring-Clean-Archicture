package com.remote.united_shop.data.repositories;

import com.remote.united_shop.data.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    public List<AppUser> findByAddress_City(String city);
    public AppUser findUserByEmail(String email);
}
