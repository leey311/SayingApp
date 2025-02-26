package com.ll.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.entity.Saying;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemoryRepository implements Repository{
    private final HashMap<Integer, Saying> sayingHashMap = new HashMap<>();;
    private final ObjectMapper objectsMapper = new ObjectMapper();
    private int a = 0;

    @Override
    public int registApp(String name, String say) {
        Saying saying = new Saying(++a, name, say);
        sayingHashMap.put(a, saying);
        saveFile("" + a, saying);
        return a;
    }

    @Override
    public void deleteApp(int a) {
        sayingHashMap.remove(a);
        deleteFile("" + a);
    }

    @Override
    public boolean checkEntity(int a) {
        return sayingHashMap.containsKey(a);
    }

    @Override
    public void modifyApp(int mod, String name, String say) {
        Saying saying = new Saying(mod, name, say);
        sayingHashMap.put(mod, saying);
        saveFile("" + mod, saying);
    }

    @Override
    public List<Saying> findAll() {
        return new ArrayList<>(sayingHashMap.values());
    }

    @Override
    public void build() {
        try {
            objectsMapper.writeValue(new File("data"), findAll());
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Saying> search(String term){
        List<Saying> searchList = new ArrayList<>();
        for (Saying i : findAll()){
            if (i.say().contains(term) || i.name().contains(term)){
                searchList.add(i);
            }
        }
        return searchList;
    }

    private void saveFile(String fileName, Saying saying) {
        try {
            String formattedFileName = String.format("db/%s",fileName);
            objectsMapper.writeValue(new File(formattedFileName), saying);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    private void deleteFile(String fileName) {
        try {
            String formattedFileName = String.format("db/%s",fileName);
            Files.deleteIfExists(Path.of(formattedFileName));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

}
