package com.cal.codeday.entity.enemy;

import com.cal.codeday.entity.Entity;

import java.awt.Point;

/**
 * Created by acohen on 11/8/14.
 */
public class Person extends Entity {

    public static int health = 20;

    protected float speed;

    protected Point[] pathPoints;
    protected Point nextPoint;
    protected int nextPointIndex;

    public Person(String texPath, int width, int height){
        super("gfx/customers/" + texPath + ".png", width, height);
        isHidden = true;
        width = 64;
        height = 64;
    }

    public void show(){
        isHidden = false;
    }

    public void hide(){
        isHidden = true;
    }

    public boolean isVisible() {return isHidden;}

    public void setPathPoints(Point[] path){
        pathPoints = path;
    }

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

    public void update(float delta){
        if(isHidden) return;

        super.update(delta);
        if(Math.abs(xPos - nextPoint.x) < 5f && Math.abs(yPos - nextPoint.y) < 5f){
            if(++nextPointIndex == pathPoints.length){
                Person.health--;
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

}
