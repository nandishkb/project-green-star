package com.outreach.greenstar.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.outreach.greenstar.entities.Cls;
import com.outreach.greenstar.entities.School;
import com.outreach.greenstar.exeption.ClsNotFoundException;
import com.outreach.greenstar.repository.ClassRepository;

@Repository("classDao")
public class ClassDao {

    @Autowired
    private ClassRepository classRepository;
    
    @Autowired
    private SchoolDao schoolDao;
    
    public List<Cls> getClassBySchool(int schoolId) {
        School school = schoolDao.getSchoolById(schoolId);
        return classRepository.findBySchool(school);
    }

    public Cls getClassById(int classId) {
        Optional<Cls> optionalCls = classRepository.findById(classId);
        if (optionalCls.isPresent()) {
            return optionalCls.get();
        }
        throw new ClsNotFoundException("Invalid class id = "+classId);
    }

    @Transactional
    public Cls createOrUpdateClass(Cls cls) {
        return classRepository.saveAndFlush(cls);
    }

    public void deleteClass(Cls cls) {
        classRepository.delete(cls);
    }

}
