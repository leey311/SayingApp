package com.ll.repository;

import com.ll.entity.Saying;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Repository {
    int registApp(String name, String say);

    void deleteApp(int a) throws IOException;

    boolean checkEntity(int a);

    void modifyApp(int del, String name, String say);

    ArrayList<Saying> findAll();

    void build() throws IOException;

    List<Saying> search(String term);
}
