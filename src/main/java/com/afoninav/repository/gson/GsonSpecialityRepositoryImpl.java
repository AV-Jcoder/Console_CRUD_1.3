package com.afoninav.repository.gson;

import com.afoninav.model.Speciality;
import com.afoninav.repository.SpecialityRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class GsonSpecialityRepositoryImpl implements SpecialityRepository {

    private static final String FILE_PATH = "src/main/resources/specialities.json";
    private static final Gson GSON = new Gson();

    private List<Speciality> readAllSpecialitiesFromDisc() {
        LinkedList<Speciality> list = null;
        try (FileInputStream in = new FileInputStream(FILE_PATH)) {
            String json = new String(in.readAllBytes());
            TypeToken<LinkedList<Speciality>> token = new TypeToken<>(){};
            list = GSON.fromJson(json, token);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Objects.nonNull(list) ? list : new LinkedList<>();
    }

    private void writeAllSpecialitiesToDisc(List<Speciality> list) {
        try (FileOutputStream out = new FileOutputStream(FILE_PATH)) {
            String json = GSON.toJson(list);
            out.write(json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int generateId(List<Speciality> list) {
        Speciality speciality = list
                .stream()
                .max(Comparator.comparing(Speciality::getId))
                .orElse(null);
        return Objects.nonNull(speciality) ? speciality.getId()+1 : 1;
    }

    // TODO: add body to interface's methods
    @Override
    public Speciality create(Speciality speciality) {
        return null;
    }

    @Override
    public Speciality readById(Integer integer) {
        return null;
    }

    @Override
    public Speciality update(Speciality speciality) {
        return null;
    }

    @Override
    public boolean deleteById(Integer integer) {
        return false;
    }

    @Override
    public List<Speciality> readAll() {
        return null;
    }
}
