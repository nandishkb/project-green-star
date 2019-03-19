package com.outreach.greenstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.outreach.greenstar.entities.Privilages;
import java.lang.String;
import java.util.List;

public interface PrivilagesRepository
    extends JpaRepository<Privilages, Number> {
    List<Privilages> findByTitle(String title);
}
