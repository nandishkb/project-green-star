package com.outreach.greenstar.dto;

import lombok.Data;

@Data
public class ClassGroupWiseReportDTO {

    private String groupName;
    private int attendance;
    private int discipline;
    private int homework;
    private int total;
}
