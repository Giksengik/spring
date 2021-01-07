package ru.firstApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Computer {
    @Value("${computer.id}")
    private int id;
    @Value("${computer.name}")
    private String name;
    public MusicPlayer musicPlayer;
    public Computer(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }
    @PostConstruct
    public void doMyInitialization(){
        System.out.println("Initialize.....");
    }
    @PreDestroy
    public void doMyDestroy(){
        System.out.println("Destroying.....");
    }
}
