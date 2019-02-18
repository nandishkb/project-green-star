package com.outreach.greenstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.outreach.greenstar.entities.Group;

public interface GroupRepository extends JpaRepository<Group, Number> {

}
