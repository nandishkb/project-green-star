package com.outreach.greenstar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.outreach.greenstar.entities.Student;
import com.outreach.greenstar.repository.StudentRepository;

@Repository("studentDao")
public class StudentDao {

    @Autowired
    private StudentRepository studentRepository;
    
    public Student getStudentById(int studentId) {
        return studentRepository.getOne(studentId);
    }

}
