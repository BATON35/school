package com.konrad.school.model;

public enum TestType {
    TEST("test"),
    QUIZ("quiz"),
    EGZAM("egzam"),
    FINAL_EGZAM("final egzam");

    private String text;

    TestType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
