import controller.DeveloperController;
import model.Developer;
import model.Skill;
import model.Speciality;
import repository.GsonDeveloperRepositoryImpl;
import view.DeveloperView;

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
//        DeveloperController controller = new DeveloperController();
        GsonDeveloperRepositoryImpl repo = new GsonDeveloperRepositoryImpl();
        // Записать девелоперов на диск
        System.out.println(repo.create(developer));
        System.out.println(repo.create(developer2));
        // считать девелоперов с диска
        System.out.println(repo.read(1));
        System.out.println(repo.read(2));
        // обновить запись о девелопере и считать её снова
        developer2.setSpeciality(new Speciality("C++ and Assembler Developer"));
        System.out.println(repo.read(2));
        // считать все записи о девелоперах
        System.out.println("Получаем список всех Девелоперов:\n" + repo.readAll());

    }
}
