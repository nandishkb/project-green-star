package com.outreach.greenstar.dto;

import java.util.List;

import lombok.Data;

@Data
public class RoleDTO {

    private int id;
    
    private String roleName;
    
    private List<String> privilages;
    
    private String password;
}
