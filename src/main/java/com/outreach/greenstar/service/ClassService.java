package com.outreach.greenstar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outreach.greenstar.dao.ClassDao;
import com.outreach.greenstar.dao.SchoolDao;
import com.outreach.greenstar.dto.ClsDTO;
import com.outreach.greenstar.entities.Cls;
import com.outreach.greenstar.entities.School;
import com.outreach.greenstar.utility.EntityDtoConverter;

@Service("classService")
public class ClassService {
    
    @Autowired
    private ClassDao classDao;
    
    @Autowired
    private SchoolDao schoolDao;

    public List<ClsDTO> getClassBySchool(int schoolId) {
        List<Cls> listCls = classDao.getClassBySchool(schoolId);
        ArrayList<ClsDTO> list = new ArrayList<>();
        for (int i = 0; i < listCls.size(); ++i) {
            Cls cls = listCls.get(i);
            list.add(EntityDtoConverter.getClsDTO(cls));
        }
        return list;
    }

    public ClsDTO getClassById(int classId) {
        Cls cls = classDao.getClassById(classId);
        return EntityDtoConverter.getClsDTO(cls);
    }

    public ClsDTO createClass(ClsDTO clsDto) {
        Cls cls = EntityDtoConverter.getCls(clsDto);
        School school = schoolDao.getSchoolById(clsDto.getSchoolId());
        cls.setSchool(school);
        Cls cls1 = classDao.createOrUpdateClass(cls);
        return EntityDtoConverter.getClsDTO(cls1);
    }

    public ClsDTO updateClass(ClsDTO clsDto) {
        classDao.getClassById(clsDto.getId());
        return createClass(clsDto);
    }

    public void deleteClass(int classId) {
        Cls cls = classDao.getClassById(classId);
        classDao.deleteClass(cls);
    }

}
