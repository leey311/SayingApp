package com.ll;

import com.ll.controller.Controller;
import java.util.Scanner;

public class App {
    private final Controller controller;

    public App(Controller controller){
        this.controller = controller;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("==명언 앱==\n1:등록 2:삭제 3:수정 4:목록 5:빌드 6:검색) ");
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
                    controller.build();
                    break;
                case "6":
                    controller.searchSaying(scanner);
                    break;
            }
        }
    }
}
