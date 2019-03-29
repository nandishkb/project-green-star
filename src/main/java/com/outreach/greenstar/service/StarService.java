package com.outreach.greenstar.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outreach.greenstar.dao.GroupDao;
import com.outreach.greenstar.dao.HolidayDao;
import com.outreach.greenstar.dao.PerformanceDao;
import com.outreach.greenstar.dao.StudentDao;
import com.outreach.greenstar.dto.StarDetailsDTO;
import com.outreach.greenstar.entities.Group;
import com.outreach.greenstar.entities.PerformanceParam;
import com.outreach.greenstar.entities.Student;
import com.outreach.greenstar.exeption.StudentNotFoundException;
import com.outreach.greenstar.utility.ColorEnum;

@Service("starService")
public class StarService {

    @Autowired
    private StudentDao     studentDao;

    @Autowired
    private PerformanceDao performanceDao;

    @Autowired
    private HolidayDao     holidayDao;
    
    @Autowired
    private GroupDao     groupDao;
    
    public StarDetailsDTO getStarDetailsByStudent(int studentId,
        Date monthYear) {
        Student student = studentDao.getStudentById(studentId);
        if (student == null) {
            throw new StudentNotFoundException(
                "Invalid Student ID = " + studentId);
        }
        Date fromDate = getStartDateOfMonth(monthYear);
        Date toDate = getEndDateOfMonth(monthYear);
        List<PerformanceParam> perfList =
            performanceDao.getPerformanceByStudentSortByDate(studentId, fromDate, toDate);
        StarDetailsDTO starDetailsDTO =
            calculateStarDetailsForStudent(perfList, monthYear);
        return starDetailsDTO;
    }

