package com.ll;

import com.ll.engine.App;
import com.ll.engine.SayingAppFactory;

public class Main {
    static SayingAppFactory sayingAppFactory = new SayingAppFactory();
    public static void main(String[] args) {
        intiData();
        App app = sayingAppFactory.createApp();
        app.run();
    }
    public static void intiData(){
        for(int i = 0; i < 10; i++){
            sayingAppFactory.createRepository()
                    .registApp(String.format("작가%s", i), String.format("명언%s", i));
        }
    }
}