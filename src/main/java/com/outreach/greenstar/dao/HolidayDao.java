package com.outreach.greenstar.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.outreach.greenstar.entities.Holiday;
import com.outreach.greenstar.repository.HolidayRepository;

@Repository("holidayDao")
public class HolidayDao {

    @Autowired
    private HolidayRepository holidayRepository;
    
    public boolean isHoliday(Date date) {
        return !holidayRepository.findByDate(date).isEmpty();
    }

    public List<Holiday> getAllHolidays() {
        return holidayRepository.findAll();
    }

    public List<Holiday> createHolidays(List<Holiday> listOfHolidays) {
        for (Iterator iterator = listOfHolidays.iterator(); iterator
            .hasNext();) {
            Holiday holiday = (Holiday) iterator.next();
            List<Holiday> storedHolidayList = holidayRepository.findByDate(holiday.getDate());
            if (storedHolidayList.size() > 0) {
                holiday.setId(storedHolidayList.get(0).getId());
            }
        }
        List<Holiday> all = holidayRepository.saveAll(listOfHolidays);
        holidayRepository.flush();
        return all;
    }

    public Holiday createHoliday(Holiday holiday) {
        return holidayRepository.saveAndFlush(holiday);
    }

}
