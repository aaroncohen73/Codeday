package com.cal.codeday.entity.tower;

import com.cal.codeday.entity.Entity;

/**
 * Created by acohen on 11/8/14.
 */
public class Tower extends Entity {

    int level = 0; //Tower level
    int range; //Range of the tower
    int power; //Satisfaction it provides
    int piercing; //Number of towers it can go through
    int AOE; //Area of Effect on landing

    public Tower(String texPath, int size2){
        super(texPath, size2, size2);
    }

}
