package ru.firstApp;

public class MusicPlayer {
    private Music music;
    public MusicPlayer(Music music){
        this.music=music;
    }
    public void playMusic(){
        System.out.println("Playing: "+this.music.getSong());
    }
}
