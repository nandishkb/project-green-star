package com.outreach.greenstar.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.outreach.greenstar.entities.Cls;
import com.outreach.greenstar.entities.Section;
import com.outreach.greenstar.exeption.ClsNotFoundException;
import com.outreach.greenstar.exeption.SectionNotFoundException;
import com.outreach.greenstar.repository.ClassRepository;
import com.outreach.greenstar.repository.SectionRepository;

@Repository("sectionDao")
public class SectionDao {

    @Autowired
    private SectionRepository sectionRepository;
    
    @Autowired
    private ClassRepository classRepository;
    
    public Section getSectionById(int sectionId) {
        Optional<Section> sectionOp = sectionRepository.findById(sectionId);
        if (sectionOp.isPresent()) {
            return sectionOp.get();
        }
        throw new SectionNotFoundException("Invalid section id = "+sectionId);
    }

    public List<Section> getSectionsByClass(int classId) {
        Optional<Cls> clsOpt = classRepository.findById(classId);
        if (clsOpt.isPresent()) {
            return sectionRepository.findByCls(clsOpt.get());
        }
        throw new ClsNotFoundException("Invalid class id = "+classId);
    }

    public Section saveOrUpdate(Section section) {
        return sectionRepository.saveAndFlush(section);
    }

}
