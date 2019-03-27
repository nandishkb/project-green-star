package com.outreach.greenstar.dto;

import lombok.Data;

@Data
public class AttendanceCompDTO {

    private String className;
    private String sectionName;
    private int prevMonthPercentage;
    private String prevMonthData;
    private int currMonthPercentage;
    private String currMonthData;
    private String incPercentage;
}
