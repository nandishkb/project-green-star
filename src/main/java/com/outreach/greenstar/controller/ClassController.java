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

import com.outreach.greenstar.dto.ClsDTO;
import com.outreach.greenstar.service.ClassService;

@RestController
@RequestMapping("/api/v1/class")
public class ClassController {

    @Autowired
    private ClassService classService;
    
    @GetMapping(value="/school/{schoolId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClsDTO>> getClassBySchool(@PathVariable int schoolId) {
        List<ClsDTO> listOfClass = classService.getClassBySchool(schoolId);
        return new ResponseEntity<>(listOfClass, HttpStatus.OK);
    }
    
    @GetMapping(value="/{classId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClsDTO> getClassById(@PathVariable int classId) {
        ClsDTO cls = classService.getClassById(classId);
        return new ResponseEntity<>(cls, HttpStatus.OK);
    }
    
    @PostMapping(value="/", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClsDTO> createClass(@RequestBody ClsDTO cls) {
        ClsDTO newCls = classService.createClass(cls);
        return new ResponseEntity<>(newCls, HttpStatus.OK);
    }
    
    @PutMapping(value="/", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClsDTO> updateClass(@RequestBody ClsDTO cls) {
        ClsDTO updatedCls = classService.updateClass(cls);
        return new ResponseEntity<>(updatedCls, HttpStatus.OK);
    }
}
