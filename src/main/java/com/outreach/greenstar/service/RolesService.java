package com.outreach.greenstar.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outreach.greenstar.dao.RolesDao;
import com.outreach.greenstar.dto.PrivilagesDTO;
import com.outreach.greenstar.dto.RoleDTO;
import com.outreach.greenstar.entities.Privilages;
import com.outreach.greenstar.entities.Role;
import com.outreach.greenstar.repository.PrivilagesRepository;
import com.outreach.greenstar.utility.EntityDtoConverter;

@Service("rolesService")
public class RolesService {

    @Autowired
    private RolesDao rolesDao;
    @Autowired
    private PrivilagesRepository privilagesRepository;
    
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
        List<PrivilagesDTO> privilages = rolesDTO.getPrivilages();
        List<Privilages> newPrivilages = new ArrayList<>();
        for (Iterator<PrivilagesDTO> iterator = privilages.iterator(); iterator.hasNext();) {
            PrivilagesDTO privilages2 = iterator.next();
            Privilages priv = privilagesRepository.getOne(privilages2.getId());
            newPrivilages.add(priv);
        }
        role.setListOfPrivilages(newPrivilages);
        role = rolesDao.saveOrUpdate(role);
        return EntityDtoConverter.getRolesDto(role);
    }

    public RoleDTO updateRole(RoleDTO rolesDTO) {
        rolesDao.getRoleById(rolesDTO.getId());
        return createRole(rolesDTO);
    }

    public List<Privilages> getAllPrivilages() {
        return rolesDao.getAllPrivilages();
    }

    public void deleteRole(int roleId) {
        Role role = rolesDao.getRoleById(roleId);
        if (role.getRoleName().equalsIgnoreCase("admin")) {
            throw new IllegalArgumentException("Cannot delete Admin user");
        }
        role.getListOfPrivilages().clear();
        rolesDao.saveOrUpdate(role);
        rolesDao.deleteRole(role);
    }

}
