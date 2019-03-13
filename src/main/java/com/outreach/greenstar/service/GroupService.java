package com.outreach.greenstar.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outreach.greenstar.dao.ClassDao;
import com.outreach.greenstar.dao.GroupDao;
import com.outreach.greenstar.dao.SectionDao;
import com.outreach.greenstar.dao.StudentDao;
import com.outreach.greenstar.dto.GroupDTO;
import com.outreach.greenstar.entities.Cls;
import com.outreach.greenstar.entities.Group;
import com.outreach.greenstar.entities.Section;
import com.outreach.greenstar.entities.Student;
import com.outreach.greenstar.utility.EntityDtoConverter;

@Service("groupService")
public class GroupService {
    
    @Autowired
    private GroupDao groupDao;
    
    @Autowired
    private SectionDao sectionDao;
    
    @Autowired
    private ClassDao classDao;
    
    @Autowired
    private StudentDao studentDao;
    

    public List<GroupDTO> getGroupsBySection(int sectionId) {
        List<Group> listOfGroup = groupDao.getGroupBySection(sectionId);
        List<GroupDTO> listOfGroupDTOs = new ArrayList<>();
        for (int i = 0; i < listOfGroup.size(); ++i) {
            listOfGroupDTOs.add(EntityDtoConverter.getGroupDto(listOfGroup.get(i)));
        }
        return listOfGroupDTOs;
    }

    public List<GroupDTO> getGroupsByClass(int classId) {
        List<Group> listOfGroup = groupDao.getGroupByClass(classId);
        List<GroupDTO> listOfGroupDTOs = new ArrayList<>();
        for (int i = 0; i < listOfGroup.size(); ++i) {
            listOfGroupDTOs.add(EntityDtoConverter.getGroupDto(listOfGroup.get(i)));
        }
        return listOfGroupDTOs;
    }

    public GroupDTO getGroup(int groupId) {
        Group group = groupDao.getGroupById(groupId);
        return EntityDtoConverter.getGroupDto(group);
    }

    public GroupDTO createOrUpdateGroup(GroupDTO groupDto) {
        
        Group grp = EntityDtoConverter.getGroup(groupDto);
        Cls cls = classDao.getClassById(groupDto.getClassId());
        if (cls == null) {
            throw new IllegalArgumentException("Group should be associated with Class. Invalid Class Id");
        }
        grp.setCls(cls);
        Section section = sectionDao.getSectionById(groupDto.getSectionId());
        if (section == null) {
            throw new IllegalArgumentException("Group should be associated with Section. Invalid Section Id");
        }
        grp.setSection(section);
        Group newGroup = groupDao.createOrUpdateGroup(grp);
        // Update group to students
        List<Integer> studentIds = groupDto.getStudentIds();
        if (studentIds != null) {
            for (Iterator<Integer> iterator = studentIds.iterator(); iterator
                .hasNext();) {
                int studentId = iterator.next();
                Student student = studentDao.getStudentById(studentId);
                student.setGroup(newGroup);
                studentDao.createOrUpdateStudent(student);
            }
        }
        return EntityDtoConverter.getGroupDto(newGroup);
    }

    public List<GroupDTO> getGroupsBySchool(int schoolId) {
        List<Group> listOfGroup = groupDao.getGroupBySchool(schoolId);
        List<GroupDTO> listOfGroupDTOs = new ArrayList<>();
        for (int i = 0; i < listOfGroup.size(); ++i) {
            listOfGroupDTOs.add(EntityDtoConverter.getGroupDto(listOfGroup.get(i)));
        }
        return listOfGroupDTOs;
    }

}
