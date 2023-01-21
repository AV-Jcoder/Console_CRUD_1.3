package com.afoninav.controller;

import com.afoninav.model.Developer;
import com.afoninav.model.Skill;
import com.afoninav.model.Speciality;
import com.afoninav.repository.gson.GsonDeveloperRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Клей между BL и UI.
 */

public class DeveloperController {

    private static GsonDeveloperRepositoryImpl gsonDevRepo = new GsonDeveloperRepositoryImpl();

    /**
     * This method is converter from List<String> to List<Skill>
     * @param   list    the list of strings
     * @return      the list of skills
     */
    private static List<Skill> listConverter(List<String> list) {
        return list.stream()
                .map(Skill::new)
                .collect(Collectors.toList());
    }

    public String createDeveloper(String firstName, String lastName, List<String> skills, String speciality) {
        return gsonDevRepo.create(new Developer(firstName, lastName, listConverter(skills), new Speciality(speciality)))
                == null ? "CREATED 0" : "CREATED 1";
    }

    public String getDeveloperById(int id) {
        Developer developer = gsonDevRepo.readById(id);
        return developer.toString();
    }

    public String updateDeveloper(String firstName, String lastName, List<String> skills, String speciality) {
        Developer developer = new Developer(firstName, lastName, listConverter(skills), new Speciality(speciality));
        return gsonDevRepo.update(developer) == null ? "UPDATED 0" : "UPDATED 1";
    }

    public String deleteDeveloperById(int id) {
        return gsonDevRepo.deleteById(id) ? "DELETED 1" : "DELETED 0";
    }

    public String getAllDevelopers() {
        return gsonDevRepo.readAll().toString();
    }



}
