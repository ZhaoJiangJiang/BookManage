package com.example.bookmanage.enums;

public enum AppointStateEnum {
    SUCCESS(1, "APPOINT_SUCCESS"),
    NO_NUMBER(0, "OUT_OF_STOCK"),
    REPEAT_APPOINT(-1, "REPEAT_APPOINT"),
    SYSTEM_ERROR(-2, "SYSTEM_ERROR");

    private int state;
    private String stateInfo;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    AppointStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static AppointStateEnum stateOf(int index) {
        for (AppointStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
