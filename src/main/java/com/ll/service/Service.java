package com.ll.service;

import com.ll.entity.Saying;

import java.util.List;

public interface Service {

    int regist(String name, String say);

    void delete(int a);

    void modify(int del, String name, String say);

    void build();

    boolean check(int a);

    List<Saying> list();

    List<Saying> search(String term);
}

