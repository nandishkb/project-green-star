package com.outreach.greenstar.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GroupDTO {

    private int id;
    @JsonProperty("label")
    private String name;
    private int size;
    private int sectionId;
    private int classId;
    private String sectionName;
    private String className;
    private String SchoolName;
    private List<Integer> studentIds;
    private List<LabelEntity> studentNames;
}
