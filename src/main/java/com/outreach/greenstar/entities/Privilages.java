package com.outreach.greenstar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="privilage_table")
public class Privilages {

    @Id
    @Column
    private int id;
    
    @Column(unique=true, nullable=false)
    private String title;
    
}
