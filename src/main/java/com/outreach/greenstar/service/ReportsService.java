package com.outreach.greenstar.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outreach.greenstar.dao.GroupDao;
import com.outreach.greenstar.dao.PerformanceDao;
import com.outreach.greenstar.dto.ClassGroupWiseReportDTO;
import com.outreach.greenstar.dto.ClassSectionWiseReportDTO;
import com.outreach.greenstar.dto.GroupReportDTO;
import com.outreach.greenstar.dto.PerformanceData;
import com.outreach.greenstar.dto.Summary;
import com.outreach.greenstar.entities.Group;
import com.outreach.greenstar.entities.PerformanceParam;
import com.outreach.greenstar.entities.Section;
import com.outreach.greenstar.entities.Student;
import com.outreach.greenstar.utility.Constants;

@Service("reportsService")
public class ReportsService {

    @Autowired
    private GroupDao       groupDao;

    @Autowired
    private PerformanceDao performanceDao;

    public List<GroupReportDTO> getReportByGroup(int groupId, Date from,
        Date to) {
        List<PerformanceParam> performanceByGroup =
            performanceDao.getPerformanceByGroup(groupId, from, to);
        int currentStudentId = -1;
        Stack<GroupReportDTO> stack = new Stack<>();
        for (Iterator<PerformanceParam> iterator =
            performanceByGroup.iterator(); iterator.hasNext();) {
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
                currentStudentId = student.getId();
            } else {
                reportDto = stack.peek();
            }
            PerformanceData pData = new PerformanceData();
            pData.setDate(
                Constants.DATE_FORMAT_YYYY_MM_DD.format(pParam.getDate()));
            pData.setAttendance(pParam.isPresent() ? 1 : 0);
            pData.setDiscipline(pParam.isDisciplined() ? 1 : 0);
            pData.setHomeWork(pParam.isHWDone() ? 1 : 0);
            Summary summary = reportDto.getSummary();
            summary
                .setAttendance(summary.getAttendance() + pData.getAttendance());
            summary
                .setDiscipline(summary.getDiscipline() + pData.getDiscipline());
            summary.setHomeWork(summary.getHomeWork() + pData.getHomeWork());
            reportDto.getPerformanceData().add(pData);
        }
        return stack;
    }

    public List<ClassSectionWiseReportDTO> getReportByClassBySection(int classId, Date from,
        Date to) {
        List<PerformanceParam> listPerf =
            performanceDao.getPerformanceByClassSortBySectionName(classId, from, to);
        String currentSection = "";
        Stack<ClassSectionWiseReportDTO> stack = new Stack<>();
        for (Iterator<PerformanceParam> iterator = listPerf.iterator(); iterator
            .hasNext();) {
            PerformanceParam pParam = iterator.next();
            Section section = pParam.getSection();
            ClassSectionWiseReportDTO classReport = null;
            if (!currentSection.equals(section.getName())) {
                classReport = new ClassSectionWiseReportDTO();
                classReport.setSectionName(
                    pParam.getCls().getGrade() + " " + section.getName());
                
                stack.push(classReport);
                currentSection = section.getName();
            } else {
                classReport = stack.peek();
            }
            classReport.setAttendance(
                classReport.getAttendance() + (pParam.isPresent() ? 1 : 0));
            classReport.setDiscipline(
                classReport.getDiscipline() + (pParam.isDisciplined() ? 1 : 0));
            classReport.setHomework(
                classReport.getHomework() + (pParam.isHWDone() ? 1 : 0));
            
            /**
             * perform avg of previous data;
             */
            classReport.setTotal((int)Math.round((double)((classReport.getAttendance()
                + classReport.getDiscipline() + classReport.getHomework())) / 3));
        }
        return stack;
    }
    
    public List<ClassGroupWiseReportDTO> getReportByClassByGroup(int classId, Date from,
        Date to) {
        List<PerformanceParam> listPerf =
            performanceDao.getPerformanceByClassSortByGruopName(classId, from, to);
        String currentGroupName = "";
        Stack<ClassGroupWiseReportDTO> stack = new Stack<>();
        for (Iterator<PerformanceParam> iterator = listPerf.iterator(); iterator.hasNext();) {
            PerformanceParam pParam = iterator.next();
            Group group = pParam.getGroup();
            ClassGroupWiseReportDTO groupReport = null;
            if (!currentGroupName.equals(group.getName())) {
                groupReport = new ClassGroupWiseReportDTO();
                groupReport.setGroupName(group.getName());
                stack.push(groupReport);
                currentGroupName = group.getName();
            } else {
                groupReport = stack.peek();
            }
            groupReport.setAttendance(
                groupReport.getAttendance() + (pParam.isPresent() ? 1 : 0));
            groupReport.setDiscipline(
                groupReport.getDiscipline() + (pParam.isDisciplined() ? 1 : 0));
            groupReport.setHomework(
                groupReport.getHomework() + (pParam.isHWDone() ? 1 : 0));
            
            /**
             * perform avg of previous data;
             */
            groupReport.setTotal((int)Math.round((double)((groupReport.getAttendance()
                + groupReport.getDiscipline() + groupReport.getHomework())) / 3));
            
        }
        
        return stack;
    }

}
