package com.cal.codeday.entity.tower;

import com.cal.codeday.level.Level;

/**
 * Created by Dhaley on 11/8/2014.
 */
public class CandyShooter extends Tower {

    public CandyShooter(Level currentLevel, float x, float y) {
        super("gfx/spriteFinal/Towers/CandyShooter/towerCandyShooter", 64, currentLevel);
        projectileTexture = "gfx/spriteFinal/Towers/PresentShooter/projectileCandyYellow01.png";
        xPos = x;
        yPos = y;
        range = 100f;
        fire_rate = 5f;
        cost = 100;
        power = 2f;
    }

    @Override
    public void levelUp() {
        range *= 1.05;
        power *= 1.10;
        fire_rate *= 1.02;
        super.levelUp();
    }
}
