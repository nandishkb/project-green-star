package com.outreach.greenstar.utility;

public enum ColorEnum {

    
    GREEN(1), // GOOD
    BLUE(-7777), // HOLIDAY
    RED(0), // BAD
    YELLOW(2), // AVG
    WHITE(-9999);// NO RESULT
    int id;
    ColorEnum(int code) {
        id = code;
    }
    public int getId() {
        return id;
    }
}
