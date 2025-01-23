package com.ll.repository;

import com.ll.entity.Saying;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryRepository implements Repository{
    private final HashMap<Integer, Saying> sayingHashMap;
    private int a = 0;

    public MemoryRepository(){
        sayingHashMap = new HashMap<>();
    }

    @Override
    public int registApp(String name, String say) {
        Saying saying = new Saying(++a, name, say);
        sayingHashMap.put(a, saying);
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
        sayingHashMap.put(a,saying);
    }

    @Override
    public void findAll() {
        List<Map.Entry<Integer, Saying>> list = new ArrayList<>(sayingHashMap.entrySet());
    }
}
