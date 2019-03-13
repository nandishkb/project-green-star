package com.outreach.greenstar.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outreach.greenstar.dao.HolidayDao;
import com.outreach.greenstar.dao.PerformanceDao;
import com.outreach.greenstar.dao.StudentDao;
import com.outreach.greenstar.dto.StarDetailsDTO;
import com.outreach.greenstar.entities.PerformanceParam;
import com.outreach.greenstar.entities.Student;
import com.outreach.greenstar.utility.ColorEnum;

@Service("starService")
public class StarService {

    @Autowired
    private StudentDao     studentDao;

    @Autowired
    private PerformanceDao performanceDao;

    @Autowired
    private HolidayDao     holidayDao;

    public StarDetailsDTO getStarDetailsByStudent(int studentId,
        Date monthYear) {
        Student student = studentDao.getStudentById(studentId);
        if (student == null) {
            throw new IllegalArgumentException(
                "Invalid Student ID = " + studentId);
        }
        Date fromDate = getStartDateOfMonth(monthYear);
        Date toDate = getEndDateOfMonth(monthYear);
        List<PerformanceParam> perfList =
            performanceDao.getPerformanceByStudent(studentId, fromDate, toDate);
        StarDetailsDTO starDetailsDTO =
            calculateStarDetailsForStudent(perfList, monthYear);
        return starDetailsDTO;
    }

    private StarDetailsDTO calculateStarDetailsForStudent(
        List<PerformanceParam> perfList, Date monthYear) {
        StarDetailsDTO starDetailsDTO = new StarDetailsDTO();
        starDetailsDTO.setMonth(monthYear);
        int daysInMonth = getNumberOfDaysInMonth(monthYear);
        starDetailsDTO.setNumberOfDays(daysInMonth);
        starDetailsDTO.setAttendanceDetails(
            getAttendanceDetailsForStudent(perfList, daysInMonth));
        starDetailsDTO.setDesciplineDetails(
            getDisciplineDetailsForStudent(perfList, daysInMonth));
        starDetailsDTO.setHomeWorkDetails(
            getHomeWorkDetailsForStudent(perfList, daysInMonth));
        return starDetailsDTO;
    }

    private List<String> getHomeWorkDetailsForStudent(
        List<PerformanceParam> perfList, int daysInMonth) {
        List<String> details = new ArrayList<>();
        int skip = 0;
        for (int i = 1; i <= daysInMonth; ++i) {
            if (perfList.size() > (i - 1 - skip)) {
                PerformanceParam param = perfList.get(i - 1 - skip);
                Date date = param.getDate();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                if (day == i) {// day matched
                    // Date date = param.getDate();
                    // need to check below code is required or not
                    /*
                     * boolean isHoliday = holidayDao.isHoliday(date); if
                     * (isHoliday) { hwDetails.add(ColorEnum.BLUE.toString());
                     * continue; }
                     */
                    // end
                    if (param.isHWDone()) {
                        details.add(ColorEnum.GREEN.toString());
                    } else {
                        details.add(ColorEnum.RED.toString());
                    }
                } else {
                    skip++;
                    cal.set(Calendar.DAY_OF_MONTH, i);
                    Date time = cal.getTime();
                    boolean isHoliday = holidayDao.isHoliday(time);
                    if (isHoliday) {
                        details.add(ColorEnum.BLUE.toString());
                    } else {
                        details.add(ColorEnum.WHITE.toString());
                    }
                }
            } else {
                details.add(ColorEnum.WHITE.toString());
            }
        }
        return details;
    }

    private List<String> getDisciplineDetailsForStudent(
        List<PerformanceParam> perfList, int daysInMonth) {
        List<String> details = new ArrayList<>();
        int skip = 0;
        for (int i = 1; i <= daysInMonth; ++i) {
            if (perfList.size() > (i - 1 - skip)) {
                PerformanceParam param = perfList.get(i - 1 - skip);
                Date date = param.getDate();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                if (day == i) {// day matched
                    // Date date = param.getDate();
                    // need to check below code is required or not
                    /*
                     * boolean isHoliday = holidayDao.isHoliday(date); if
                     * (isHoliday) { hwDetails.add(ColorEnum.BLUE.toString());
                     * continue; }
                     */
                    // end
                    if (param.isDisciplined()) {
                        details.add(ColorEnum.GREEN.toString());
                    } else {
                        details.add(ColorEnum.RED.toString());
                    }
                } else {
                    skip++;
                    cal.set(Calendar.DAY_OF_MONTH, i);
                    Date time = cal.getTime();
                    boolean isHoliday = holidayDao.isHoliday(time);
                    if (isHoliday) {
                        details.add(ColorEnum.BLUE.toString());
                    } else {
                        details.add(ColorEnum.WHITE.toString());
                    }
                }
            } else {
                details.add(ColorEnum.WHITE.toString());
            }
        }
        return details;
    }

    private List<String> getAttendanceDetailsForStudent(
        List<PerformanceParam> perfList, int daysInMonth) {
        List<String> details = new ArrayList<>();
        int skip = 0;
        for (int i = 1; i <= daysInMonth; ++i) {
            if (perfList.size() > (i - 1 - skip)) {
                PerformanceParam param = perfList.get(i - 1 - skip);
                Date date = param.getDate();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                if (day == i) {// day matched
                    
                    // Date date = param.getDate();
                    // need to check below code is required or not
                    /*
                     * boolean isHoliday = holidayDao.isHoliday(date); if
                     * (isHoliday) { hwDetails.add(ColorEnum.BLUE.toString());
                     * continue; }
                     */
                    // end
                    if (param.isPresent()) {
                        details.add(ColorEnum.GREEN.toString());
                    } else {
                        details.add(ColorEnum.RED.toString());
                    }
                } else {
                    skip++;
                    cal.set(Calendar.DAY_OF_MONTH, i);
                    Date time = cal.getTime();
                    boolean isHoliday = holidayDao.isHoliday(time);
                    if (isHoliday) {
                        details.add(ColorEnum.BLUE.toString());
                    } else {
                        details.add(ColorEnum.WHITE.toString());
                    }
                }
            } else {
                details.add(ColorEnum.WHITE.toString());
            }
        }
        return details;
    }

    private int getNumberOfDaysInMonth(Date monthYear) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(monthYear);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    private Date getEndDateOfMonth(Date monthYear) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(monthYear);
        cal.set(Calendar.DAY_OF_MONTH,
            cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out
            .println("StartEndDate.main() === endDate = " + cal.getTime());
        return cal.getTime();
    }

    private Date getStartDateOfMonth(Date monthYear) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(monthYear);
        cal.set(Calendar.DAY_OF_MONTH,
            cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        System.out
            .println("StartEndDate.main() === startDate = " + cal.getTime());
        return cal.getTime();
    }

}
