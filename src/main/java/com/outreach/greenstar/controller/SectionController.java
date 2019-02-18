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

import com.outreach.greenstar.dto.SectionDTO;

@RestController
@RequestMapping("/api/v1/section")
public class SectionController {

    
    @GetMapping(value="/class/{classId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SectionDTO>> getSectionByClass(@PathVariable int classId) {
        return new ResponseEntity(null, HttpStatus.OK);
    }
    
    @GetMapping(value="/{sectionId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SectionDTO>> getSection(@PathVariable int sectionId) {
        return new ResponseEntity(null, HttpStatus.OK);
    }
    
    @PostMapping(value="/", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SectionDTO> createSection(@RequestBody SectionDTO section) {
        return new ResponseEntity(null, HttpStatus.OK);
    }
    
    @PutMapping(value="/", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SectionDTO> updateSection(@RequestBody SectionDTO section) {
        return new ResponseEntity(null, HttpStatus.OK);
    }
}
