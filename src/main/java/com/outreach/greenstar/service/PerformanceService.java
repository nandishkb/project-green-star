package com.outreach.greenstar.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outreach.greenstar.dao.PerformanceDao;
import com.outreach.greenstar.dto.PerformanceParamDTO;

@Service("performanceService")
public class PerformanceService {

    @Autowired
    private PerformanceDao performanceDao;

    public PerformanceParamDTO getPerformanceByGroup(int groupId, Date fromDate,
        Date toDate) {
        PerformanceParamDTO perfDTO =
            performanceDao.getPerformanceByGroup(groupId, fromDate, toDate);
        return null;
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
