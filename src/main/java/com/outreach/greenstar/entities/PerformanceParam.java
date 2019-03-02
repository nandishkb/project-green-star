package com.outreach.greenstar.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    
    @ManyToOne(cascade=CascadeType.ALL)
    private Student student;
    
    @ManyToOne(cascade=CascadeType.ALL)
    private Cls cls;
    
    @ManyToOne(cascade=CascadeType.ALL)
    private Section section;
    
    @ManyToOne(cascade=CascadeType.ALL)
    private Group group;
}
