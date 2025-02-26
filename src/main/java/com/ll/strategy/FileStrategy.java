package com.ll.strategy;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileStrategy {
    private final ObjectMapper objectsMapper;

    public FileStrategy(ObjectMapper objectsMapper) {
        this.objectsMapper = objectsMapper;
    }

    public <T> void saveFile(String fileName, T saying) {
        template(new MangeFile() {
            @Override
            public void doSomeThing(String formattedFileName) throws IOException {
                objectsMapper.writeValue(new File(formattedFileName), saying);
            }
        }, fileName);
    }

    public void deleteFile(String fileName) {
        template(new MangeFile() {
            @Override
            public void doSomeThing(String formattedFileName) throws IOException {
                Files.delete(Path.of(formattedFileName));
            }
        }, fileName);
    }

    private void template(MangeFile mangeFile, String fileName){
        try {
            String formattedFileName = String.format("db/%s",fileName);
            mangeFile.doSomeThing(formattedFileName);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
