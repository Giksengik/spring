package ru.firstApp;

import org.springframework.stereotype.Component;
@Component
public class RockMusic implements Music {
    @Override
    public String[] getSong() {
        return new String[]{"Safe at Home", "Sweetheart of the Rodeo", " Rory Storm and the Hurricanes"};
    }
}
