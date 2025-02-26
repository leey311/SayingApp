package com.ll.engine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.controller.AppController;
import com.ll.controller.Controller;
import com.ll.strategy.FileStrategy;
import com.ll.repository.MemoryRepository;
import com.ll.repository.Repository;
import com.ll.service.AppService;
import com.ll.service.Service;

import java.util.Scanner;

public class SayingAppFactory {
    public App createApp() {
        return new App(createController(), createScanner());
    }
    public Controller createController() {
        return new AppController(createService());
    }
    public Service createService() {
        return new AppService(createRepository());
    }
    public Repository createRepository() {
        return new MemoryRepository(createFileStrategy());
    }
    public FileStrategy createFileStrategy() {
        return new FileStrategy(createObjectMapper());
    }
    public ObjectMapper createObjectMapper() {
        return new ObjectMapper();
    }
    public Scanner createScanner() {
        return new Scanner(System.in);
    }
}
