package com.cal.codeday.entity.tower;

import com.cal.codeday.level.Level;

/**
 * Created by Dhaley on 11/8/2014.
 */
public class BottledEggnogLauncher extends Tower {

    String projectileTexture = "gfx/spriteFinal/Towers/Nog.png";

    public BottledEggnogLauncher(Level currentLevel) {
        super ("gfx/spriteFinal/Tower/NogLauncher/noglauncher" , 64, currentLevel);
        range = 300f;
        power = 35f;
        fire_rate = 2f;
        cost = 250;
        slow = 2f;
        AOE = 60f;
    }

    @Override
    public void levelUp() {
        slow *= 1.02;
        range *= 1.05;
        power *= 1.10;
        fire_rate *= 1.02;
        AOE *= 1.02;
        super.levelUp();
    }
}
