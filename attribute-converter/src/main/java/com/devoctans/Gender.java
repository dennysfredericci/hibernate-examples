package com.devoctans;

public enum Gender {

    FEMALE("F"),
    MALE("M"),
    UNKNOWN("U");

    private final String code;

    Gender(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
