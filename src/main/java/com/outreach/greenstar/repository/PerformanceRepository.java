package com.outreach.greenstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.outreach.greenstar.entities.PerformanceParam;

public interface PerformanceRepository extends JpaRepository<PerformanceParam, Number>{

}
