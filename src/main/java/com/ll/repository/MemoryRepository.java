package com.ll.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.entity.SayingDto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MemoryRepository implements Repository{
    private final HashMap<Integer, SayingDto> sayingHashMap;
    private final ObjectMapper objectsMapper = new ObjectMapper();
    private int a = 0;

    public MemoryRepository(){
        sayingHashMap = new HashMap<>();
    }

    @Override
    public int registApp(String name, String say) {
        SayingDto saying = new SayingDto(++a, name, say);
        sayingHashMap.put(a, saying);
        try {
            saveFile("file" + a);
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
        SayingDto saying = new SayingDto(del, name, say);
        sayingHashMap.put(a,saying);
    }

    @Override
    public ArrayList<SayingDto> findAll() {
        return new ArrayList<>(sayingHashMap.values());
    }

    private void saveFile(String fileName) throws IOException {
        objectsMapper.writeValue(new File(fileName), sayingHashMap);
    }
}
