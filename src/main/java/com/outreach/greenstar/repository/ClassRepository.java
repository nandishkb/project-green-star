package com.outreach.greenstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.outreach.greenstar.entities.Cls;
import com.outreach.greenstar.entities.School;
import java.util.List;

public interface ClassRepository extends JpaRepository<Cls, Number>{

    List<Cls> findBySchool(School school);
    
}
