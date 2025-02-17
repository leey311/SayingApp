package com.ll.service;

import com.ll.entity.Saying;
import com.ll.repository.MemoryRepository;
import com.ll.repository.Repository;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class AppService {
    private final Repository repository;
    public AppService(){
        this.repository = new MemoryRepository();
    }
    public void regist(Scanner scanner) {
        System.out.print("이름) ");
        String name = scanner.nextLine();
        System.out.print("명언) ");
        String say = scanner.nextLine();

        System.out.println(repository.registApp(name,say) + " 번 명언이 등록되었습니다.");
    }
    public String delete(Scanner scanner) throws IOException {
        int del = choose(scanner);
        if(check(del)){
            repository.deleteApp(del);
            return "삭제되었습니다";
        }
        return "존재하지 않습니다.";
    }
    private boolean check(int del){
        return repository.checkEntity(del);
    }
    private int choose(Scanner scanner){
        System.out.print("번호) ") ;
        int choose = scanner.nextInt();
        scanner.nextLine();
        return choose;
    }
    public String modify(Scanner scanner) {
        int del = choose(scanner);
        if(check(del)){
            System.out.print("이름) ");
            String name = scanner.nextLine();
            System.out.print("명언) ");
            String say = scanner.nextLine();
            repository.modifyApp(del, name, say);
            return "수정 완료";
        }
        return "존재하지 않습니다.";
    }
    public void list() {
        for(Saying a : repository.findAll()){
            System.out.println(a);
        }
    }
    public void build() throws IOException {
        repository.build();
    }
    public void searchSaying(Scanner scanner){
        System.out.print("찾으시는 단어를 입력해주세요) ");
        String term = scanner.nextLine();
        List<Saying> searchList = repository.search(term);

        for (Saying i : searchList){
            System.out.println(i);
        }
    }
}
