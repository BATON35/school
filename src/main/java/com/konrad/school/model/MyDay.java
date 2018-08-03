package com.konrad.school.model;

public enum MyDay {
    MONDAY("Mon"),
    TUESDAY("Tue"),
    WEDNESDAY("Wed"),
    THURSDAY("Thu"),
    FRIDAY("Fri"),
    SATURDAY("Sat"),
    SONDAY("Sun");

    private String dayName;

    MyDay(String dayName){
        this.dayName = dayName;
    }

    public String getDayName() {
        return dayName;
    }
}
