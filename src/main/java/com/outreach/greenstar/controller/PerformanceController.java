package com.outreach.greenstar.controller;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.outreach.greenstar.dto.PerformanceParamDTO;

@RestController
@RequestMapping("/api/v1/performance")
public class PerformanceController {

    @GetMapping(value = "/{groupId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PerformanceParamDTO> getPerformanceByGroup(
        @PathVariable int groupId, @RequestParam Date fromDate,
        @RequestParam Date toDate) {
        
        return new ResponseEntity(null);

    }
    
    
    
}
