package com.ll;

import com.ll.engine.App;
import com.ll.engine.SayingAppFactory;

public class Main {
    public static void main(String[] args) {
        SayingAppFactory sayingAppFactory = new SayingAppFactory();
        App app = sayingAppFactory.createApp();
        app.run();
    }
}