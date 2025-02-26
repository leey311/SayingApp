package com.ll;

import com.ll.controller.AppController;
import com.ll.repository.MemoryRepository;
import com.ll.repository.Repository;
import com.ll.service.AppService;
import com.ll.service.Service;

public class SayingAppFactory {
    public App createApp() {
        return new App(new AppController(createService()));
    }
    public Service createService() {
        return new AppService(createRepository());
    }
    public Repository createRepository() {
        return new MemoryRepository();
    }
}
