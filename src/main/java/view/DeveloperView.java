package view;

/**
 * Все данные, необходимые для работы с консолью
 */

public class DeveloperView {
    public static String getMainMenu() {
        String menu = "Выберите пункт из списка:\n" +
                "1. Показать всех Девелоперов.\n" +
                "2. Добавить девелопера\n" +
                "3. Редактировать запись о девелопере.\n" +
                "4. Удалить запись о девелопере.\n";
        return menu;
    }
}
