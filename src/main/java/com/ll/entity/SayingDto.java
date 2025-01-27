package com.ll.entity;

public class SayingDto {
    private int id;
    private String name;
    private String say;

    public SayingDto(int id, String name, String say){
        this.id = id;
        this.name = name;
        this.say = say;
    }
    @Override
    public String toString(){
        return id + " / " + name + " / " + say;
    }
}
