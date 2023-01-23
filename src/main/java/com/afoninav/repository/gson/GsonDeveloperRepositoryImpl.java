package com.afoninav.repository.gson;

import com.afoninav.model.Status;
import com.afoninav.model.Developer;
import com.afoninav.repository.DeveloperRepository;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс, реализующий доступ к текстовым файлам
 */

public class GsonDeveloperRepositoryImpl implements DeveloperRepository {

    private static final Gson GSON = new Gson();
    private static final String FILE_PATH = "src/main/resources/developers.json";

    private List<Developer> readAllDevelopersFromDisc() {
        LinkedList<Developer> developers = new LinkedList<>();
        try (FileInputStream in = new FileInputStream(FILE_PATH)) {
            String json = new String(in.readAllBytes());
            TypeToken<LinkedList<Developer>> token = new TypeToken<>(){};
            developers = GSON.fromJson(json, token);
        } catch (JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }
        return developers == null ? new LinkedList<>() : developers;
    }

    private void writeAllDevelopersToDisc(List<Developer> developers) {

        try (FileOutputStream out = new FileOutputStream(FILE_PATH)) {
            String json = GSON.toJson(developers);
            out.write(json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int generateDeveloperId(List<Developer> developers) {
        Developer dev = developers
                .stream()
                .max(Comparator.comparing(Developer::getId))
                .orElse(null);
        return dev == null ? 1 : dev.getId() + 1;
    }

    @Override
    public Developer create(Developer developer) {
        // TODO: Реализовать проверку наличие json файла и если его нет, то его нужно создать
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                file.createNewFile();
            }  catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<Developer> existingDevelopers = readAllDevelopersFromDisc();
        int id = generateDeveloperId(existingDevelopers);
        developer.setId(id);
        existingDevelopers.add(developer);
        writeAllDevelopersToDisc(existingDevelopers);
        return developer;
    }

    @Override
    public Developer readById(Integer id) {
        List<Developer> developers = readAllDevelopersFromDisc();
        Developer detectedDeveloper = developers
                .stream()
                .filter((n) -> n.getId() == id)
                .findFirst().orElse(null);
        return detectedDeveloper;
    }

    @Override
    public Developer update(Developer dev) {
        List<Developer> existingDevelopers = readAllDevelopersFromDisc();
        boolean result = existingDevelopers
                .stream().anyMatch((n) -> {
                    if (n.getId() == dev.getId()){
                        n.setFirstName(dev.getFirstName());
                        n.setLastName(dev.getLastName());
                        n.setSkills(dev.getSkills());
                        n.setSpeciality(dev.getSpeciality());
                        n.setStatus(dev.getStatus());
                        return true;
                    } else {
                        return false;
                    }
                });
        writeAllDevelopersToDisc(existingDevelopers);
        return result ? dev : null;
    }

    @Override
    public boolean deleteById(Integer id) {
        List<Developer> existingDevelopers = readAllDevelopersFromDisc();
        boolean result =  existingDevelopers
                .stream()
                .anyMatch((n) -> {
            if (n.getId() == id) {
                n.setStatus(Status.DELETED);
                return true;
            } else {
                return false;
            }
        });
        writeAllDevelopersToDisc(existingDevelopers);
        return result;
    }

    @Override
    public List<Developer> readAll() {
        return readAllDevelopersFromDisc();
    }
}
