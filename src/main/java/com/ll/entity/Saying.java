package com.ll.entity;


public class Saying {
    private int id;
    private String name;
    private String say;

    public Saying(int id, String name, String say){
        this.id = id;
        this.name = name;
        this.say = say;
    }

    public String getName() {
        return name;
    }
    public String getSay() {
        return say;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return id + " / " + name + " / " + say;
    }
}
