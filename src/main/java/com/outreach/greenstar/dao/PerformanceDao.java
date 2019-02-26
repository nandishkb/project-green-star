package com.outreach.greenstar.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.outreach.greenstar.dto.PerformanceParamDTO;
import com.outreach.greenstar.entities.Group;
import com.outreach.greenstar.entities.PerformanceParam;
import com.outreach.greenstar.repository.PerformanceRepository;

@Repository("performanceDao")
public class PerformanceDao {

    @Autowired
    private PerformanceRepository perfRepo;
    public PerformanceParamDTO getPerformanceByGroup(Group group, Date fromDate,
        Date toDate) {
        List<PerformanceParam> findByGroup = perfRepo.findByGroup(group);
        PerformanceParamDTO perfDTO = new PerformanceParamDTO();
        perfDTO.setFromDate(fromDate);
        perfDTO.setToDate(toDate);
        List<List<String>> performanceData = new ArrayList<>();
        for (Iterator iterator = findByGroup.iterator(); iterator
            .hasNext();) {
            PerformanceParam perfParam = (PerformanceParam) iterator.next();
            ArrayList<String> listOfData = new ArrayList<>();
            listOfData.add(perfParam.getDate().toString());
            listOfData.add(perfParam.getStudent().getRollNumber()+"");
            listOfData.add(perfParam.getStudent().getName());
            listOfData.add("true");
            listOfData.add(perfParam.isPresent()+"");
            listOfData.add(perfParam.isHWDone()+"");
            listOfData.add(perfParam.isDisciplined()+"");
            listOfData.add(perfParam.getGroup().getName());
            performanceData.add(listOfData);
        }
        return perfDTO;
    }

}
