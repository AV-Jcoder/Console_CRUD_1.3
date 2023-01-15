package com.afoninav.model;

public class Speciality {
    String title;

    Speciality() {}

    public Speciality(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "'" + title + '\'';
    }
}
