package ru.firstApp;

import java.util.ArrayList;
import java.util.Arrays;

public class MusicList {
    private ArrayList<String> listOfMusic;
    MusicList(ClassicalMusic classicalMusic ,RockMusic rockMusic,
              JazzMusic jazzMusic){
        listOfMusic = new ArrayList<String>();
        listOfMusic.addAll(Arrays.asList(classicalMusic.getSong()));
        listOfMusic.addAll(Arrays.asList(jazzMusic.getSong()));
        listOfMusic.addAll(Arrays.asList(rockMusic.getSong()));
    }

    public ArrayList<String> getListOfMusic() {
        return listOfMusic;
    }
}
