package com.outreach.greenstar.controller;

import java.util.List;

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

import com.outreach.greenstar.dto.ClsDTO;
import com.outreach.greenstar.dto.SectionDTO;

@RestController
@RequestMapping("/api/v1/class")
public class ClassController {

    @GetMapping(value="/school/{schoolId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SectionDTO>> getClassBySchool(@PathVariable int schoolId) {
        return new ResponseEntity(null, HttpStatus.OK);
    }
    
    @GetMapping(value="/{classId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClsDTO> getGroup(@PathVariable int classId) {
        return new ResponseEntity((ClsDTO)null, HttpStatus.OK);
    }
    
    @PostMapping(value="/", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClsDTO> createClass(@RequestBody ClsDTO group) {
        return new ResponseEntity(null, HttpStatus.OK);
    }
    
    @PutMapping(value="/", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClsDTO> updateClass(@RequestBody ClsDTO group) {
        return new ResponseEntity(null, HttpStatus.OK);
    }
}
