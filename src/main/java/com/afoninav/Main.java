package com.afoninav;

import com.afoninav.model.Developer;
import com.afoninav.model.Skill;
import com.afoninav.model.Speciality;
import com.afoninav.repository.gson.GsonDeveloperRepositoryImpl;

import java.util.List;

/**
 * Класс для запуска приложения
 */
public class Main {
    public static void main(String[] args) {
        Developer developer = new Developer("Ivan", "Ivanov",
                List.of(new Skill("Coding"),new Skill("Code Review")), new Speciality("Java Developer"));

        GsonDeveloperRepositoryImpl gsDevRepo = new GsonDeveloperRepositoryImpl();
        gsDevRepo.create(developer);
        System.out.println(gsDevRepo.readAll());
    }
}
