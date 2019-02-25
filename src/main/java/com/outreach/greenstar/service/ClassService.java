package com.outreach.greenstar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outreach.greenstar.dao.ClassDao;
import com.outreach.greenstar.dto.ClsDTO;
import com.outreach.greenstar.entities.Cls;

@Service("classService")
public class ClassService {
    
    @Autowired
    private ClassDao classDao;

    public List<ClsDTO> getClassBySchool(int schoolId) {
        Cls cls = classDao.getClassBySchool(schoolId);
        //test code start
        ArrayList<ClsDTO> list = new ArrayList<ClsDTO>();
        list.add(new ClsDTO());
        //test end
        return list;
    }

    public ClsDTO getClass(int classId) {
        // TODO Auto-generated method stub
        return null;
    }

    public ClsDTO createClass(ClsDTO cls) {
        // TODO Auto-generated method stub
        return null;
    }

    public ClsDTO updateClass(ClsDTO cls) {
        // TODO Auto-generated method stub
        return null;
    }

}
