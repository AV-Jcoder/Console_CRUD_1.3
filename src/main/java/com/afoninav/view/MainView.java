package com.afoninav.view;

import java.util.Scanner;

public class MainView {
    private final Scanner scanner = new Scanner(System.in);
    private DeveloperView developerView = new DeveloperView();

    public void showMainMenu() {
        String menu = "Enter number of menu:\n" +
                "1. Create developer's record;\n" +
                "2. Show all developers records;\n" +
                "3. Update developer's record;\n" +
                "4. Delete developer's record;\n" +
                "0. Exit from program\n";
        System.out.println(menu);
    }

    public void translateUserChoice() {
        int userPeek = scanner.nextInt();
        switch (userPeek) {
            case 1 :
                developerView.createDeveloper();
                break;
            case 2 :
                developerView.readAllDevelopers();
                break;
            case 3 :
                developerView.updateDeveloper();
                break;
            case 4 :
                developerView.deleteDeveloperById();
                break;
            case 0 :
                System.out.println("Bye-bye.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid menu's number. Try again.");
        }
    }
}

