package com.afoninav;

import com.afoninav.view.MainView;

/**
 * Класс для запуска приложения
 */
public class AppRunner {
    public static void main(String[] args) {

        MainView mainView = new MainView();
        while(true) {
            mainView.showMainMenu();
            mainView.translateUserChoice();
        }
    }
}
