package com.outreach.greenstar.dto;

import lombok.Data;

@Data
public class ClassSectionWiseReportDTO {
    private String sectionName;
    private int attendance;
    private int discipline;
    private int homework;
    private int total;
}
