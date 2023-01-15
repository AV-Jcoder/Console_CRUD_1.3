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
        Developer developer = new Developer(1,"Ivan","Ivanov",
                List.of(new Skill("Coding"), new Skill("Refactoring")),new Speciality("Java Developer"));
        DeveloperView developerView = new DeveloperView();
        DeveloperController controller = new DeveloperController();
        GsonDeveloperRepositoryImpl repo = new GsonDeveloperRepositoryImpl();
        System.out.println(repo.create(developer));

    }
}
