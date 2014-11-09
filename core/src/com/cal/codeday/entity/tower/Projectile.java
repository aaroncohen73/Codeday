package com.cal.codeday.entity.tower;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cal.codeday.entity.Entity;
import com.cal.codeday.entity.enemy.Person;

/**
 * Created by acohen on 11/8/14.
 */
public class Projectile extends Entity {

    Tower shooter;
    Person target;

    float shootTime;

    Texture projectileTexture;

    public Projectile(String texPath, int width, int height, Tower shooter, Person target){
        super(texPath, width, height);
        projectileTexture = new Texture(Gdx.files.internal(texPath));
        this.xPos = shooter.getxPos() + 32;
        this.yPos = shooter.getyPos() + 32;
        this.shooter = shooter;
        this.target = target;
        isHidden = false;

        shootTime = (getDistance(target)/600);
        setVelocity();
    }

    public void setVelocity(){
        float dx = (target.getxPos() + (target.getWidth()) / 2) - xPos;
        float dy = (target.getyPos() + (target.getHeight()) / 2) - yPos;
        float distance = (float) Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        xVel = 600 * (dx / distance);
        yVel = 600 * (dy / distance);
    }

    @Override
    public void update(float delta){
        super.update(delta);
        shootTime -= delta;
        if(shootTime <= 0){
            target.isHit(shooter.power);
            dispose();
        }
    }

    @Override
    public void draw(SpriteBatch batch){
        if(!isHidden){
            batch.draw(projectileTexture, xPos - (width / 2), yPos - (height / 2));
        }
    }

}
