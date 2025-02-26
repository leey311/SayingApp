package com.ll.repository;

import com.ll.entity.Saying;
import com.ll.strategy.FileStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemoryRepository implements Repository{
    private final HashMap<Integer, Saying> sayingHashMap = new HashMap<>();
    private final FileStrategy fileStrategy;
    private int a = 0;

    public MemoryRepository(FileStrategy fileStrategy){
        this.fileStrategy = fileStrategy;
    }

    @Override
    public int registApp(String name, String say) {
        Saying saying = new Saying(++a, name, say);
        sayingHashMap.put(a, saying);
        this.fileStrategy.saveFile("" + a, saying);
        return a;
    }

    @Override
    public void deleteApp(int a) {
        sayingHashMap.remove(a);
        this.fileStrategy.deleteFile("" + a);
    }

    @Override
    public boolean checkEntity(int a) {
        return sayingHashMap.containsKey(a);
    }

    @Override
    public void modifyApp(int mod, String name, String say) {
        Saying saying = new Saying(mod, name, say);
        sayingHashMap.put(mod, saying);
        this.fileStrategy.saveFile("" + mod, saying);
    }

    @Override
    public List<Saying> findAll() {
        return new ArrayList<>(sayingHashMap.values());
    }

    @Override
    public void build() {
        this.fileStrategy.saveFile("data", findAll());
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
}
