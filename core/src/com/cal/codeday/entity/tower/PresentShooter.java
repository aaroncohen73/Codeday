package com.cal.codeday.entity.tower;

import com.cal.codeday.level.Level;

/**
 * Created by Dhaley on 11/8/2014.
 */
public class PresentShooter extends Tower {

    public PresentShooter(Level currentLevel){
        super("gfx/spriteFinal/Towers/PresentShooter/presentShooter", 64, currentLevel);
        xPos = 150;
        yPos = 150;
        range = 200f;
        power = 25f;
        fire_rate = 1f;
        cost = 50;
    }

    public void levelUp(){
        range *= 1.12;
        power *= 1.25;
        fire_rate *= 1.5;
        super.levelUp();
    }

}
