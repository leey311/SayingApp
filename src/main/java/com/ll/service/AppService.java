package com.ll.service;

import com.ll.repository.MemoryRepository;
import com.ll.repository.Repository;

import java.util.Scanner;

public class AppService {
    private final Repository repository;
    public AppService(){
        this.repository = new MemoryRepository();
    }
    public void regist(Scanner scanner) {
        System.out.print("NAME) ");
        String name = scanner.nextLine();
        System.out.print("SAYING) ");
        String say = scanner.nextLine();

        System.out.println(repository.registApp(name,say) + " regist complete.");
    }

    public String delete(Scanner scanner) {
        int del = choose(scanner);
        if(check(del)){
            repository.deleteApp(del);
            return "delete complete";
        }
        return "not found.";
    }

    private boolean check(int del){
        return repository.checkEntity(del);
    }
    private int choose(Scanner scanner){
        System.out.print("ID) ") ;
        int choose = scanner.nextInt();
        scanner.nextLine();
        return choose;
    }

    public String modify(Scanner scanner) {
        int del = choose(scanner);
        if(check(del)){
            System.out.print("NAME) ");
            String name = scanner.nextLine();
            System.out.print("SAYING) ");
            String say = scanner.nextLine();
            repository.modifyApp(del, name, say);
            return "modify complete";
        }
        return "not found.";
    }

    public void list() {
        repository.findAll();
    }
}
