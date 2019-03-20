package com.outreach.greenstar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.outreach.greenstar.entities.Cls;
import com.outreach.greenstar.entities.Group;
import com.outreach.greenstar.entities.Section;

public interface GroupRepository extends JpaRepository<Group, Number> {

    List<Group> findBySection(Section section);

    List<Group> findByCls(Cls cls);

    /*List<Group> findBySchool(School school);*/
}
