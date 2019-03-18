package com.outreach.greenstar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outreach.greenstar.dto.SchoolDTO;
import com.outreach.greenstar.service.SchoolService;

@RestController
@RequestMapping("/api/v1/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;
    
    @GetMapping(value="", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SchoolDTO>> getSchools() {
        List<SchoolDTO> listOfSchools = schoolService.getAllSchools(); 
        return new ResponseEntity<>(listOfSchools, HttpStatus.OK);
    }
    
    @GetMapping(value="/{schoolId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolDTO> getSchool(@PathVariable int schoolId) {
        SchoolDTO school = schoolService.getSchool(schoolId);
        return new ResponseEntity<>(school, HttpStatus.OK);
    }
    
    @PostMapping(value="", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolDTO> createSchool(@RequestBody SchoolDTO school) {
        SchoolDTO newSchool = schoolService.createSchool(school);
        return new ResponseEntity<>(newSchool, HttpStatus.OK);
    }
    
    @PutMapping(value="", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolDTO> updateSchool(@RequestBody SchoolDTO school) {
        SchoolDTO updatedSchool = schoolService.updateSchool(school);
        return new ResponseEntity<>(updatedSchool, HttpStatus.OK);
    }
}
