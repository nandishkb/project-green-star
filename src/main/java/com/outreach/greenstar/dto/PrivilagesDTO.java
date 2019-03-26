package com.outreach.greenstar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PrivilagesDTO {


    private int id;
    
    @JsonProperty("label")
    private String title;
    
}