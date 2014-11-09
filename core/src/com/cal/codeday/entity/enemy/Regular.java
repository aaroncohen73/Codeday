package com.cal.codeday.entity.enemy;

/**
 * Created by acohen on 11/8/14.
 */
public class Regular extends Person {

    public Regular(){
        super("dummyCharacter02", 32, 32);
        speed = 100;
        health = 50;
        reward = 10;
    }

}
