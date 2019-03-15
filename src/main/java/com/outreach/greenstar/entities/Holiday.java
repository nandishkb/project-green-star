package com.outreach.greenstar.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Holiday {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @Column(nullable=false, unique=true)
    private Date date;
    
    @Column
    private String details;
    
    @Column
    private boolean isPublicHoliday;
    
}
