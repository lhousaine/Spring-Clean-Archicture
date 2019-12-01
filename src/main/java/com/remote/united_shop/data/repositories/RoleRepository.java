package com.remote.united_shop.data.repositories;

import com.remote.united_shop.data.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role,Long> {
    public Role findRoleByName(String roleName);
}
