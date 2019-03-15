package com.outreach.greenstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.outreach.greenstar.entities.Holiday;
import java.util.Date;
import java.util.List;

public interface HolidayRepository extends JpaRepository<Holiday, Number>{

    List<Holiday> findByDate(Date date);
}
