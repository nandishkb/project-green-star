package com.outreach.greenstar.dto;

import com.outreach.greenstar.entities.Address;

import lombok.Data;

@Data
public class SchoolDTO {

    private int     id;

    private String  name;

    private int     maxClassGrade;

    private Address address;
}
