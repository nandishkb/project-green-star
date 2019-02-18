package com.outreach.greenstar.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class PerformanceParam {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @Column
    private Date date;
    
    @Column(name="attendance")
    private boolean isPresent;
    
    @Column(name="home_work")
    private boolean isHWDone;
    
    @Column(name="discipline")
    private boolean isDisciplined;
    
    @Column
    @ManyToMany
    private Student student;
    
    @Column
    @ManyToMany
    private Cls cls;
    
    @Column
    @ManyToMany
    private Section section;
    
    @Column
    @ManyToMany
    private Group group;
}
