package com.outreach.greenstar.exeption;

public class HolidayNotFoundException extends RuntimeException {

    public HolidayNotFoundException(String msg) {
        super(msg);
    }

}
