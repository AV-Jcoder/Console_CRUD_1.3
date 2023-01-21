package com.afoninav.model;

public class Speciality {
    private int id;
    private String title;

    Speciality() {}

    public Speciality(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "'" + title + '\'';
    }
}
