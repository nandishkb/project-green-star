package com.outreach.greenstar.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outreach.greenstar.dto.SchoolDTO;

@RestController
@RequestMapping("/api/v1/school")
public class SchoolController {

    @GetMapping(value="/", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SchoolDTO>> getSchools() {
        return new ResponseEntity(null, HttpStatus.OK);
    }
    
    @GetMapping(value="/{schoolId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolDTO> getSchool(@PathVariable int schoolId) {
        return new ResponseEntity(null, HttpStatus.OK);
    }
    
    @PostMapping(value="/", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolDTO> createSchool(@RequestBody SchoolDTO school) {
        return new ResponseEntity(null, HttpStatus.OK);
    }
}
