package com.outreach.greenstar.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    
    @GetMapping(value="/welcome")
    public ResponseEntity<String> welcomePerformance() {
        System.out.println("PerformanceController.welcomePerformance() Welcome");
        return new ResponseEntity<String>("successful", HttpStatus.OK);
    }
    
    @GetMapping(value = "/group/{groupId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PerformanceParamDTO> getPerformanceByGroup(
        @PathVariable int groupId, @RequestParam String fromDate,
        @RequestParam String toDate) {
        System.out.println("PerformanceController.getPerformanceByGroup()");
        Date from = null;
        Date to = null;
        try {
            from = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
            to = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format. Expected format = yyyy-MM-dd");
        }
        PerformanceParamDTO perParam = performanceService.getPerformanceByGroup(groupId, from, to);
        return new ResponseEntity<>(perParam, HttpStatus.OK);

    }
    
    @GetMapping(value = "/student/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PerformanceParamDTO> getPerformanceByStudent(
        @PathVariable int studentId, @RequestParam String fromDate,
        @RequestParam String toDate) {
        System.out.println("PerformanceController.getPerformanceByStudent()");
        Date from = null;
        Date to = null;
        try {
            from = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
            to = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Invalid date format. Expected format = yyyy-MM-dd");
        }
        PerformanceParamDTO perParam = performanceService.getPerformanceByStudent(studentId, from, to);
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
    
    @PostMapping(value="", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PerformanceParamDTO> updatePerformance(@RequestBody PerformanceParamDTO param) {
        PerformanceParamDTO failed = performanceService.updatePerformanceParam(param);
        return new ResponseEntity<>(failed, HttpStatus.OK);
    }
    
    
    
}
