package com.outreach.greenstar.dto;
import java.util.Date;

import javax.persistence.Entity;

import lombok.Data;

@Data
public class HolidayDTO {

    private int id;
    private Date date;
    private String details;
    
}