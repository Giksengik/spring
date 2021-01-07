package ru.firstApp;


public class JazzMusic implements Music {
    @Override
    public String[] getSong(){
        return new String[]{"Go Down Moses", "Winter Night Jazz", "Lucretia Mac Evil"};
    }
}
