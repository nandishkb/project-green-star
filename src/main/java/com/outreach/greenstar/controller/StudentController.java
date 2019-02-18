package com.outreach.greenstar.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outreach.greenstar.dto.StudentDTO;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @GetMapping(value="/group/{groupId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDTO>> getStudentsByGroup(@PathVariable int groupId) {
        return new ResponseEntity(null, HttpStatus.OK);
    }
    
    @GetMapping(value="/section/{secId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDTO>> getStudentsBySection(@PathVariable int secId) {
        return new ResponseEntity(null, HttpStatus.OK);
    }
    
    @GetMapping(value="/class/{classId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDTO>> getStudentsByClass(@PathVariable int classId) {
        return new ResponseEntity(null, HttpStatus.OK);
    }
    
    @GetMapping(value="/school/{schoolId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDTO>> getStudentsBySchool(@PathVariable int schoolId) {
        return new ResponseEntity(null, HttpStatus.OK);
    }
}
