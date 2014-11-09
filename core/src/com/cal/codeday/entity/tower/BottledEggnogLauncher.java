package com.cal.codeday.entity.tower;

/**
 * Created by Owner on 11/8/2014.
 */
public class BottledEggnogLauncher extends Tower {

    public BottledEggnogLauncher() {
        super ("placeholder3" , 64);
        range = 60f;
        power = 35f;
        fire_rate = .50f;
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
