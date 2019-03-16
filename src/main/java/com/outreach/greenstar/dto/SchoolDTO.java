package com.outreach.greenstar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SchoolDTO {

    private int     id;

    @JsonProperty("label")
    private String  name;

    private int     maxClassGrade;

    private String city;
    
    private int pincode;
    
    private String address;
}
