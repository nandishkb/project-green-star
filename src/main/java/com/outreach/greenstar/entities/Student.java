package com.outreach.greenstar.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "student_table")
public class Student {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @Column(nullable=false, unique=true)
    private int rollNumber;
    
    @Column(nullable=false)
    private String name;
    
    @OneToOne(cascade=CascadeType.ALL)
    private Address address;
    
    @Column
    private String caste;
    
    @Column
    private String religion;
    
    @Column
    private Date joiningDate;
    
    @ManyToOne(cascade=CascadeType.ALL)
    private School school;
    
    @ManyToOne(cascade=CascadeType.ALL)
    private Cls cls;
    
    @ManyToOne(cascade=CascadeType.ALL)
    private Section section;
    
    @ManyToOne(cascade=CascadeType.ALL)
    private Group group;
    
}
