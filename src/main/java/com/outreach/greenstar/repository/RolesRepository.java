package com.outreach.greenstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.outreach.greenstar.entities.Role;

public interface RolesRepository extends JpaRepository<Role, Number> {

    Role findOneByRoleName(String roleName);
}
