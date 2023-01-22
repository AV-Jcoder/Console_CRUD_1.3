package com.afoninav.repository.gson;

import com.afoninav.model.Skill;
import com.afoninav.repository.SkillRepository;
import com.google.gson.Gson;

import java.util.List;

// TODO: write interface's method body
public class GsonSkillRepositoryImpl implements SkillRepository {

    private static final String FILE_PATH = "src/main/resources/skills.json";
    private static final Gson GSON = new Gson();

    @Override
    public Skill create(Skill skill) {
        return null;
    }

    @Override
    public Skill readById(Integer integer) {
        return null;
    }

    @Override
    public Skill update(Skill skill) {
        return null;
    }

    @Override
    public boolean deleteById(Integer integer) {
        return false;
    }

    @Override
    public List<Skill> readAll() {
        return null;
    }
}
