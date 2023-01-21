package com.afoninav.view;

import com.afoninav.controller.DeveloperController;

import java.util.Scanner;

/**
 *
 */

public class DeveloperView {
    private final Scanner scanner = new Scanner(System.in);
    private final DeveloperController controller = new DeveloperController();

     public void createDeveloper() {
         System.out.println("Enter name: ");
         String firstName = scanner.nextLine();
         System.out.println("Enter surname: ");
         String lastName = scanner.nextLine();
         System.out.println("Enter skills: ");
         String skills = scanner.nextLine().replaceAll(" ","");
         System.out.println("Enter speciality: ");
         String speciality = scanner.nextLine();
         String resultOfCreation = controller.createDeveloper(firstName, lastName, skills, speciality);
         System.out.println(resultOfCreation);
     }

    public void readAllDevelopers() {
        System.out.println("All records of Developers: ");
         controller.getAllDevelopers()
                 .stream()
                 .forEach(System.out::println);
    }

    public void readDeveloperById() {
        System.out.println("Enter Developer's id for read: ");
        int id = scanner.nextInt();
        String searchResult = controller.getDeveloperById(id);
        System.out.println(searchResult);
    }

    public void updateDeveloper() {
        System.out.println("Enter developer's id for update: ");
        int id = scanner.nextInt();
        System.out.println("Enter new first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter new surname: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter new skills in one line. For example: Coding, Review, Manage");
        String skills = scanner.nextLine();
        System.out.println("Enter new specialization: ");
        String speciality = scanner.nextLine();
        String resultOfUpdate = controller.updateDeveloper(id, firstName, lastName, skills, speciality);
        System.out.println(resultOfUpdate);
    }

    public void deleteDeveloperById() {
        System.out.println("Enter developer's id for delete: ");
        int id = scanner.nextInt();
        String resultOfDelete = controller.deleteDeveloperById(id);
        System.out.println(resultOfDelete);
    }

}
