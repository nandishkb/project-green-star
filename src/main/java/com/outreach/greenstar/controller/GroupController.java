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

import com.outreach.greenstar.dto.GroupDTO;

@RestController
@RequestMapping("/api/v1/group")
public class GroupController {

    @GetMapping(value="/section/{sectionId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GroupDTO>> getGroupsBySection(@PathVariable int sectionId) {
        return new ResponseEntity(null, HttpStatus.OK);
    }
    
    @GetMapping(value="/class/{classId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GroupDTO>> getGroupsByClass(@PathVariable int classId) {
        return new ResponseEntity(null, HttpStatus.OK);
    }
    
    @GetMapping(value="/{groupId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupDTO> getGroup(@PathVariable int groupId) {
        return new ResponseEntity((GroupDTO)null, HttpStatus.OK);
    }
    
    @PostMapping(value="/", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupDTO> createGroup(@RequestBody GroupDTO group) {
        return new ResponseEntity(null, HttpStatus.OK);
    }
    
    @PutMapping(value="/", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupDTO> updateGroup(@RequestBody GroupDTO group) {
        return new ResponseEntity(null, HttpStatus.OK);
    }
}
