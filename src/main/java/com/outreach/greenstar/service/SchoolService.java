package com.outreach.greenstar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outreach.greenstar.dao.SchoolDao;
import com.outreach.greenstar.dto.SchoolDTO;
import com.outreach.greenstar.entities.School;
import com.outreach.greenstar.exeption.SchoolNotFoundException;
import com.outreach.greenstar.utility.EntityDtoConverter;

@Service("schoolService")
public class SchoolService {

    @Autowired
    private SchoolDao schoolDao;
    
    
    
    public List<SchoolDTO> getAllSchools() {
        List<School> listSchool = schoolDao.getAllSchools();
        ArrayList<SchoolDTO> list = new ArrayList<>();
        for (int i = 0; i < listSchool.size(); ++i) {
            School school = listSchool.get(i);
            list.add(EntityDtoConverter.getSchoolDTO(school));
        }
        return list;
    }

    public SchoolDTO getSchool(int schoolId) {
        School school = schoolDao.getSchoolById(schoolId);
        if (school == null) {
            throw new SchoolNotFoundException("Invalid School Id = "+schoolId);
        }
        return EntityDtoConverter.getSchoolDTO(school);
    }

    public SchoolDTO createSchool(SchoolDTO schoolDto) {
        School school = EntityDtoConverter.getSchool(schoolDto);
        school = schoolDao.createOrUpdateSchool(school);
        return EntityDtoConverter.getSchoolDTO(school);
    }

    public SchoolDTO updateSchool(SchoolDTO schoolDto) {
        return createSchool(schoolDto);
    }

}
