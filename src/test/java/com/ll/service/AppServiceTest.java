package com.ll.service;

import com.ll.repository.MemoryRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppServiceTest {

    @Test
    void regist() {
        long start = System.nanoTime();
        MemoryRepository memoryRepository = new MemoryRepository();
        memoryRepository.registApp("test","test");
        long end = System.nanoTime();
        System.out.println(end-start);
    }
}