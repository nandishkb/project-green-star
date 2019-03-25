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

import com.outreach.greenstar.dto.GroupDTO;
import com.outreach.greenstar.service.GroupService;

@RestController
@RequestMapping("/api/v1/group")
public class GroupController {

    @Autowired
    private GroupService groupService;
    
    @GetMapping(value="/section/{sectionId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GroupDTO>> getGroupsBySection(@PathVariable int sectionId) {
        List<GroupDTO> listOfGroups = groupService.getGroupsBySection(sectionId);
        return new ResponseEntity<>(listOfGroups, HttpStatus.OK);
    }
    
    @GetMapping(value="/class/{classId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GroupDTO>> getGroupsByClass(@PathVariable int classId) {
        List<GroupDTO> listOfGroups = groupService.getGroupsByClass(classId);
        return new ResponseEntity<>(listOfGroups, HttpStatus.OK);
    }
    
    @GetMapping(value="/{groupId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupDTO> getGroup(@PathVariable int groupId) {
        GroupDTO group = groupService.getGroup(groupId);
        return new ResponseEntity<>(group, HttpStatus.OK);
    }
    
    /*@GetMapping(value="/school/{schoolId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GroupDTO>> getGroupsBySchool(@PathVariable int schoolId) {
        List<GroupDTO> listOfGroups = groupService.getGroupsBySchool(schoolId);
        return new ResponseEntity<>(listOfGroups, HttpStatus.OK);
    }*/
    
    @PostMapping(value="", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupDTO> createGroup(@RequestBody GroupDTO group) {
        GroupDTO newGroup = groupService.createGroup(group);
        return new ResponseEntity<>(newGroup, HttpStatus.OK);
    }
    
    @PutMapping(value="", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupDTO> updateGroup(@RequestBody GroupDTO group) {
        GroupDTO groupDto = groupService.updateGroup(group);
        return new ResponseEntity<>(groupDto, HttpStatus.OK);
    }
    
    @DeleteMapping(value="")
    public ResponseEntity<String> deleteGroup(@PathVariable int groupId) {
        groupService.deleteGroup(groupId);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
