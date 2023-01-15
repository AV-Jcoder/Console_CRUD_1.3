package repository;

import com.google.gson.Gson;
import model.Developer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Класс, реализующие доступ к текстовым файлам
 */

// Класс репозиторий
public class GsonDeveloperRepositoryImpl extends DeveloperRepository {

    private static Gson gson = new Gson();
    private static String directory = new String("/tmp/");
    private static String type = new String(".json");

    @Override
    public boolean create(Developer developer) {
        // проверка на уникальность ID.
        // Взять ID и чекнуть файл с таким именем. Если такой файл уже есть вернуть false, т.к.
        // ID уникален и дубликаты невозможны.
        File file = new File(directory,developer.getId() + type);
        if (file.exists()) {
            return false;
        } else {
            // Иначе создать файл.
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        // сохранить информацию о Девелопере на диск.
        // Сериализация в JSON
        String json = gson.toJson(developer);
        byte[] buff = json.getBytes();
        try(FileOutputStream out = new FileOutputStream(file)) {
            // Сохраняем на диск
            out.write(buff);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Developer read(Integer id) {
        // Найти информацию по id о девелопере
        // и вернуть его экземпляр.
        // Чекнуть файл по имени, совпадающем с id, если
        // файл не существует, то вернуть null.
        File file = new File(directory, id + type);
        if (!file.exists()) {
            return null;
        } else {
            // Иначе вернуть содержимое файла, сделав Десериализацию.
            try (FileInputStream in = new FileInputStream(file)) {
                byte[] buff = new byte[in.available()];
                in.read(buff);
                String json = new String(buff);
                Developer developer = gson.fromJson(json, Developer.class);
                return developer;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean update(Developer developer) {
        // обновить информацию о девелопере
        // на основании совпадения поля id передаваемого объекта с именем файла.
        // Чекнуть файл по имени, совпадающем с id передаваемого объекта.
        // Если такого файла нет, то обновить нечего вернуть false.
        File file = new File(directory, developer.getId() + type);
        if (!file.exists()) {
            return false;
        } else {
            // Иначе перезаписать содержимое файла, сделав Сериализацию.
            try (FileOutputStream out = new FileOutputStream(file)) {
                String json = gson.toJson(developer);
                byte[] buff = json.getBytes();
                out.write(buff);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        // удалить девелопера на основании
        // совпадения по полю id.
        // Чекнуть файл по имени, совпадающем со значением передаваемого параметра
        // и если такой файл существует - удалить его и вернуть true, иначе вернуть false.
        File file = new File(directory, id + type);
        if (!file.exists()) {
            return false;
        } else {
            try {
                return file.delete();
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
