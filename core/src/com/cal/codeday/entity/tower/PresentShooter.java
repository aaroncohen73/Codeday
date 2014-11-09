package com.cal.codeday.entity.tower;

/**
 * Created by Owner on 11/8/2014.
 */
public class PresentShooter extends Tower {

    public PresentShooter(){
        super("placeholder", 64);
        range = 60f;
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
