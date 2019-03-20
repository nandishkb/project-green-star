package com.outreach.greenstar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SectionDTO {

    private int    id;

    @JsonProperty("label")
    private String name;

    private int    classId;
    
    private String className;
    
    private String schoolName;
}
