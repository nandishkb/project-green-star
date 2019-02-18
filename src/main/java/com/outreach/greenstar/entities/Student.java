package com.outreach.greenstar.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Student {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @Column(nullable=false, unique=true)
    private int rollNumber;
    
    @Column(nullable=false)
    private String name;
    
    @Column
    private String address;
    
    @Column
    private String caste;
    
    @Column
    private String religion;
    
    @Column
    private Date joiningDate;
    
    @Column
    @ManyToOne
    private School school;
    
    @Column
    @ManyToOne
    private Cls cls;
    
    @Column
    @ManyToOne
    private Section section;
    
    @Column
    @ManyToOne
    private Group group;
    
}
