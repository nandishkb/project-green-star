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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.outreach.greenstar.dto.StarDetailsDTO;
import com.outreach.greenstar.service.StarService;
import com.outreach.greenstar.utility.Constants;

@RestController
@RequestMapping("/api/v1/star")
public class StarController {
    
    @Autowired
    private StarService starService;

    @GetMapping(value="/student/{studentId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StarDetailsDTO> getStarDetailsForStudent(@PathVariable int studentId, @RequestParam String month) {
        Date monthYear = null;
        try {
            monthYear = Constants.DATE_FORMAT_YYYY_MM.parse(month);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format. Expected format = "+Constants.DATE_FORMAT_YYYY_MM.toString());
        }
        StarDetailsDTO starDetailsDTO = starService.getStarDetailsByStudent(studentId, monthYear);
        return new ResponseEntity<>(starDetailsDTO, HttpStatus.OK);
        
    }
    
    @GetMapping(value="/group/{groupId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StarDetailsDTO> getStarDetailsForGroup(@PathVariable int groupId, @RequestParam String month) {
        Date monthYear = null;
        try {
            monthYear = Constants.DATE_FORMAT_YYYY_MM.parse(month);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format. Expected format = "+Constants.DATE_FORMAT_YYYY_MM.toString());
        }
        StarDetailsDTO starDetailsDTO = starService.getStarDetailsByGroup(groupId, monthYear);
        return new ResponseEntity<>(starDetailsDTO, HttpStatus.OK);
        
    }

}
