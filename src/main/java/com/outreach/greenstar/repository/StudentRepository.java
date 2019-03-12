package com.outreach.greenstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.outreach.greenstar.entities.Student;
import com.outreach.greenstar.entities.Group;
import java.util.List;
import com.outreach.greenstar.entities.Section;
import com.outreach.greenstar.entities.Cls;
import com.outreach.greenstar.entities.School;

public interface StudentRepository extends JpaRepository<Student, Number> {

    List<Student> findByGroup(Group group);
    
    List<Student> findBySection(Section section);
    
    List<Student> findByCls(Cls cls);
    
    List<Student> findBySchool(School school);
}
