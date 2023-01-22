package com.afoninav.repository.gson;

import com.afoninav.model.Skill;
import com.afoninav.repository.SkillRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

// TODO: write interface's method body
public class GsonSkillRepositoryImpl implements SkillRepository {

    private static final String FILE_PATH = "src/main/resources/skills.json";
    private static final Gson GSON = new Gson();

    private List<Skill> readAllSkillsFromDisc() {
        LinkedList<Skill> list = null;
        try (FileInputStream in = new FileInputStream(FILE_PATH)) {
            String json = new String(in.readAllBytes());
            TypeToken<LinkedList<Skill>> token = new TypeToken<>(){};
            list = GSON.fromJson(json, token);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Objects.nonNull(list) ? list : new LinkedList<>();
    }

    private void writeAllSkillsToDisc(List<Skill> list) {
        try (FileOutputStream out = new FileOutputStream(FILE_PATH)) {
            String json = GSON.toJson(list);
            out.write(json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int generateSkillId(List<Skill> list) {
        Skill  skill = list
                .stream()
                .max(Comparator.comparing(Skill::getId))
                .orElse(null);
        return Objects.nonNull(skill) ? skill.getId()+1 : 1;
    }

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
