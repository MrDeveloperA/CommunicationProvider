package com.example.communicationprovider.repository;

import com.example.communicationprovider.entity.Role;
import com.example.communicationprovider.entity.enums.RoleNames;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleName(RoleNames roleName);
}
