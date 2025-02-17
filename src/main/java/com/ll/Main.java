package com.ll;

import com.ll.controller.AppController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AppController appController = new AppController();
        appController.start();
    }
}