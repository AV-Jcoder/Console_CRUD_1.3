package com.afoninav.repository.gson;

import com.afoninav.model.Speciality;
import com.afoninav.repository.SpecialityRepository;
import com.google.gson.Gson;

import java.util.LinkedList;
import java.util.List;

// TODO: write the interface's method body
public class GsonSpecialityRepositoryImpl implements SpecialityRepository {

    private static final String FILE_PATH = "src/main/resources/skills.json";
    private static final Gson GSON = new Gson();

    private List<Speciality> readAllSpecialitiesFromDisc() {
        // TODO: impl method body
        return new LinkedList<>();
    }

    private void writeAllSpecialitiesToDisc() {
        // TODO: impl method body
    }

    private int generateId() {
        // TODO imple method body
        return 0;
    }

    @Override
    public Object create(Object o) {
        return null;
    }

    @Override
    public Object readById(Object o) {
        return null;
    }

    @Override
    public Object update(Object o) {
        return null;
    }

    @Override
    public boolean deleteById(Object o) {
        return false;
    }

    @Override
    public List readAll() {
        return null;
    }
}
