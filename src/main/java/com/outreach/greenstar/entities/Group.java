package com.outreach.greenstar.entities;

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
@Table(name = "group_table", uniqueConstraints=@UniqueConstraint(columnNames={"cls_id", "name"}))
public class Group {

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
    
    @Column(nullable=false)
    private String name;
    
    @Column
    private int size;
    
    @ManyToOne(optional=true, cascade=CascadeType.ALL)
    private Section section;
    
    @ManyToOne(cascade=CascadeType.ALL)
    private Cls cls;
    
}
