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
        // Создать девелоперов
        Developer developer = new Developer(1,"Ivan","Ivanov",
                List.of(new Skill("Coding"), new Skill("Refactoring")),new Speciality("Java Developer"));
        Developer developer2 = new Developer(2,"Petr","Petrov",
                List.of(new Skill("Hacking"), new Skill("Testing")),new Speciality("C++ Developer"));
//        DeveloperView developerView = new DeveloperView();
//        DeveloperController com.afoninav.controller = new DeveloperController();
        GsonDeveloperRepositoryImpl repo = new GsonDeveloperRepositoryImpl();
        // Записать девелоперов на диск
        System.out.println(repo.create(developer));
        System.out.println(repo.create(developer2));
        // считать девелоперов с диска
        System.out.println(repo.readById(1));
        System.out.println(repo.readById(2));
        // обновить запись о девелопере и считать её снова
        developer2.setSpeciality(new Speciality("C++ and Assembler Developer"));
        System.out.println(repo.readById(2));
        // считать все записи о девелоперах
        System.out.println("Получаем список всех Девелоперов:\n" + repo.readAll());
        // удалить запись о девелопере с диска
        System.out.println("Запись удалена?: " + repo.deleteById(1));
        // Проверить, считав записи с диска
        System.out.println("Получаем список всех Девелоперов:\n" + repo.readAll());
    }
}
