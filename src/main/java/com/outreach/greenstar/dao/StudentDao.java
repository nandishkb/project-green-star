package com.outreach.greenstar.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.outreach.greenstar.entities.Cls;
import com.outreach.greenstar.entities.Group;
import com.outreach.greenstar.entities.School;
import com.outreach.greenstar.entities.Section;
import com.outreach.greenstar.entities.Student;
import com.outreach.greenstar.exeption.ClsNotFoundException;
import com.outreach.greenstar.exeption.GroupNotFoundException;
import com.outreach.greenstar.exeption.SchoolNotFoundException;
import com.outreach.greenstar.exeption.SectionNotFoundException;
import com.outreach.greenstar.repository.StudentRepository;

@Repository("studentDao")
public class StudentDao {

    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private GroupDao groupDao;
    
    @Autowired
    private SectionDao sectionDao;
    
    @Autowired
    private ClassDao classDao;
    
    @Autowired
    private SchoolDao schoolDao;
    
    public Student getStudentById(int studentId) {
        return studentRepository.getOne(studentId);
    }

    public List<Student> getStudentsByGroup(int groupId) {
        Group group = groupDao.getGroupById(groupId);
        if (group != null) {
            return studentRepository.findByGroup(group);
        }
        throw new GroupNotFoundException("Invalid Group ID = "+groupId);
    }

    public List<Student> getStudentsBySection(int secId) {
        Section section = sectionDao.getSectionById(secId);
        if (section != null) {
            return studentRepository.findBySection(section);
        }
        throw new SectionNotFoundException("Invalid Section ID = "+secId);
    }
    
    public List<Student> getAvailableStudentsBySection(int secId) {
        Section section = sectionDao.getSectionById(secId);
        if (section != null) {
            return studentRepository.findBySectionAndGroupIsNull(section);
        }
        throw new SectionNotFoundException("Invalid Section ID = "+secId);
    }

    public List<Student> getStudentsByClass(int classId) {
        Cls cls = classDao.getClassById(classId);
        if (cls != null) {
            return studentRepository.findByCls(cls);
        }
        throw new ClsNotFoundException("Invalid Class ID = "+classId);
    }
    
    public List<Student> getAvailableStudentsByClass(int classId) {
        Cls cls = classDao.getClassById(classId);
        if (cls != null) {
            return studentRepository.findByClsAndGroupIsNull(cls);
        }
        throw new ClsNotFoundException("Invalid Class ID = "+classId);
    }

    public List<Student> getStudentsBySchool(int schoolId) {
        School school = schoolDao.getSchoolById(schoolId);
        if (school != null) {
            return studentRepository.findBySchool(school);
        }
        throw new SchoolNotFoundException("Invalid School ID = "+schoolId);
    }

    @Transactional
    public Student createOrUpdateStudent(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

}
