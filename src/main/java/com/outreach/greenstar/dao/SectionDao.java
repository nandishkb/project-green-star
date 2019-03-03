package com.outreach.greenstar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.outreach.greenstar.entities.Section;
import com.outreach.greenstar.repository.SectionRepository;

@Repository("sectionDao")
public class SectionDao {

    @Autowired
    private SectionRepository sectionRepository;
    
    public Section getSectionById(int sectionId) {
        return sectionRepository.getOne(sectionId);
    }

}
