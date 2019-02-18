package com.outreach.greenstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.outreach.greenstar.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Number> {

}
