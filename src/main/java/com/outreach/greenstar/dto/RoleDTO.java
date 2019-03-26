package com.outreach.greenstar.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.outreach.greenstar.entities.Privilages;

import lombok.Data;

@Data
public class RoleDTO {

    private int id;
    
    @JsonProperty("label")
    private String roleName;
    
    private List<PrivilagesDTO> privilages;
    
//    @JsonIgnore
    private String password;
}
