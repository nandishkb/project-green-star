package com.outreach.greenstar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outreach.greenstar.dao.HolidayDao;
import com.outreach.greenstar.dto.HolidayDTO;
import com.outreach.greenstar.entities.Holiday;
import com.outreach.greenstar.utility.EntityDtoConverter;

@Service("holidayService")
public class HolidayService {

    @Autowired
    private HolidayDao holidayDao;

    public List<HolidayDTO> getAllHolidays() {
        List<Holiday> listOfHolidays = holidayDao.getAllHolidays();
        List<HolidayDTO> listOfDtos = new ArrayList<>();
        for (int i = 0; i < listOfHolidays.size(); ++i) {
            listOfDtos.add(EntityDtoConverter.getHolidayDTO(listOfHolidays.get(i)));
        }
        return listOfDtos;
    }

    public List<Holiday> createHolidays(List<HolidayDTO> listOfHolidayDTOs) {
        List<Holiday> listOfHolidays = new ArrayList<>();
        for(int i = 0 ; i < listOfHolidayDTOs.size() ;++i) {
            listOfHolidays.add(EntityDtoConverter.getHoliday(listOfHolidayDTOs.get(i)));
        }
        List<Holiday> successHolidays = holidayDao.createHolidays(listOfHolidays);
        return successHolidays;
    }

    public HolidayDTO createHolidays(HolidayDTO holidayDto) {
        Holiday holiday = EntityDtoConverter.getHoliday(holidayDto);
        holiday = holidayDao.createHoliday(holiday);
        return EntityDtoConverter.getHolidayDTO(holiday);
    }

}
