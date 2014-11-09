package com.cal.codeday.entity.tower;

import com.cal.codeday.entity.Entity;

/**
 * Created by acohen on 11/8/14.
 */
public class Tower extends Entity {

    protected int level = 1; //Tower level
    protected float range; //Range of the tower
    protected float power; //Satisfaction it provides
    //int piercing; //Number of enemies it can go through
    protected float AOE; //Area of Effect on landing
    protected float fire_rate = 0; // How fast the tower can shoot
    protected int cost = 0; // Cost of the tower
    protected float slow = 0; // The amount the target is slowed when shot

    public void levelUp(){
        level += 1;
    }



    public Tower(String texPath, int size2){
        super(texPath, size2, size2);
    }

}
