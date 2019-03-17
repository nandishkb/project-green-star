package com.outreach.greenstar.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.outreach.greenstar.entities.School;
import com.outreach.greenstar.exeption.SchoolNotFoundException;
import com.outreach.greenstar.repository.SchoolRepository;

@Repository("schoolDao")
public class SchoolDao {

    @Autowired
    private SchoolRepository schoolRepository;
    
    public School getSchoolById(int schoolId) {
        Optional<School> optionalSch = schoolRepository.findById(schoolId);
        if (optionalSch.isPresent()) {
            return optionalSch.get();
        }
        throw new SchoolNotFoundException("Invalid school Id = "+schoolId);
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public School createOrUpdateSchool(School school) {
        return schoolRepository.saveAndFlush(school);
    }

}
