package com.outreach.greenstar.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outreach.greenstar.dao.ClassDao;
import com.outreach.greenstar.dao.GroupDao;
import com.outreach.greenstar.dao.PerformanceDao;
import com.outreach.greenstar.dao.StudentDao;
import com.outreach.greenstar.dto.PerformanceDTO;
import com.outreach.greenstar.dto.PerformanceParamDTO;
import com.outreach.greenstar.entities.Cls;
import com.outreach.greenstar.entities.Group;
import com.outreach.greenstar.entities.PerformanceParam;
import com.outreach.greenstar.entities.Student;
import com.outreach.greenstar.exeption.GroupNotFoundException;
import com.outreach.greenstar.exeption.StudentNotFoundException;
import com.outreach.greenstar.utility.Constants;
import com.outreach.greenstar.utility.EntityDtoConverter;

@Service("performanceService")
public class PerformanceService {

    @Autowired
    private PerformanceDao performanceDao;
    
    @Autowired
    private GroupDao       groupDao;
    
    @Autowired
    private ClassDao classDao;
    
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
        pdto.setFromDate(Constants.DATE_FORMAT_YYYY_MM_DD.format(fromDate));
        pdto.setToDate(Constants.DATE_FORMAT_YYYY_MM_DD.format(toDate));
        return pdto;
    }

    public PerformanceParamDTO getPerformanceByStudent(int studentId, Date fromDate,
        Date toDate) {
        Student student = studentDao.getStudentById(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Invalid Student ID = "+studentId);
        }
        List<PerformanceParam> perfList =
            performanceDao.getPerformanceByStudentSortByDate(studentId, fromDate, toDate);
        PerformanceParamDTO pdto =
            EntityDtoConverter.getPerformanceParamDTO(perfList);
        pdto.setFromDate(Constants.DATE_FORMAT_YYYY_MM_DD.format(fromDate));
        pdto.setToDate(Constants.DATE_FORMAT_YYYY_MM_DD.format(toDate));
        return pdto;
    }
    
    public PerformanceParamDTO getPerformanceByClass(int classId, Date fromDate,
        Date toDate) {
        return null;
    }

    public PerformanceParamDTO getPerformanceBySection(int sectionId,
        Date fromDate, Date toDate) {
        return null;
    }

    public PerformanceParamDTO updatePerformanceParam(List<PerformanceDTO> param) {
        for (Iterator<PerformanceDTO> iterator = param.iterator(); iterator.hasNext();) {
            PerformanceDTO pDto = (PerformanceDTO) iterator.next();
            Date date = new Date(); 
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(pDto.getDate());
            } catch (ParseException e) {
            }
            PerformanceParam pParam = performanceDao.getPerformanceByStudentAndByDate(pDto.getStudentId(), date);
            if (pParam != null) {
                
            }
            System.out.println("PerformanceService.updatePerformanceParam() "+pParam);
        }
        return null;
    }


}
