package com.outreach.greenstar.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outreach.greenstar.dao.RolesDao;
import com.outreach.greenstar.dto.RoleDTO;
import com.outreach.greenstar.entities.Role;
import com.outreach.greenstar.utility.EntityDtoConverter;

@Service("rolesService")
public class RolesService {

    @Autowired
    private RolesDao rolesDao;
    
    public List<RoleDTO> getAllRoles() {
        List<Role> listOfRoles = rolesDao.getAllRoles();
        List<RoleDTO> listDto = new ArrayList<>();
        for (Iterator<Role> iterator = listOfRoles.iterator(); iterator.hasNext();) {
            Role role = (Role) iterator.next();
            listDto.add(EntityDtoConverter.getRolesDto(role));
        }
        return listDto;
    }

    public RoleDTO getRoleByName(String roleName) {
        Role role = rolesDao.getRoleByName(roleName);
        return EntityDtoConverter.getRolesDto(role);
    }

    public RoleDTO createRole(RoleDTO rolesDTO) {
        Role role = EntityDtoConverter.getRole(rolesDTO);
        role = rolesDao.saveOrUpdate(role);
        return EntityDtoConverter.getRolesDto(role);
    }

    public RoleDTO updateRole(RoleDTO rolesDTO) {
        return createRole(rolesDTO);
    }

}
