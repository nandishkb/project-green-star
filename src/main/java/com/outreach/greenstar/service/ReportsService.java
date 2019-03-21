package com.outreach.greenstar.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outreach.greenstar.dao.GroupDao;
import com.outreach.greenstar.dao.PerformanceDao;
import com.outreach.greenstar.dto.GroupReportDTO;
import com.outreach.greenstar.dto.PerformanceData;
import com.outreach.greenstar.dto.Summary;
import com.outreach.greenstar.entities.Group;
import com.outreach.greenstar.entities.PerformanceParam;
import com.outreach.greenstar.entities.Student;
import com.outreach.greenstar.utility.Constants;

@Service("reportsService")
public class ReportsService {

    @Autowired
    private GroupDao groupDao;
    
    @Autowired
    private PerformanceDao performanceDao;
    
    public List<GroupReportDTO> getReportByGroup(int groupId, Date from, Date to) {
        List<PerformanceParam> performanceByGroup = performanceDao.getPerformanceByGroup(groupId, from, to);
        int currentStudentId = -1;
        Stack<GroupReportDTO> stack = new Stack<>();
        for (Iterator<PerformanceParam> iterator = performanceByGroup.iterator(); iterator
            .hasNext();) {
            PerformanceParam pParam = iterator.next();
            Student student = pParam.getStudent();
            GroupReportDTO reportDto = null;
            if (student.getId() != currentStudentId) {
                GroupReportDTO dto = new GroupReportDTO();
                dto.setCaste(student.getCaste());
                dto.setRollNum(student.getRollNumber());
                dto.setStudentName(student.getName());
                dto.setSummary(new Summary());
                reportDto = dto;
                stack.push(reportDto);
                currentStudentId=student.getId();
            } else {
                reportDto = stack.peek();
            }
            PerformanceData pData = new PerformanceData();
            pData.setDate(Constants.DATE_FORMAT_YYYY_MM_DD.format(pParam.getDate()));
            pData.setAttendance(pParam.isPresent()?1:0);
            pData.setDiscipline(pParam.isDisciplined()?1:0);
            pData.setHomeWork(pParam.isHWDone()?1:0);
            Summary summary = reportDto.getSummary();
            summary.setAttendance(summary.getAttendance()+pData.getAttendance());
            summary.setDiscipline(summary.getDiscipline()+pData.getDiscipline());
            summary.setHomeWork(summary.getHomeWork()+pData.getHomeWork());
            reportDto.getPerformanceData().add(pData);
        }
        return stack;
    }

}
