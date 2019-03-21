package com.outreach.greenstar.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.outreach.greenstar.dto.GroupReportDTO;
import com.outreach.greenstar.service.ReportsService;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportsController {

    @Autowired
    private ReportsService reportsService;
    
    @GetMapping(value="/group/{groupId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GroupReportDTO>> getReportByGroup(@PathVariable int groupId, @RequestParam String fromDate,
        @RequestParam String toDate) {
        Date from = null;
        Date to = null;
        try {
            from = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
            to = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format. Expected format = yyyy-MM-dd");
        }
        List<GroupReportDTO> dto = reportsService.getReportByGroup(groupId, from, to);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    
//    @GetMapping(value="/group/{groupId}", produces=MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<GroupReportDTO> getReportByGroup(@PathVariable int groupId) {
//        GroupReportDTO dto = reportsService.getReportByGroup(groupId);
//        return new ResponseEntity<GroupReportDTO>(dto, HttpStatus.OK);
//    }
    
}
