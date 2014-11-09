package com.cal.codeday.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cal.codeday.entity.enemy.Kid;
import com.cal.codeday.entity.enemy.Person;
import com.cal.codeday.entity.enemy.Regular;
import com.cal.codeday.entity.enemy.Tank;
import com.cal.codeday.entity.tower.Tower;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Created by acohen on 11/8/14.
 */
public class Level {

    private Texture levelBackground;

    private ArrayList<Person> customers = new ArrayList<Person>();
    private int currentCustomer = 0;

    private ArrayList<Tower> towers = new ArrayList<Tower>();
    private Point[] pathPoints;

    private boolean isStarted = false;
    private float releaseRate = 1; //Towers spawned per second

    public Level(String levelName){
        levelBackground = new Texture(Gdx.files.internal("maps/" + levelName + ".png"));

        String levelPath = Gdx.files.internal("maps/" + levelName + ".path").readString();
        String[] points = levelPath.split("\n");
        pathPoints = new Point[points.length];
        for(int i = 0; i < points.length; i++){
            pathPoints[i] = new Point(Integer.parseInt(points[i].split(",")[0]), Integer.parseInt(points[i].split(",")[1]));
        }

        String[] spawns = Gdx.files.internal("maps/" + levelName + ".spawn").readString().split("\n");
        for(String s : spawns){
            int num = Integer.parseInt(s.substring(1));
            char first = s.charAt(0);
            switch(first){
                case 'k':
                    for(int i = 0; i < num; i++){
                        customers.add(new Kid());
                    }
                    break;

                case 'r':
                    for(int i = 0; i < num; i++){
                        customers.add(new Regular());
                    }
                    break;

                case 't':
                    for(int i = 0; i < num; i++){
                        customers.add(new Tank());
                    }
                    break;

                default:
                    System.out.println("Error: Level script syntax error!");
                    break;
                }
            }
        }
    }

    public void start(){

    }

    public void update(float delta){
        for(Person p : customers){
            p.update(delta);
        }
        for(Tower t : towers){
            t.update(delta);
        }
    }

    public void draw(SpriteBatch batch){
        batch.draw(levelBackground, 0, 0, 800, 600);
    }

    public void dispose(){
        levelBackground.dispose();
    }

}
