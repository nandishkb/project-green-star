package com.outreach.greenstar.dto;

import lombok.Data;

@Data
public class SchoolDTO {

    private int     id;

    private String  name;

    private int     maxClassGrade;

    private String city;
    
    private int pincode;
    
    private String address;
}
