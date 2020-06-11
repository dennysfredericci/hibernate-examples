package com.devoctans;

public enum Status {

    ACTIVE("A"),
    INACTIVE("I");

    private final String code;

    Status(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
