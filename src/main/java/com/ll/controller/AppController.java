package com.ll.controller;

import com.ll.service.AppService;

import java.io.IOException;
import java.util.Scanner;

public class AppController {
    private final AppService appService;
    private final Scanner scanner = new Scanner(System.in);

    public AppController(){
        this.appService = new AppService();
    }
    public void start() throws IOException {
        while(true){
            System.out.print("==명언 앱==\n1:등록 2:삭제 3:수정 4:목록 5:빌드 6:검색) ");
            String start = scanner.nextLine();
            switch (start){
                case "1":
                    appService.regist(scanner);
                    break;
                case "2":
                    appService.delete(scanner);
                    break;
                case "3":
                    appService.modify(scanner);
                    break;
                case "4":
                    appService.list();
                    break;
                case "5":
                    appService.build();
                    break;
                case "6":
                    appService.searchSaying(scanner);
                    break;
            }
        }
    }
}
