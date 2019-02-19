package com.outreach.greenstar.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.outreach.greenstar.dto.PerformanceParamDTO;
import com.outreach.greenstar.service.PerformanceService;

@RestController
@RequestMapping("/api/v1/performance")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;
    
    @GetMapping(value = "/group/{groupId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PerformanceParamDTO> getPerformanceByGroup(
        @PathVariable int groupId, @RequestParam Date fromDate,
        @RequestParam Date toDate) {
        PerformanceParamDTO perParam = performanceService.getPerformanceByGroup(groupId, fromDate, toDate);
        return new ResponseEntity<>(perParam, HttpStatus.OK);

    }
    
    @GetMapping(value = "/class/{classId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PerformanceParamDTO> getPerformanceByClass(
        @PathVariable int classId, @RequestParam Date fromDate,
        @RequestParam Date toDate) {
        PerformanceParamDTO perParam = performanceService.getPerformanceByClass(classId, fromDate, toDate);
        return new ResponseEntity<>(perParam, HttpStatus.OK);
    }
    
    @GetMapping(value = "/section/{sectionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PerformanceParamDTO> getPerformanceBySection(
        @PathVariable int sectionId, @RequestParam Date fromDate,
        @RequestParam Date toDate) {
        PerformanceParamDTO perParam = performanceService.getPerformanceBySection(sectionId, fromDate, toDate);
        return new ResponseEntity<>(perParam, HttpStatus.OK);
    }
    
    @PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updatePerformance(@RequestBody PerformanceParamDTO param) {
        performanceService.updatePerformanceParam(param);
        return new ResponseEntity<String>("Update successful", HttpStatus.OK);
    }
    
    
    
}
