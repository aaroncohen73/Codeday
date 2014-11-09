package com.cal.codeday.entity.tower;

import com.cal.codeday.entity.Entity;
import com.cal.codeday.entity.enemy.Person;

/**
 * Created by acohen on 11/8/14.
 */
public class Projectile extends Entity {

    Tower shooter;
    Person target;

    public Projectile(String texPath, int width, int height, Tower shooter, Person target){
        super(texPath, width, height);
        this.xPos = shooter.getxPos();
        this.yPos = shooter.getyPos();
        this.shooter = shooter;
        this.target = target;


    }

    public void setVelocity(){
        float dx = target.getxPos() - xPos;
        float dy = target.getyPos() - yPos;
        double theta = Math.atan(dy / dx) + ((dx < 0)?Math.PI/2:0);
    }

}
