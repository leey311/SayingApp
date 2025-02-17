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
        try {
            saveFile(""+ a , saying);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return a;
    }

    @Override
    public void deleteApp(int a) throws IOException {
        sayingHashMap.remove(a);
        deleteFile("" + a);
    }

    @Override
    public boolean checkEntity(int a) {
        return sayingHashMap.containsKey(a);
    }

    @Override
    public void modifyApp(int del, String name, String say) {
        Saying saying = new Saying(del, name, say);
        sayingHashMap.put(del, saying);
        try {
            saveFile("" + del , saying);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Saying> findAll() {
        return new ArrayList<>(sayingHashMap.values());
    }

    @Override
    public void build() throws IOException {
        objectsMapper.writeValue(new File("data"), findAll());
    }

    @Override
    public List<Saying> search(String term){
        List<Saying> searchList = new ArrayList<>();
        for (Saying i : findAll()){
            if (i.getSay().contains(term) || i.getName().contains(term)){
                searchList.add(i);
            }
        }
        return searchList;
    }

    private void saveFile(String fileName, Saying saying) throws IOException {
        String formattedFileName = String.format("db/%s",fileName);
        objectsMapper.writeValue(new File(formattedFileName), saying);
    }
    private void deleteFile(String fileName) throws IOException {
        String formattedFileName = String.format("db/%s",fileName);
        Files.deleteIfExists(Path.of(formattedFileName));
    }
}
