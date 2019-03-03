package com.outreach.greenstar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.outreach.greenstar.entities.School;
import com.outreach.greenstar.repository.SchoolRepository;

@Repository("schoolDao")
public class SchoolDao {

    @Autowired
    private SchoolRepository schoolRepository;
    
    public School getSchoolById(int schoolId) {
        return schoolRepository.getOne(schoolId);
    }

}
