package com.ll.entity;

public record Saying(int id, String name, String say) {

    @Override
    public String toString() {
        return id + " / " + name + " / " + say;
    }
}
