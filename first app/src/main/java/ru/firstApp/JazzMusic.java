package ru.firstApp;

import org.springframework.stereotype.Component;

@Component
public class JazzMusic implements Music {
    @Override
    public String getSong(){
        return"Go Down Moses";
    }
}
