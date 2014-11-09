package com.cal.codeday.entity.tower;

import com.cal.codeday.level.Level;

/**
 * Created by Dhaley on 11/8/2014.
 */
public class ChristmasTreeMortar extends Tower {

    public ChristmasTreeMortar(Level currentLevel) {
        super ("placeholder4" , 64, currentLevel);
        range = 60f;
        power = 5f;
        fire_rate = 3f;
        AOE = 120f;
        cost = 500;
    }

    @Override
    public void levelUp() {
        range *= 1.05;
        power *= 1.10;
        fire_rate *= 1.05;
        AOE *= 1.05;
        super.levelUp();
    }
}
