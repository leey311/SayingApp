package com.ll.repository;

public interface Repository {
    int registApp(String name, String say);

    void deleteApp(int a);

    boolean checkEntity(int a);

    void modifyApp(int del, String name, String say);

    void findAll();
}
