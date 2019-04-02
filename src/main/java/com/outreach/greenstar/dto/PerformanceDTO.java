package com.outreach.greenstar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PerformanceDTO {

    private boolean attendance;
    
    private boolean homeWork;
    
    private boolean discipline;
    
    private String date;
    
    private int studentId;
    
    @JsonProperty("label")
    private String studentName;
    
}