    private StarDetailsDTO calculateStarDetailsForStudent(
        List<PerformanceParam> perfList, Date monthYear) {
        StarDetailsDTO starDetailsDTO = new StarDetailsDTO();
        starDetailsDTO.setMonth(monthYear.toString());
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

    public StarDetailsDTO getStarDetailsByGroup(int groupId, Date monthYear) {
        List<Student> studentsByGroup = studentDao.getStudentsByGroup(groupId);
        int noOfStudents = studentsByGroup.size();
        int daysInMonth = getNumberOfDaysInMonth(monthYear);
        List<Integer> attStarData = new ArrayList<>();
        for (int i = 0; i < daysInMonth; ++i) {
            attStarData.add(ColorEnum.WHITE.getId());
        }
        
        List<Integer> desStarData = new ArrayList<>();
        for (int i = 0; i < daysInMonth; ++i) {
            desStarData.add(ColorEnum.WHITE.getId());
        }
        
        List<Integer> hwStarData = new ArrayList<>();
        for (int i = 0; i < daysInMonth; ++i) {
            hwStarData.add(ColorEnum.WHITE.getId());
        }
        for (Iterator<Student> iterator = studentsByGroup.iterator(); iterator
            .hasNext();) {
            Student student = (Student) iterator.next();
            Date fromDate = getStartDateOfMonth(monthYear);
            Date toDate = getEndDateOfMonth(monthYear);
            
            List<PerformanceParam> perfList =
                performanceDao.getPerformanceByStudentSortByDate(student.getId(), fromDate, toDate);
            attStarData = getAttendanceDataForStudent(perfList, daysInMonth, attStarData);
            desStarData = getDesciplineDataForStudent(perfList, daysInMonth, desStarData);
            hwStarData = getHomeWorkDataForStudent(perfList, daysInMonth, hwStarData);
            
        }
        
        StarDetailsDTO dto = new StarDetailsDTO();
        dto.setMonth(monthYear.toString());
        dto.setNumberOfDays(daysInMonth);
        List<String> att = new ArrayList<>();
        List<String> des = new ArrayList<>();
        List<String> hw = new ArrayList<>();
        for (int i=0;i<daysInMonth;i++) {
            int attData = attStarData.get(i);
            int desData = desStarData.get(i);
            int hwData = hwStarData.get(i);
            
            if (attData == ColorEnum.WHITE.getId()) {
                att.add(ColorEnum.WHITE.name());
            } else if (attData == ColorEnum.BLUE.getId()) {
                att.add(ColorEnum.BLUE.name());
            } else {
                float perc = ((float)attData/(float)noOfStudents)*100;
                if (perc >= 75.0) {
                    att.add(ColorEnum.GREEN.name());
                } else if (perc >=50.0) {
                    att.add(ColorEnum.YELLOW.name());
                } else {
                    att.add(ColorEnum.RED.name());
                }
            }
            
            // descipline
            if (desData == ColorEnum.WHITE.getId()) {
                des.add(ColorEnum.WHITE.name());
            } else if (desData == ColorEnum.BLUE.getId()) {
                des.add(ColorEnum.BLUE.name());
            } else {
                float perc = ((float)desData/(float)noOfStudents)*100;
                if (perc >= 75.0) {
                    des.add(ColorEnum.GREEN.name());
                } else if (perc >=50.0) {
                    des.add(ColorEnum.YELLOW.name());
                } else {
                    des.add(ColorEnum.RED.name());
                }
            }
            
            //homework
            if (hwData == ColorEnum.WHITE.getId()) {
                hw.add(ColorEnum.WHITE.name());
            } else if (hwData == ColorEnum.BLUE.getId()) {
                hw.add(ColorEnum.BLUE.name());
            } else {
                float perc = ((float)hwData/(float)noOfStudents)*100;
                if (perc >= 75.0) {
                    hw.add(ColorEnum.GREEN.name());
                } else if (perc >=50.0) {
                    hw.add(ColorEnum.YELLOW.name());
                } else {
                    hw.add(ColorEnum.RED.name());
                }
            }
        }
        dto.setAttendanceDetails(att);
        dto.setDesciplineDetails(des);
        dto.setHomeWorkDetails(hw);
        
        return dto;
    }
    

    
    private List<Integer> getHomeWorkDataForStudent(
        List<PerformanceParam> perfList, int daysInMonth,
        List<Integer> data) {
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
                        insertColorDependentData(data, (i-1), ColorEnum.GREEN.getId());
//                        data.add(i, ColorEnum.GREEN.toString());
                    } else {
                        insertColorDependentData(data, (i-1), ColorEnum.RED.getId());
//                        details.add(ColorEnum.RED.toString());
                    }
                } else {
                    skip++;
                    cal.set(Calendar.DAY_OF_MONTH, i);
                    Date time = cal.getTime();
                    boolean isHoliday = holidayDao.isHoliday(time);
                    if (isHoliday) {
//                        details.add(ColorEnum.BLUE.toString());
                        insertColorDependentData(data, (i-1), ColorEnum.BLUE.getId());
                    } else {
                        insertColorDependentData(data, (i-1), ColorEnum.WHITE.getId());
//                        details.add(ColorEnum.WHITE.toString());
                    }
                }
            } else {
//                details.add(ColorEnum.WHITE.toString());
                insertColorDependentData(data, (i-1), ColorEnum.WHITE.getId());
            }
        }
        return data;
    }

    private List<Integer> getDesciplineDataForStudent(
        List<PerformanceParam> perfList, int daysInMonth,
        List<Integer> data) {
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
                        insertColorDependentData(data, (i-1), ColorEnum.GREEN.getId());
//                        data.add(i, ColorEnum.GREEN.toString());
                    } else {
                        insertColorDependentData(data, (i-1), ColorEnum.RED.getId());
//                        details.add(ColorEnum.RED.toString());
                    }
                } else {
                    skip++;
                    cal.set(Calendar.DAY_OF_MONTH, i);
                    Date time = cal.getTime();
                    boolean isHoliday = holidayDao.isHoliday(time);
                    if (isHoliday) {
//                        details.add(ColorEnum.BLUE.toString());
                        insertColorDependentData(data, (i-1), ColorEnum.BLUE.getId());
                    } else {
                        insertColorDependentData(data, (i-1), ColorEnum.WHITE.getId());
//                        details.add(ColorEnum.WHITE.toString());
                    }
                }
            } else {
//                details.add(ColorEnum.WHITE.toString());
                insertColorDependentData(data, (i-1), ColorEnum.WHITE.getId());
            }
        }
        return data;
    }

    private List<Integer> getAttendanceDataForStudent(
        List<PerformanceParam> perfList, int daysInMonth, List<Integer> data) {
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
                        insertColorDependentData(data, (i-1), ColorEnum.GREEN.getId());
//                        data.add(i, ColorEnum.GREEN.toString());
                    } else {
                        insertColorDependentData(data, (i-1), ColorEnum.RED.getId());
//                        details.add(ColorEnum.RED.toString());
                    }
                } else {
                    skip++;
                    cal.set(Calendar.DAY_OF_MONTH, i);
                    Date time = cal.getTime();
                    boolean isHoliday = holidayDao.isHoliday(time);
                    if (isHoliday) {
//                        details.add(ColorEnum.BLUE.toString());
                        insertColorDependentData(data, (i-1), ColorEnum.BLUE.getId());
                    } else {
                        insertColorDependentData(data, (i-1), ColorEnum.WHITE.getId());
//                        details.add(ColorEnum.WHITE.toString());
                    }
                }
            } else {
//                details.add(ColorEnum.WHITE.toString());
                insertColorDependentData(data, (i-1), ColorEnum.WHITE.getId());
            }
        }
        return data;
    }
    
    private void insertColorDependentData(List<Integer> data, int index, int val) {
        Integer storedVal = data.get(index);
        
        if (val == ColorEnum.WHITE.getId() && storedVal == ColorEnum.WHITE.getId()) {
            return;
        }
        
        if (val == ColorEnum.WHITE.getId() && storedVal != ColorEnum.WHITE.getId()) {
            return;
        }
        
        if (val == ColorEnum.BLUE.getId()) {
            data.add(index, ColorEnum.BLUE.getId());
            return;
        }
        
        if (storedVal != ColorEnum.WHITE.getId()) {
            data.add(index, storedVal + val);
            return;
        }
        
        
            data.add(index, val);
        
        

    }

}
