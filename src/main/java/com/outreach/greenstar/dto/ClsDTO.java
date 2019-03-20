package com.outreach.greenstar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ClsDTO {
    private int id;
    private int grade;
    @JsonProperty("label")
    private String className;
    private int schoolId;
    private String schoolName;
}
