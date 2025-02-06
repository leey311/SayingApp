package com.ll.repository;

import com.ll.entity.Saying;

import java.util.ArrayList;

public interface Repository {
    int registApp(String name, String say);

    void deleteApp(int a);

    boolean checkEntity(int a);

    void modifyApp(int del, String name, String say);

    ArrayList<Saying> findAll();
}
