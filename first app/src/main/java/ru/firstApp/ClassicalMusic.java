package ru.firstApp;

import jdk.nashorn.internal.parser.JSONParser;

public class ClassicalMusic implements Music {
    public void doMyInit(){
        System.out.println("Doing my initialization");
    }
    public void doMyDestroy(){
        System.out.println("Doing my destruction");
    }
    @Override
    public String getSong(){
        return "Hungarian Rhapsody";
    }
    private ClassicalMusic(){}
    public static ClassicalMusic getClassicalMusic(){
        return new ClassicalMusic();
    }
}
