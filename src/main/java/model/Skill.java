package model;

public class Skill {
    String title;

    Skill() {}

    public Skill(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "'" + title + '\'';
    }
}
