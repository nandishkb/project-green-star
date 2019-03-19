package com.outreach.greenstar.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.outreach.greenstar.dao.StudentDao;
import com.outreach.greenstar.dto.ClsDTO;
import com.outreach.greenstar.dto.GroupDTO;
import com.outreach.greenstar.dto.HolidayDTO;
import com.outreach.greenstar.dto.PerformanceParamDTO;
import com.outreach.greenstar.dto.RoleDTO;
import com.outreach.greenstar.dto.SchoolDTO;
import com.outreach.greenstar.dto.SectionDTO;
import com.outreach.greenstar.dto.StudentDTO;
import com.outreach.greenstar.entities.Cls;
import com.outreach.greenstar.entities.Group;
import com.outreach.greenstar.entities.Holiday;
import com.outreach.greenstar.entities.PerformanceParam;
import com.outreach.greenstar.entities.Privilages;
import com.outreach.greenstar.entities.Role;
import com.outreach.greenstar.entities.School;
import com.outreach.greenstar.entities.Section;
import com.outreach.greenstar.entities.Student;
import com.outreach.greenstar.repository.PrivilagesRepository;

public final class EntityDtoConverter {

    private static final String[] columnHeader = {
            "date", "rollNum", "name", "isHoliday", "attendance", "homework", "discipline", "groupName"
    };
    
    @Autowired
    private static PrivilagesRepository privilagesRepository;
    
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
        schoolDto.setCity(school.getCity());
        schoolDto.setPincode(school.getPincode());
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
        school.setCity(schoolDto.getCity());
        school.setPincode(schoolDto.getPincode());
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

    public static GroupDTO getGroupDto(Group group, StudentDao studentDao) {
        GroupDTO groupDto = new GroupDTO();
        groupDto.setId(group.getId());
        groupDto.setName(group.getName());
        groupDto.setSectionId(group.getSection().getId());
        groupDto.setSectionName(group.getSection().getName());
        List<Student> studentsByGroup = studentDao.getStudentsByGroup(group.getId());
        List<Integer> studentIds = new ArrayList<>();
        List<String> studentNames = new ArrayList<>();
        for (Iterator<Student> iterator = studentsByGroup.iterator(); iterator
            .hasNext();) {
            Student student = iterator.next();
            studentIds.add(student.getId());
            studentNames.add(student.getName());
        }
        groupDto.setStudentIds(studentIds);
        groupDto.setStudentNames(studentNames);
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
            listOfData.add(Constants.DATE_FORMAT_YYYY_MM_DD.format(perfParam.getDate()));//Date
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
        String formattedDate = Constants.DATE_FORMAT_YYYY_MM_DD.format(student.getJoiningDate());
        studentDTO.setJoiningDate(formattedDate);
        studentDTO.setName(student.getName());
        studentDTO.setReligion(student.getReligion());
        studentDTO.setRollNumber(student.getRollNumber());
        studentDTO.setSchoolId(student.getSchool().getId());
        studentDTO.setSectionId(student.getSection().getId());
        studentDTO.setCity(student.getCity());
        studentDTO.setPincode(student.getPincode());
        return studentDTO;
    }
    
    public static Student getStudent(StudentDTO sDto) {
        Student student = new Student();
        student.setAddress(sDto.getAddress());
        student.setCaste(sDto.getCaste());
        student.setId(sDto.getId());
        Date joining = new Date();
        try {
            joining = Constants.DATE_FORMAT_YYYY_MM_DD.parse(sDto.getJoiningDate());
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format for Joining date. Correct Format = yyyy-MM-dd. Ex : 2018-06-01");
        }
        student.setJoiningDate(joining);
        student.setName(sDto.getName());
        student.setReligion(sDto.getReligion());
        student.setRollNumber(sDto.getRollNumber());
        student.setCity(sDto.getCity());
        student.setPincode(sDto.getPincode());
        return student;
    }

    public static HolidayDTO getHolidayDTO(Holiday holiday) {
        HolidayDTO holidayDto = new HolidayDTO();
        holidayDto.setDate(Constants.DATE_FORMAT_YYYY_MM_DD.format(holiday.getDate()));
        holidayDto.setDetails(holiday.getDetails());
        holidayDto.setId(holiday.getId());
        holidayDto.setPublicHoliday(holiday.isPublicHoliday());
        return holidayDto;
    }

    public static Holiday getHoliday(HolidayDTO holidayDTO) {
        Holiday holiday = new Holiday();
        Date date;
        try {
            date = Constants.DATE_FORMAT_YYYY_MM_DD.parse(holidayDTO.getDate());
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format in Holiday Entity. Expected format is yyyy-MM--dd");
        }
        holiday.setDate(date);
        holiday.setDetails(holidayDTO.getDetails());
        holiday.setId(holidayDTO.getId());
        holiday.setPublicHoliday(holidayDTO.isPublicHoliday());
        return holiday;
    }

    public static RoleDTO getRolesDto(Role role) {
        RoleDTO dto = new RoleDTO();
        dto.setId(role.getId());
        dto.setPassword(role.getPwd());
        List<String> listPrev = new ArrayList<>();
        List<Privilages> listOfPrivilages = role.getListOfPrivilages();
        for (Iterator<Privilages> iterator = listOfPrivilages.iterator(); iterator
            .hasNext();) {
            Privilages privilages = (Privilages) iterator.next();
            listPrev.add(privilages.getTitle());
        }
        dto.setPrivilages(listPrev);
        dto.setRoleName(role.getRoleName());
        return dto;
    }
    
    
    public static Role getRole(RoleDTO rDto) {
        Role role = new Role();
        role.setId(rDto.getId());
        role.setPwd(rDto.getPassword());
        role.setRoleName(rDto.getRoleName());
        List<Privilages> listOfPrev = new ArrayList<>();
        List<String> privilages = rDto.getPrivilages();
        List<String> list = Arrays.asList(PrivilageEnum.stringValues());
        for (int i = 0; i < privilages.size(); ++i) {
            String prev = privilages.get(i).toUpperCase();
            if (list.contains(prev)) {
                List<Privilages> findByTitle = privilagesRepository.findByTitle(prev);
                listOfPrev.addAll(findByTitle);
            }
        }
        role.setListOfPrivilages(listOfPrev);
        return role;
    }
    

    


    
}
