package com.outreach.greenstar.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outreach.greenstar.dao.GroupDao;
import com.outreach.greenstar.dao.PerformanceDao;
import com.outreach.greenstar.dao.StudentDao;
import com.outreach.greenstar.dto.PerformanceParamDTO;
import com.outreach.greenstar.entities.Group;
import com.outreach.greenstar.entities.PerformanceParam;
import com.outreach.greenstar.entities.Student;
import com.outreach.greenstar.exeption.GroupNotFoundException;
import com.outreach.greenstar.exeption.StudentNotFoundException;
import com.outreach.greenstar.utility.EntityDtoConverter;

@Service("performanceService")
public class PerformanceService {

    @Autowired
    private PerformanceDao performanceDao;
    @Autowired
    private GroupDao       groupDao;
    
    @Autowired
    private StudentDao studentDao;

    public PerformanceParamDTO getPerformanceByGroup(int groupId, Date fromDate,
        Date toDate) {
        Group group = groupDao.getGroupById(groupId);
        if (group == null) {
            throw new GroupNotFoundException("Invalid group id = "+groupId);
        }
        List<PerformanceParam> perfList =
            performanceDao.getPerformanceByGroup(groupId, fromDate, toDate);
        PerformanceParamDTO pdto =
            EntityDtoConverter.getPerformanceParamDTO(perfList);
        pdto.setFromDate(fromDate.toString());
        pdto.setToDate(toDate.toString());
        return pdto;
    }

    public PerformanceParamDTO getPerformanceByStudent(int studentId, Date fromDate,
        Date toDate) {
        Student student = studentDao.getStudentById(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Invalid Student ID = "+studentId);
        }
        List<PerformanceParam> perfList =
            performanceDao.getPerformanceByStudent(studentId, fromDate, toDate);
        PerformanceParamDTO pdto =
            EntityDtoConverter.getPerformanceParamDTO(perfList);
        pdto.setFromDate(fromDate.toString());
        pdto.setToDate(toDate.toString());
        return pdto;
    }
    
    public PerformanceParamDTO getPerformanceByClass(int classId, Date fromDate,
        Date toDate) {
        // TODO Auto-generated method stub
        return null;
    }

    public PerformanceParamDTO getPerformanceBySection(int sectionId,
        Date fromDate, Date toDate) {
        // TODO Auto-generated method stub
        return null;
    }

    public void updatePerformanceParam(PerformanceParamDTO param) {
        // TODO Auto-generated method stub

    }


}
