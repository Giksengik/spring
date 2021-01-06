package ru.firstApp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        ClassicalMusic classicalMusic = context.getBean("musicBean",ClassicalMusic.class);
        ClassicalMusic classicalMusic2 = context.getBean("musicBean",ClassicalMusic.class);
        System.out.println(classicalMusic.getSong());
//        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        MusicPlayer musicPlayer2 = context.getBean("musicPlayer", MusicPlayer.class);
//        System.out.println(musicPlayer==musicPlayer2);
        context.close();
    }
}
