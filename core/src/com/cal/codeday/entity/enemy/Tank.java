package com.cal.codeday.entity.enemy;

/**
 * Created by acohen on 11/8/14.
 */
public class Tank extends Person {

    public Tank(){
        super("dummyCharacter03", 32, 32);
        speed = 50;
        health = 200;
        reward = 25;
    }

}
