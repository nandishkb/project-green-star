package com.outreach.greenstar.dao;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.outreach.greenstar.entities.Cls;
import com.outreach.greenstar.entities.School;
import com.outreach.greenstar.repository.ClassRepository;
import com.outreach.greenstar.repository.SchoolRepository;

@Repository("classDao")
public class ClassDao {

    @Autowired
    private ClassRepository classRepository;
    
    @Autowired
    private SchoolRepository schoolRepository;
    
    public List<Cls> getClassBySchool(int schoolId) {
        Optional<School> schoolOptional = schoolRepository.findById(schoolId);
        if (schoolOptional.isPresent()) {
            return classRepository.findBySchool(schoolOptional.get());
        }
        return Collections.emptyList();
    }

    public Cls getClassById(int classId) {
        return classRepository.getOne(classId);
    }

    public Cls createOrUpdateClass(Cls cls) {
        return classRepository.saveAndFlush(cls);
    }

}
