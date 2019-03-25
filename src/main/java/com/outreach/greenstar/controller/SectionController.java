package com.outreach.greenstar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outreach.greenstar.dto.SectionDTO;
import com.outreach.greenstar.service.SectionService;

@RestController
@RequestMapping("/api/v1/section")
public class SectionController {
    
    @Autowired
    private SectionService sectionService;

    
    @GetMapping(value="/class/{classId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SectionDTO>> getSectionByClass(@PathVariable int classId) {
        List<SectionDTO> listOfSections = sectionService.getSectionByClass(classId);
        return new ResponseEntity<>(listOfSections, HttpStatus.OK);
    }
    
    @GetMapping(value="/{sectionId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SectionDTO> getSection(@PathVariable int sectionId) {
        SectionDTO section = sectionService.getSection(sectionId);
        return new ResponseEntity<>(section, HttpStatus.OK);
    }
    
    @PostMapping(value="", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SectionDTO> createSection(@RequestBody SectionDTO section) {
        SectionDTO newSection = sectionService.createSection(section);
        return new ResponseEntity<>(newSection, HttpStatus.OK);
    }
    
    @PutMapping(value="", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SectionDTO> updateSection(@RequestBody SectionDTO section) {
        SectionDTO newSection = sectionService.updateSection(section);
        return new ResponseEntity<>(newSection, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{sectionId}")
    public ResponseEntity<String> deleteSection(@PathVariable int sectionId) {
        sectionService.deleteSection(sectionId);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
