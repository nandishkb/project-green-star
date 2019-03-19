package com.outreach.greenstar.dto;

import java.util.List;

import lombok.Data;

@Data
public class PerformanceParamDTO {

    private String fromDate;
    private String toDate;
    private List<String> columnHeaders;
    private List<List<String>> performanceData;
    
}
