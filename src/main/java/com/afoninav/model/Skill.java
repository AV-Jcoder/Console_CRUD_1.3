package com.afoninav.model;

public class Skill {
    private int id;
    private String title;

    Skill() {}

    public Skill(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
