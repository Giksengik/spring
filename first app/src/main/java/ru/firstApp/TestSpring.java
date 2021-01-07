package ru.firstApp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RockMusic rockMusic = context.getBean("someRockMusic",RockMusic.class);
        System.out.println(rockMusic.getSong());
        ClassicalMusic classicalMusic = context.getBean("classicalMusic",ClassicalMusic.class);
        System.out.println(classicalMusic.getSong());
        context.close();
        MusicPlayer musicPlayer = new MusicPlayer(classicalMusic);
        musicPlayer.playMusic();
    }
}
