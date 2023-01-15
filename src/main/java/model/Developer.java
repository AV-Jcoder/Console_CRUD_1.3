package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Developer {
    private int id;
    private String firstName;
    private String lastName;
    private List<Skill> skills;
    private Speciality speciality;
    private Status status;

    public Developer() {
    }

    public Developer(int id, String firstName, String lastName, List<Skill> skills, Speciality speciality) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = new LinkedList<Skill>(skills);
        this.speciality = speciality;
        this.status = Status.ACTIVE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return id == developer.id && firstName.equals(developer.firstName) && lastName.equals(developer.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", skills=" + skills +
                ", speciality=" + speciality +
                ", status=" + status +
                '}';
    }
}
