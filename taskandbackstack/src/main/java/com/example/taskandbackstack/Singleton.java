package com.example.taskandbackstack;

public final class Singleton {
    public static volatile Singleton _instance = new Singleton();
    private static final String STACK = "Stack";

    private Singleton() {
    }

    public static String getSTACK() {
        return STACK;
    }
}
