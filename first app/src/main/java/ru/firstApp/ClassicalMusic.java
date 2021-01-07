package ru.firstApp;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music {
    public void doMyInit(){
        System.out.println("Doing my initialization");
    }
    public void doMyDestroy(){
        System.out.println("Doing my destruction");
    }
    @Override
    public String[] getSong() {
        return new String[]{"Eine kleine Nachtmusik", "Für Elise", "O mio babbino caro' from Gianni Schicchi"};
    }
    private ClassicalMusic(){}
    public static ClassicalMusic getClassicalMusic(){
        return new ClassicalMusic();
    }
}
