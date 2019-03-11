package com.outreach.greenstar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outreach.greenstar.service.HolidayService;

@RestController
@RequestMapping("/api/v1/holiday")
public class HolidayController {

    @Autowired
    private HolidayService holidayService;
}
