package com.outreach.greenstar.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="roles_table")
public class Role {

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
    
    @Column(unique=true, nullable=false)
    private String roleName;
    
    @OneToMany(cascade=CascadeType.ALL)
    private List<Privilages> listOfPrivilages;
    
    @Column(nullable=false)
    private String pwd;
}
