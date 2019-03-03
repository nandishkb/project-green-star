package com.outreach.greenstar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="address_table")
public class Address {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @Column
    private String city;
    
    @Column
    private int pincode;
    
    @Column
    private String address;
}
