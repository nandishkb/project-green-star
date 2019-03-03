package com.outreach.greenstar.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outreach.greenstar.dao.GroupDao;
import com.outreach.greenstar.dao.PerformanceDao;
import com.outreach.greenstar.dto.GroupDTO;
import com.outreach.greenstar.dto.PerformanceParamDTO;
import com.outreach.greenstar.entities.Group;
import com.outreach.greenstar.entities.PerformanceParam;
import com.outreach.greenstar.utility.EntityDtoConverter;

@Service("performanceService")
public class PerformanceService {

    @Autowired
    private PerformanceDao performanceDao;
    @Autowired
    private GroupDao       groupDao;

    public PerformanceParamDTO getPerformanceByGroup(int groupId, Date fromDate,
        Date toDate) {
        Group group = groupDao.getGroupById(groupId);
        List<PerformanceParam> perfList =
            performanceDao.getPerformanceByGroup(group, fromDate, toDate);
        PerformanceParamDTO pdto =
            EntityDtoConverter.getPerformanceParamDTO(perfList);
        pdto.setFromDate(fromDate);
        pdto.setToDate(toDate);
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
