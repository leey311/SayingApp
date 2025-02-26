package com.ll.engine;

import com.ll.controller.Controller;
import java.util.Scanner;

public class App {
    private final Controller controller;
    private final Scanner scanner;

    public App(Controller controller, Scanner scanner){
        this.controller = controller;
        this.scanner = scanner;
    }

    public void run(){
        boolean isRunning = true;
        while(isRunning){
            System.out.print("==명언 앱==\n1:등록 2:삭제 3:수정 4:목록 5:검색) ");
            String start = scanner.nextLine();
            switch (start){
                case "1":
                    controller.regist(scanner);
                    break;
                case "2":
                    controller.delete(scanner);
                    break;
                case "3":
                    controller.modify(scanner);
                    break;
                case "4":
                    controller.list();
                    break;
                case "5":
                    controller.searchSaying(scanner);
                    break;
                default:
                    controller.build();
                    isRunning = false;
                    break;
            }
        }
    }
}
