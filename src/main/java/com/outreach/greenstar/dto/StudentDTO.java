package com.outreach.greenstar.dto;

import com.outreach.greenstar.entities.Address;

import lombok.Data;

@Data
public class StudentDTO {

    private int id;
    
    private int rollNumber;
    
    private String name;
    
    private Address address;
    
    private String caste;
    
    private String religion;
    
    private String gender;
    
    private String joiningDate;
    
    private int schoolId;
    
    private int clsId;
    
    private int sectionId;
    
    private int groupId;
}
