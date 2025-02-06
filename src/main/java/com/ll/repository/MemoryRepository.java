package com.ll.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.entity.Saying;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MemoryRepository implements Repository{
    private final HashMap<Integer, Saying> sayingHashMap = new HashMap<>();;
    private final ObjectMapper objectsMapper = new ObjectMapper();
    private int a = 0;

    @Override
    public int registApp(String name, String say) {
        Saying saying = new Saying(++a, name, say);
        sayingHashMap.put(a, saying);
        try {
            saveFile("file" + a , saying);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return a;
    }

    @Override
    public void deleteApp(int a) {
        sayingHashMap.remove(a);
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
            saveFile("file" + del , saying);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Saying> findAll() {
        return new ArrayList<>(sayingHashMap.values());
    }

    private void saveFile(String fileName, Saying saying) throws IOException {
        objectsMapper.writeValue(new File(fileName), saying);
    }
}
