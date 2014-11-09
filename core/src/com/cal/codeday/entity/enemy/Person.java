package com.cal.codeday.entity.enemy;

import com.cal.codeday.entity.Entity;

import java.awt.Point;

/**
 * Created by acohen on 11/8/14.
 */
public class Person extends Entity {

    protected float speed;

    protected Point[] pathPoints;
    protected Point nextPoint;
    protected int nextPointIndex;

    public Person(String texPath, int width, int height){
        super(texPath, width, height);
    }

    public void setPathPoints(Point[] path){
        pathPoints = path;
    }

    public void setDirection(Point finish){
        float dx = finish.x - xPos;
        float dy = finish.y - yPos;
        double theta = Math.atan(dx / dy);
        xVel = speed * (float) Math.cos(theta);
        yVel = speed * (float) Math.sin(theta);
    }

    public void start(Point startLocation){
        xPos = startLocation.x;
        yPos = startLocation.y;
        nextPointIndex = 0;
        nextPoint = pathPoints[nextPointIndex];
        setDirection(nextPoint);
    }

    public void update(float delta){
        super.update(delta);
        if(Math.abs(xPos - nextPoint.x) < 0.1f && Math.abs(yPos - nextPoint.y) < 0.1f){
            if(++nextPointIndex == pathPoints.length){
                destroy();
            }else{
                nextPoint = pathPoints[nextPointIndex];
                setDirection(nextPoint);
            }
        }
    }

}
