package com.outreach.greenstar.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outreach.greenstar.dto.LabelEntity;
import com.outreach.greenstar.service.SchoolService;

@RestController
@RequestMapping("/api/v1/city")
public class CityController {

    @Autowired
    private SchoolService schoolService;
    
    @GetMapping(value="", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<LabelEntity>> getCities() {
        Set<LabelEntity> listOfCities = schoolService.getAllCities(); 
        return new ResponseEntity<>(listOfCities, HttpStatus.OK);
    }
}
