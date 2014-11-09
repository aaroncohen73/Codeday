package com.cal.codeday.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cal.codeday.entity.Entity;
import com.cal.codeday.entity.enemy.Kid;
import com.cal.codeday.entity.enemy.Person;
import com.cal.codeday.entity.enemy.Regular;
import com.cal.codeday.entity.enemy.Tank;
import com.cal.codeday.entity.tower.PresentShooter;
import com.cal.codeday.entity.tower.Tower;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Created by acohen on 11/8/14.
 */
public class Level {

    private static Music sadViolin = Gdx.audio.newMusic(Gdx.files.internal("music/SadViolin.mp3"));

    private Texture levelBackground;
    private Music levelMusic;
    private Texture kiosk = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/kiosk.png"));

    public ArrayList<Person> customers = new ArrayList<Person>();
    private int currentCustomer = 0;

    public ArrayList<Tower> towers = new ArrayList<Tower>();
    private Point[] pathPoints;

    private boolean isStarted = false;
    private float releaseRate = 1; //Towers spawned per second
    private float releaseTimer = 0;

    public Level(String levelName) {
        levelBackground = new Texture(Gdx.files.internal("gfx/spriteFinal/Decor/levels/" + levelName + ".png"));
        levelMusic = Gdx.audio.newMusic(Gdx.files.internal("music/backGroundMusic.mp3"));

        String levelPath = Gdx.files.internal("gfx/spriteFinal/Decor/levels/" + levelName + ".path").readString();
        String[] points = levelPath.split("\n");
        pathPoints = new Point[points.length];
        for (int i = 0; i < points.length; i++){
            pathPoints[i] = new Point(Integer.parseInt(points[i].split(",")[0]), Integer.parseInt(points[i].split(",")[1]));
        }

        String[] spawns = Gdx.files.internal("gfx/spriteFinal/Decor/levels/" + levelName + ".spawn").readString().split("\n");
        for (String s : spawns) {
            int num = Integer.parseInt(s.substring(1));
            char first = s.charAt(0);
            switch (first) {
                case 'k':
                    for (int i = 0; i < num; i++) {
                        customers.add(new Kid());
                    }
                    break;

                case 'r':
                    for (int i = 0; i < num; i++) {
                        customers.add(new Regular());
                    }
                    break;

                case 't':
                    for (int i = 0; i < num; i++) {
                        customers.add(new Tank());
                    }
                    break;

                default:
                    System.out.println("Error: Level script syntax error!");
                    break;
            }
        }

        levelMusic.setLooping(true);
        levelMusic.play();

        //towers.add(new PresentShooter(this));
    }

    public ArrayList<Person> getCustomers(){
        ArrayList<Person> visible = new ArrayList<Person>();
        for(Person p : customers){
            if(p.isVisible()){
                visible.add(p);
            }
        }

        return visible;
    }

    public void start(){
        if(towers.size() == 0){
            System.out.println("Are you sure? You have no towers out!");
            //return;
        }

        isStarted = true;
    }

    public void end(boolean failed){
       levelMusic.stop();
        if(failed){
            levelMusic = sadViolin;
            levelMusic.play();
        }else{

        }
    }

    public void update(float delta){
        if(!isStarted) return;

        releaseTimer += delta;
        if(releaseTimer >= (1 / releaseRate)){
            if(currentCustomer == customers.size()){

            }else {
                releaseTimer = 0;
                customers.get(currentCustomer).show();
                customers.get(currentCustomer).setPathPoints(pathPoints);
                customers.get(currentCustomer).start();
                currentCustomer++;
            }
        }

        for(Person p : customers){
            p.update(delta);
        }
        for(Tower t : towers){
            t.update(delta);
        }
    }

    public void draw(SpriteBatch batch){
        batch.draw(levelBackground, 0, 0, 800, 600);

        for(Person p : customers){
            p.draw(batch);
        }

        batch.draw(kiosk, 720, 80);

        for(Tower t : towers){
            t.draw(batch);
        }
    }

    public void dispose(){
        for(Person p : customers){
            p.dispose();
        }

        for(Tower t : towers){
            t.dispose();
        }

        levelBackground.dispose();
    }

}
