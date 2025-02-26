package com.ll.controller;

import com.ll.entity.Saying;
import com.ll.service.Service;

import java.util.List;
import java.util.Scanner;

public class AppController implements Controller{
    private final Service service;

    public AppController(Service service){
        this.service = service;
    }

    @Override
    public void regist(Scanner scanner) {
        String[] registItem = inputSaying(scanner);
        int id  = service.regist(registItem[0], registItem[1]);
        System.out.println(id + " 번 명언이 등록되었습니다.");
    }

    @Override
    public void delete(Scanner scanner) {
        System.out.println("삭제할 번호를 입력해주세요");
        int del = scanner.nextInt();
        scanner.nextLine();

        if(check(del)){
            service.delete(del);
            System.out.println(del + " 번 명언을 삭제하였습니다.");
        }else System.out.println("존재하지 않은 명언입니다.");
    }

    @Override
    public void modify(Scanner scanner) {
        System.out.println("수정할 번호를 입력해주세요");
        int mod = scanner.nextInt();
        scanner.nextLine();

        if(check(mod)){
            String[] registItem = inputSaying(scanner);
            service.modify(mod, registItem[0], registItem[1]);
            System.out.println("수정 완료");
        }else System.out.println("존재하지 않는 명언입니다.");
    }

    @Override
    public void list() {
        List<Saying> SayingList = service.list();
        for(Saying a : SayingList){
            System.out.println(a);
        }
    }

    @Override
    public void build() {
        service.build();
    }

    @Override
    public void searchSaying(Scanner scanner) {
        System.out.print("찾으시는 단어를 입력해주세요) ");
        String term = scanner.nextLine();
        List<Saying> searchList = service.search(term);

        if(searchList.isEmpty()){
            System.out.println("검색 결과가 없습니다.");
        }else {
            for (Saying i : searchList){
                System.out.println(i);
            }
        }
    }

    private boolean check(int del) {
        return service.check(del);
    }

    private String[] inputSaying(Scanner scanner){
        String[] input = new String[2];
        System.out.print("이름) ");
        input[0] = scanner.nextLine();
        System.out.print("명언) ");
        input[1] = scanner.nextLine();
        return input;
    }
}
