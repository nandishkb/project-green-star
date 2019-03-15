package com.outreach.greenstar.dto;

import java.util.List;

import lombok.Data;

@Data
public class StarDetailsDTO {

    int numberOfDays;
    String month;
    List<String> attendanceDetails;
    List<String> homeWorkDetails;
    List<String> desciplineDetails;
    
}
