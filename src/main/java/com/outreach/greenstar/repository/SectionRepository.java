package com.outreach.greenstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.outreach.greenstar.entities.Section;
import com.outreach.greenstar.entities.Cls;
import java.util.List;

public interface SectionRepository extends JpaRepository<Section, Number> {

    List<Section> findByCls(Cls cls);
}
