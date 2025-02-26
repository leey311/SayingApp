package com.ll.service;

import com.ll.entity.Saying;
import com.ll.repository.Repository;

import java.util.List;


public class AppService implements Service{
    private final Repository repository;

    public AppService(Repository repository){
        this.repository = repository;
        for (int i = 1; i < 6; i++) {
            this.repository.registApp("name " + i, "say " + i);
            System.out.println(i + " 번째 명언 등록 완료");
        }
    }

    @Override
    public int regist(String name, String say) {
        return repository.registApp(name, say);
    }

    @Override
    public void delete(int del) {
        repository.deleteApp(del);
    }

    @Override
    public boolean check(int del){
        return repository.checkEntity(del);
    }

    @Override
    public void modify(int mod, String name, String say) {
        repository.modifyApp(mod, name, say);
    }

    @Override
    public List<Saying> list() {
        return repository.findAll();
    }

    @Override
    public void build(){
        repository.build();
    }

    @Override
    public List<Saying> search(String term){
        return repository.search(term);
    }
}
