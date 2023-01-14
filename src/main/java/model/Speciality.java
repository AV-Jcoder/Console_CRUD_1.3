package model;

public class Speciality {
    String title;

    Speciality() {}

    Speciality(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "'" + title + '\'';
    }
}
