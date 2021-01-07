package ru.firstApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    private static final MusicList music = MusicList.ROCK ;
    private int id;
    private MusicPlayer musicPlayer;
    @Autowired
    public Computer(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
        this.id=1;
    }

    @Override
    public String toString() {
        return "Computer " + id+ " "+musicPlayer.playMusic(music);
    }
}
