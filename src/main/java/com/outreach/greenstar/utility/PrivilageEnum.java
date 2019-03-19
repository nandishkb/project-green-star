package com.outreach.greenstar.utility;

public enum PrivilageEnum {
    ALL(1), DASHBOARD(2), REPORTS(3), SCHOOL_READ(4), SCHOOL_WRITE(5),
    CLASS_READ(6), CLASS_WRITE(7), SECTION_READ(8), SECTION_WRITE(9),
    GROUP_READ(10), GROUP_WRITE(11), HOLIDAY_READ(12), HOLIDAY_WRITE(13),
    STUDENT_READ(14), STUDENT_WRITE(15), ROLES_READ(16), ROLES_WRITE(17);

    private int id;

    PrivilageEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static String[] stringValues() {
        return new String[] { ALL.name(), DASHBOARD.name(), REPORTS.name(),
                SCHOOL_READ.name(), SCHOOL_WRITE.name(), CLASS_READ.name(),
                CLASS_WRITE.name(), SECTION_READ.name(), SECTION_WRITE.name(),
                GROUP_READ.name(), GROUP_WRITE.name(), HOLIDAY_READ.name(),
                HOLIDAY_WRITE.name(), STUDENT_READ.name(), STUDENT_WRITE.name(),
                ROLES_READ.name(), ROLES_WRITE.name() };

    }
}
