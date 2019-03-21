package com.outreach.greenstar.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class GroupReportDTO {
    private int rollNum;
    private String studentName;
    private String caste;
    private List<PerformanceData> performanceData = new ArrayList<>();
    private Summary summary;
}
