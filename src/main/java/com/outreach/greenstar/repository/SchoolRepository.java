package com.outreach.greenstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.outreach.greenstar.entities.School;
import java.lang.String;
import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Number>{

    List<School> findByCity(String city);
    
    @Query("select s.city from School s")
    List<String> getAllCities();
}
