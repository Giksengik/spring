package ru.firstApp;

import org.springframework.stereotype.Component;


public class ClassicalMusic implements Music {
    @Override
    public String[] getSong() {
        return new String[]{"Eine kleine Nachtmusik", "Für Elise", "O mio babbino caro' from Gianni Schicchi"};
    }
}
