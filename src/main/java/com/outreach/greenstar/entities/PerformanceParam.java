package com.outreach.greenstar.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="performance_param_table",uniqueConstraints=@UniqueConstraint(columnNames={"student_id", "date"}))
public class PerformanceParam {

    @Id
    @Column
    @GeneratedValue(
        strategy= GenerationType.AUTO,
        generator="native"
    )
    @GenericGenerator(
        name = "native",
        strategy = "native"
    )
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
    
    @ManyToOne(optional=true, cascade=CascadeType.ALL)
    private Group group;
}
