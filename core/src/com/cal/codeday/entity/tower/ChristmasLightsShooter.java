package com.cal.codeday.entity.tower;

/**
 * Created by Owner on 11/8/2014.
 */
public class ChristmasLightsShooter extends Tower {

    public ChristmasLightsShooter() {
        super ("placeholder1" , 64);
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
