package com.konrad.school.model;

public enum Subject {
    MATHEMATICS("mathematics"),
    SCIENCE("science"),
    ART("art"),
    MUSIC("music");

    private String subjectName;

    Subject(String subjectName) {
        this.subjectName = subjectName;
    }
    public String getSubjectName(){
        return subjectName;
    }
}
