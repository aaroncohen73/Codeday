package com.cal.codeday.entity.tower;

import com.cal.codeday.level.Level;

/**
 * Created by Dhaley on 11/8/2014.
 */
public class ChristmasLightsShooter extends Tower {

    public ChristmasLightsShooter(Level currentLevel) {
        super ("placeholder1" , 64, currentLevel);
        slow = 50f;
        fire_rate = .75f;
        cost = 50;
    }

    @Override
    public void levelUp() {
        slow *= 1.05;
        super.levelUp();
    }
}
