package com.outreach.greenstar.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "school_table")
public class School {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @Column
    private String name;
    
    @Column
    private int maxClassGrade;
    
    @Column
    private String city;
    
    @Column
    private int pincode;
    
    @Column
    private String address;
    
}
