package com.outreach.greenstar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outreach.greenstar.dao.ClassDao;
import com.outreach.greenstar.dao.SectionDao;
import com.outreach.greenstar.dto.SectionDTO;
import com.outreach.greenstar.entities.Cls;
import com.outreach.greenstar.entities.Section;
import com.outreach.greenstar.exeption.ClsNotFoundException;
import com.outreach.greenstar.exeption.SectionNotFoundException;
import com.outreach.greenstar.utility.EntityDtoConverter;

@Service("sectionService")
public class SectionService {

    @Autowired
    private SectionDao sectionDao;
    
    @Autowired
    private ClassDao classDao;

    public List<SectionDTO> getSectionByClass(int classId) {
        List<Section> listSections = sectionDao.getSectionsByClass(classId);
        List<SectionDTO> listOfSectionDTOs = new ArrayList<>();
        for (int i = 0; i < listSections.size(); ++i) {
            listOfSectionDTOs
                .add(EntityDtoConverter.getSectionDTO(listSections.get(i)));
        }
        return listOfSectionDTOs;
    }

    public SectionDTO getSection(int sectionId) {
        Section section = sectionDao.getSectionById(sectionId);
        if (section == null) {
            throw new SectionNotFoundException("Invalid Section Id = "+sectionId);
        }
        return EntityDtoConverter.getSectionDTO(section);
    }

    public SectionDTO createSection(SectionDTO sectionDTO) {
        Section section = EntityDtoConverter.getSection(sectionDTO);
        Cls cls = classDao.getClassById(sectionDTO.getClassId());
        if (cls == null) {
            throw new ClsNotFoundException("Invalid Class ID = "+sectionDTO.getClassId());
        }
        section.setCls(cls);
        section = sectionDao.saveOrUpdate(section);
        return EntityDtoConverter.getSectionDTO(section);
    }

    public SectionDTO updateSection(SectionDTO section) {
        sectionDao.getSectionById(section.getId());
        return createSection(section);
    }

    public void deleteSection(int sectionId) {
        Section section = sectionDao.getSectionById(sectionId);
        sectionDao.deleteSection(section);
    }

}
