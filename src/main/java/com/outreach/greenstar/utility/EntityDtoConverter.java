package com.outreach.greenstar.utility;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.outreach.greenstar.dto.ClsDTO;
import com.outreach.greenstar.dto.GroupDTO;
import com.outreach.greenstar.dto.PerformanceParamDTO;
import com.outreach.greenstar.entities.Cls;
import com.outreach.greenstar.entities.Group;
import com.outreach.greenstar.entities.PerformanceParam;

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

    public static Cls getCls(ClsDTO clsObj) {
        Cls cls = new Cls();
        cls.setGrade(clsObj.getGrade());
        cls.setId(clsObj.getId());
        // cls.setSchoolId(clsObj.getSchool().getId());
        return cls;
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
}
