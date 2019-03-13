package com.outreach.greenstar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outreach.greenstar.dao.ClassDao;
import com.outreach.greenstar.dao.GroupDao;
import com.outreach.greenstar.dao.SchoolDao;
import com.outreach.greenstar.dao.SectionDao;
import com.outreach.greenstar.dao.StudentDao;
import com.outreach.greenstar.dto.StudentDTO;
import com.outreach.greenstar.entities.Cls;
import com.outreach.greenstar.entities.Group;
import com.outreach.greenstar.entities.School;
import com.outreach.greenstar.entities.Section;
import com.outreach.greenstar.entities.Student;
import com.outreach.greenstar.utility.EntityDtoConverter;

@Service("studentService")
public class StudentService {

    @Autowired
    private StudentDao studentDao;
    
    @Autowired
    private SchoolDao schoolDao;
    
    @Autowired
    private ClassDao  classDao;
    
    @Autowired
    private GroupDao groupDao;
    
    @Autowired
    private SectionDao sectionDao;
    
    public List<StudentDTO> getStudentsByGroup(int groupId) {
        List<Student> listOfStudent = studentDao.getStudentsByGroup(groupId);
        List<StudentDTO> listOfStudentsDTO = new ArrayList<>();
        for (int i = 0 ; i < listOfStudent.size() ; ++i) {
            listOfStudentsDTO.add(EntityDtoConverter.getStudentDTO(listOfStudent.get(i)));
        }
        return listOfStudentsDTO;
    }

    public List<StudentDTO> getStudentsBySection(int secId) {
        List<Student> listOfStudent = studentDao.getStudentsBySection(secId);
        List<StudentDTO> listOfStudentsDTO = new ArrayList<>();
        for (int i = 0 ; i < listOfStudent.size() ; ++i) {
            listOfStudentsDTO.add(EntityDtoConverter.getStudentDTO(listOfStudent.get(i)));
        }
        return listOfStudentsDTO;
    }
    
    public List<StudentDTO> getAvailableStudentsBySection(int secId) {
        List<Student> listOfStudent = studentDao.getAvailableStudentsBySection(secId);
        List<StudentDTO> listOfStudentsDTO = new ArrayList<>();
        for (int i = 0 ; i < listOfStudent.size() ; ++i) {
            listOfStudentsDTO.add(EntityDtoConverter.getStudentDTO(listOfStudent.get(i)));
        }
        return listOfStudentsDTO;
    }

    public List<StudentDTO> getStudentsByClass(int classId) {
        List<Student> listOfStudent = studentDao.getStudentsByClass(classId);
        List<StudentDTO> listOfStudentsDTO = new ArrayList<>();
        for (int i = 0 ; i < listOfStudent.size() ; ++i) {
            listOfStudentsDTO.add(EntityDtoConverter.getStudentDTO(listOfStudent.get(i)));
        }
        return listOfStudentsDTO;
    }
    
    public List<StudentDTO> getAvailableStudentsByClass(int classId) {
        List<Student> listOfStudent = studentDao.getAvailableStudentsByClass(classId);
        List<StudentDTO> listOfStudentsDTO = new ArrayList<>();
        for (int i = 0 ; i < listOfStudent.size() ; ++i) {
            listOfStudentsDTO.add(EntityDtoConverter.getStudentDTO(listOfStudent.get(i)));
        }
        return listOfStudentsDTO;
    }

    public List<StudentDTO> getStudentsBySchool(int schoolId) {
        List<Student> listOfStudent = studentDao.getStudentsBySchool(schoolId);
        List<StudentDTO> listOfStudentsDTO = new ArrayList<>();
        for (int i = 0 ; i < listOfStudent.size() ; ++i) {
            listOfStudentsDTO.add(EntityDtoConverter.getStudentDTO(listOfStudent.get(i)));
        }
        return listOfStudentsDTO;
    }

    public StudentDTO createStudent(StudentDTO studentDto) {
        Student student = EntityDtoConverter.getStudent(studentDto);
        School school = schoolDao.getSchoolById(studentDto.getSchoolId());
        if (school == null) {
            throw new IllegalArgumentException("Invalid School Id = "+studentDto.getSchoolId());
        }
        Cls cls = classDao.getClassById(studentDto.getClsId());
        if (cls == null) {
            throw new IllegalArgumentException("Invalid Class Id = "+studentDto.getClsId());
        }
        
        Section section = sectionDao.getSectionById(studentDto.getSectionId());
        if (section == null) {
            throw new IllegalArgumentException("Invalid section Id = "+studentDto.getSectionId());
        }
        
        Group group = groupDao.getGroupById(studentDto.getGroupId());
        if (group == null) {
            throw new IllegalArgumentException("Invalid group Id = "+studentDto.getGroupId());
        }
        
        student.setSchool(school);
        student.setCls(cls);
        student.setSection(section);
        student.setGroup(group);
        student = studentDao.createOrUpdateStudent(student);
        return EntityDtoConverter.getStudentDTO(student);
    }

    public StudentDTO updateStudent(StudentDTO studentDto) {
        return createStudent(studentDto);
    }

    public StudentDTO getStudent(int studentId) {
        Student student = studentDao.getStudentById(studentId);
        return EntityDtoConverter.getStudentDTO(student);
    }

    

}
