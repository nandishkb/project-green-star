package com.outreach.greenstar.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class StarDetailsDTO {

    int numberOfDays;
    Date month;
    List<String> attendanceDetails;
    List<String> homeWorkDetails;
    List<String> desciplineDetails;
    
}
