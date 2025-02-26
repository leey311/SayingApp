package com.ll.repository;

import com.ll.entity.Saying;

import java.util.List;

public interface Repository {
    int registApp(String name, String say);

    void deleteApp(int a);

    void modifyApp(int del, String name, String say);

    void build();

    boolean checkEntity(int a);

    List<Saying> findAll();

    List<Saying> search(String term);
}
