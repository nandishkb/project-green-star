package com.outreach.greenstar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class StudentDTO {

    private int id;
    
    private int rollNumber;
    
    @JsonProperty("label")
    private String name;
    
    private String caste;
    
    private String religion;
    
    private String gender;
    
    private String joiningDate;
    
    private int schoolId;
    
    private int clsId;
    
    private int sectionId;
    
    private int groupId;
    
    private String city;
    
    private int pincode;
    
    private String address;
}
