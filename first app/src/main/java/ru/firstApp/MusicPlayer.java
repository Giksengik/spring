package ru.firstApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    private Music music;
    private Music music2;
    private String name;
    private int volume;
@Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music music,
                       @Qualifier("classicalMusic") Music music2) {
        this.music=music;
        this.music2=music2;
    }
    public String playMusic(){
        return "Playing: "+this.music.getSong() +" and " +this.music2.getSong();

    }
}
