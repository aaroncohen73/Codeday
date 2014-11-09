package com.cal.codeday.entity.tower;

import com.cal.codeday.level.Level;

/**
 * Created by Dhaley on 11/8/2014.
 */
public class CandyShooter extends Tower {

    String projectileTexture = "gfx/spriteFinal/Towers/PresentShooter/projectileCandyYellow01.png";

    public CandyShooter(Level currentLevel, float x, float y) {
        super("gfx/spriteFinal/Towers/CandyShooter/towerCandyShooter", 64, currentLevel);
        xPos = x;
        yPos = y;
        range = 20f;
        fire_rate = 12f;
        cost = 100;
        power = 5f;
    }

    @Override
    public void levelUp() {
        range *= 1.05;
        power *= 1.10;
        fire_rate *= 1.02;
        super.levelUp();
    }
}
