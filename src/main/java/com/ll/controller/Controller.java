package com.ll.controller;

import java.util.Scanner;

public interface Controller {
    void regist(Scanner scanner);

    void delete(Scanner scanner);

    void modify(Scanner scanner);

    void list();

    void build();

    void searchSaying(Scanner scanner);
}
