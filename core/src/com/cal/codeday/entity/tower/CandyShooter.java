package com.cal.codeday.entity.tower;

import com.cal.codeday.level.Level;

/**
 * Created by Dhaley on 11/8/2014.
 */
public class CandyShooter extends Tower {

    public CandyShooter(Level currentLevel) {
        super("placeholder2", 64, currentLevel);
        range = 60f;
        fire_rate = 3f;
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
