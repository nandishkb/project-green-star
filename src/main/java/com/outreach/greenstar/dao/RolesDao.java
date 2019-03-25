package com.outreach.greenstar.dao;

import java.util.List;
import java.util.Optional;

import javax.management.relation.RoleNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.outreach.greenstar.entities.Role;
import com.outreach.greenstar.repository.RolesRepository;

@Repository("rolesDao")
public class RolesDao {

    @Autowired
    private RolesRepository rolesRepository;
    
    public List<Role> getAllRoles() {
        return rolesRepository.findAll();
    }
    
    public Role getRoleById(int roleId) {
        Optional<Role> opRole = rolesRepository.findById(roleId);
        if (opRole.isPresent()) {
            return opRole.get();
        }
        throw new IllegalArgumentException("Invalid role id = "+roleId);
    }

    public Role getRoleByName(String roleName) {
        return rolesRepository.findOneByRoleName(roleName);
    }

    @Transactional
    public Role saveOrUpdate(Role role) {
        return rolesRepository.saveAndFlush(role);
    }

    public void deleteRole(Role role) {
        rolesRepository.delete(role);
    }
}
