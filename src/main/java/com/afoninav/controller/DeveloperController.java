package com.afoninav.controller;

import com.afoninav.model.Developer;
import com.afoninav.model.Skill;
import com.afoninav.model.Speciality;
import com.afoninav.repository.gson.GsonDeveloperRepositoryImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Клей между BL и UI.
 */

public class DeveloperController {

    private static GsonDeveloperRepositoryImpl gsonDevRepo = new GsonDeveloperRepositoryImpl();

    /**
     * This method is converter from List<String> to List<Skill>
     * @param   skills  the string of skills
     * @return      the list of skills
     */
    private static List<Skill> listConverter(String skills) {
        return Stream.of(skills.split(","))
                .map(Skill::new)
                .collect(Collectors.toList());
    }

    public String createDeveloper(String firstName, String lastName, String skills, String speciality) {
        Developer dev = gsonDevRepo.create(new Developer(firstName, lastName, listConverter(skills),
                new Speciality(speciality)));
        return dev == null ? "CREATED 0" : "CREATED 1";
    }

    public String getDeveloperById(int id) {
        return gsonDevRepo.readById(id).toString();
    }

    public String updateDeveloper(int id, String firstName, String lastName, String skills, String speciality) {
        Developer developer = new Developer(firstName, lastName, listConverter(skills), new Speciality(speciality));
        developer.setId(id);
        return gsonDevRepo.update(developer) == null ? "UPDATED 0" : "UPDATED 1";
    }

    public String deleteDeveloperById(int id) {
        return gsonDevRepo.deleteById(id) ? "DELETED 1" : "DELETED 0";
    }

    public List<String> getAllDevelopers() {
        return gsonDevRepo.readAll()
                .stream()
                .map(Developer::toString)
                .collect(Collectors.toList());
    }



}
