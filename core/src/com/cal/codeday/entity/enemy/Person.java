package com.cal.codeday.entity.enemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cal.codeday.Game;
import com.cal.codeday.GameMenu;
import com.cal.codeday.entity.Entity;

import java.awt.Point;

/**
 * Created by acohen on 11/8/14.
 */
public class Person extends Entity {

    protected float speed;
    protected float health;
    protected float reward;

    protected Point[] pathPoints;
    protected Point nextPoint;
    protected int nextPointIndex;

    Texture tex;

    public Person(String texPath, int width, int height){
        super("gfx/customers/" + texPath + ".png", width, height);
        tex = new Texture(Gdx.files.internal("gfx/customers/" + texPath + ".png"));

        isHidden = true;
    }

    public void show(){
        isHidden = false;
    }

    public void hide(){
        isHidden = true;
    }

    public void setPathPoints(Point[] path){
        pathPoints = path;
    }

    public float getHealth() { return health; }

    public void setDirection(Point finish){
        float dx = finish.x - xPos;
        float dy = finish.y - yPos;
        double theta =Math.atan(dy / dx);
        xVel = ((dx < 0)?-1:1) * speed * (float) Math.cos(theta);
        yVel = speed * (float) Math.sin(theta);
    }

    public void start(){
        xPos = pathPoints[0].x;
        yPos = pathPoints[0].y;
        nextPointIndex = 1;
        nextPoint = pathPoints[nextPointIndex];
        setDirection(nextPoint);
    }

    public void isHit(float damage){
        health -= damage;
        if(health <= 0 && !isHidden){
            isHidden = true;
            GameMenu.money += reward;
        }
    }

    public void update(float delta){
        if(isHidden) return;

        super.update(delta);
        if(Math.abs(xPos - nextPoint.x) < 5f && Math.abs(yPos - nextPoint.y) < 5f){
            if(++nextPointIndex == pathPoints.length){
                GameMenu.health--;
                dispose();
                hide();
            }else{
                xPos = nextPoint.x;
                yPos = nextPoint.y;
                nextPoint = pathPoints[nextPointIndex];
                setDirection(nextPoint);
            }
        }
    }

    @Override
    public void draw(SpriteBatch batch){
        if(!isHidden) {
            batch.draw(tex, xPos - (width / 2), yPos - (height / 2), width, height);
        }
    }

}
