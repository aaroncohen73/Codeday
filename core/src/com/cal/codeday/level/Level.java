package com.cal.codeday.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.Point;

/**
 * Created by acohen on 11/8/14.
 */
public class Level {

    private Texture levelBackground;

    private Point[] pathPoints;

    public Level(String levelName){
        levelBackground = new Texture(Gdx.files.internal("maps/" + levelName + ".png"));

        String levelPath = Gdx.files.internal("maps/" + levelName + ".path").readString();
        String[] points = levelPath.split("\n");
        pathPoints = new Point[points.length];
        for(int i = 0; i < points.length; i++){
            pathPoints[i] = new Point(Integer.parseInt(points[i].split(",")[0]), Integer.parseInt(points[i].split(",")[1]));
        }
    }

    public void draw(SpriteBatch batch){
        batch.draw(levelBackground, 0, 0, 800, 600);
    }

}
