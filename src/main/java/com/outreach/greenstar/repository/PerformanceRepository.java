package com.outreach.greenstar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.outreach.greenstar.entities.PerformanceParam;
import com.outreach.greenstar.entities.Group;

public interface PerformanceRepository extends JpaRepository<PerformanceParam, Number>{

    List<PerformanceParam> findByGroup(Group group);
}
