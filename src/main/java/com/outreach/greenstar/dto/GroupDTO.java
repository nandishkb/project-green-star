package com.outreach.greenstar.dto;

import lombok.Data;

@Data
public class GroupDTO {

    private int id;
    private String name;
    private int size;
    private int sectionId;
    private int classId;
    private String sectionName;
}
