package com.outreach.greenstar.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.outreach.greenstar.dto.ClsDTO;
import com.outreach.greenstar.dto.GroupDTO;
import com.outreach.greenstar.dto.PerformanceParamDTO;
import com.outreach.greenstar.dto.SchoolDTO;
import com.outreach.greenstar.dto.SectionDTO;
import com.outreach.greenstar.dto.StudentDTO;
import com.outreach.greenstar.entities.Cls;
import com.outreach.greenstar.entities.Group;
import com.outreach.greenstar.entities.PerformanceParam;
import com.outreach.greenstar.entities.School;
import com.outreach.greenstar.entities.Section;
import com.outreach.greenstar.entities.Student;

public final class EntityDtoConverter {

    private static final String[] columnHeader = {
            "date", "rollNum", "name", "isHoliday", "attendance", "homework", "discipline", "groupName"
    };
    
    private EntityDtoConverter() {

    }

    public static ClsDTO getClsDTO(Cls clsObj) {
        ClsDTO clsDto = new ClsDTO();
        clsDto.setGrade(clsObj.getGrade());
        clsDto.setId(clsObj.getId());
        clsDto.setSchoolId(clsObj.getSchool().getId());
        return clsDto;
    }

    public static SchoolDTO getSchoolDTO(School school) {
        SchoolDTO schoolDto = new SchoolDTO();
        schoolDto.setAddress(school.getAddress());
        schoolDto.setId(school.getId());
        schoolDto.setMaxClassGrade(school.getMaxClassGrade());
        schoolDto.setName(school.getName());
        return schoolDto;
    }
    
    public static Cls getCls(ClsDTO clsObj) {
        Cls cls = new Cls();
        cls.setGrade(clsObj.getGrade());
        cls.setId(clsObj.getId());
        // cls.setSchoolId(clsObj.getSchool().getId());
        return cls;
    }
    
    public static School getSchool(SchoolDTO schoolDto) {
        School school = new School();
        school.setAddress(schoolDto.getAddress());
        school.setId(schoolDto.getId());
        school.setMaxClassGrade(schoolDto.getMaxClassGrade());
        school.setName(schoolDto.getName());
        return school;
    }

    public static SectionDTO getSectionDTO(Section section) {
        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setClassId(section.getCls().getId());
        sectionDTO.setId(section.getId());
        sectionDTO.setName(section.getName());
        return sectionDTO;
    }
    
    public static Section getSection(SectionDTO sectionDTO) {
        Section section = new Section();
        section.setId(sectionDTO.getId());
        section.setName(sectionDTO.getName());
        return section;
    }

    public static GroupDTO getGroupDto(Group group) {
        GroupDTO groupDto = new GroupDTO();
        groupDto.setId(group.getId());
        groupDto.setName(group.getName());
        groupDto.setSectionId(group.getSection().getId());
        groupDto.setSectionName(group.getSection().getName());
        return groupDto;
    }

    public static Group getGroup(GroupDTO groupDto) {
        Group grp = new Group();
        grp.setId(groupDto.getId());
        grp.setName(groupDto.getName());
        grp.setSize(groupDto.getSize());
        return grp;
    }

    public static PerformanceParamDTO getPerformanceParamDTO(
        List<PerformanceParam> listOfPerf) {
        PerformanceParamDTO perfDTO = new PerformanceParamDTO();
        perfDTO.setColumnHeaders(Arrays.asList(columnHeader));
        List<List<String>> performanceData = new ArrayList<>();
        for (Iterator<PerformanceParam> iterator = listOfPerf.iterator(); iterator.hasNext();) {
            PerformanceParam perfParam = (PerformanceParam) iterator.next();
            ArrayList<String> listOfData = new ArrayList<>();
            listOfData.add(perfParam.getDate().toString());//Date
            listOfData.add(perfParam.getStudent().getRollNumber() + "");//Rollnumber
            listOfData.add(perfParam.getStudent().getName());//Name
            SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
            String dayOfWeek = simpleDateformat.format(perfParam.getDate());
            String holiday = "false";
            if ("Sunday".equalsIgnoreCase(dayOfWeek) || "Saturday".equalsIgnoreCase(dayOfWeek)) {
                holiday = "true";
            }
            listOfData.add(holiday);//isHoliday
            listOfData.add(perfParam.isPresent() + "");//Attendance
            listOfData.add(perfParam.isHWDone() + "");//Homework
            listOfData.add(perfParam.isDisciplined() + "");//Discipline
            listOfData.add(perfParam.getGroup().getName());//GroupName
            performanceData.add(listOfData);
        }
        perfDTO.setPerformanceData(performanceData);
        return perfDTO;
    }

    public static StudentDTO getStudentDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setAddress(student.getAddress());
        studentDTO.setCaste(student.getCaste());
        studentDTO.setClsId(student.getCls().getId());
        Group group = student.getGroup();
        if (group != null) {
            studentDTO.setGroupId(group.getId());
        } else {
            studentDTO.setGroupId(-1);
        }
        studentDTO.setId(student.getId());
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(student.getJoiningDate());
        studentDTO.setJoiningDate(formattedDate);
        studentDTO.setName(student.getName());
        studentDTO.setReligion(student.getReligion());
        studentDTO.setRollNumber(student.getRollNumber());
        studentDTO.setSchoolId(student.getSchool().getId());
        studentDTO.setSectionId(student.getSection().getId());
        return studentDTO;
    }
    
    public static Student getStudent(StudentDTO sDto) {
        Student student = new Student();
        student.setAddress(sDto.getAddress());
        student.setCaste(sDto.getCaste());
        student.setId(sDto.getId());
        Date joining = new Date();
        try {
            joining = new SimpleDateFormat("yyyy-MM-dd").parse(sDto.getJoiningDate());
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format for Joining date. Correct Format = yyyy-MM-dd. Ex : 2018-06-01");
        }
        student.setJoiningDate(joining);
        student.setName(sDto.getName());
        student.setReligion(sDto.getReligion());
        student.setRollNumber(sDto.getRollNumber());
        return student;
    }

    


    
}
