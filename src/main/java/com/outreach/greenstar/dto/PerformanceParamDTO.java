package com.outreach.greenstar.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PerformanceParamDTO {

    private Date fromDate;
    private Date toDate;
    private List<String> columnHeaders;
    private List<List<String>> performanceData;
    
}
