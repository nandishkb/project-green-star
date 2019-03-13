package com.outreach.greenstar.dto;

import java.util.List;

import lombok.Data;

@Data
public class GroupDTO {

    private int id;
    private String name;
    private int size;
    private int sectionId;
    private int classId;
    private String sectionName;
    private List<Integer> studentIds;
}
