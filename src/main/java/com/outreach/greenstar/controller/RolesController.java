package com.outreach.greenstar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outreach.greenstar.dto.RoleDTO;
import com.outreach.greenstar.service.RolesService;

@RestController
@RequestMapping("/api/v1/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        List<RoleDTO> listOfRole = rolesService.getAllRoles();
        return new ResponseEntity<>(listOfRole, HttpStatus.OK);
    }
    
    @GetMapping(value = "/privilages", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getAllPrivilages() {
        List<String> listOfRole = rolesService.getAllPrivilages();
        return new ResponseEntity<>(listOfRole, HttpStatus.OK);
    }

    @GetMapping(value = "/{roleName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleDTO> getRoleByName(@PathVariable String roleName) {
        RoleDTO role = rolesService.getRoleByName(roleName);
        return new ResponseEntity<RoleDTO>(role, HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleDTO> createRole(@RequestBody RoleDTO rolesDTO) {
        RoleDTO role = rolesService.createRole(rolesDTO);
        return new ResponseEntity<RoleDTO>(role, HttpStatus.OK);
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleDTO> updateRole(@RequestBody RoleDTO rolesDTO) {
        RoleDTO role = rolesService.updateRole(rolesDTO);
        return new ResponseEntity<RoleDTO>(role, HttpStatus.OK);
    }
}
