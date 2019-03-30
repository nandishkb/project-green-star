package com.outreach.greenstar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.outreach.greenstar.entities.Cls;
import com.outreach.greenstar.entities.Group;
import com.outreach.greenstar.entities.School;
import com.outreach.greenstar.entities.Section;
import com.outreach.greenstar.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Number> {

    List<Student> findByGroup(Group group);

    List<Student> findBySection(Section section);

    List<Student> findByCls(Cls cls);

    List<Student> findBySchool(School school);

    List<Student> findByClsAndGroupIsNull(Cls cls);

    List<Student> findBySectionAndGroupIsNull(Section section);
    
}
