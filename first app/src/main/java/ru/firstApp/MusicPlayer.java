package ru.firstApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MusicPlayer {
    MusicList musicList;
    private String name;
    private int volume;
    public MusicPlayer(MusicList musicList) {
        this.musicList=musicList;
    }
    public String playMusic(){
        final Random random = new Random();
        return "Playing: "+this.musicList.getListOfMusic().get(random.nextInt(9));
    }
}
