package com.cal.codeday.entity.tower;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cal.codeday.entity.Entity;
import com.cal.codeday.entity.enemy.Person;
import com.cal.codeday.level.Level;

import java.util.ArrayList;

/**
 * Created by acohen&dhaley on 11/8/14.
 */
public class Tower extends Entity {

    private Level currentLevel;

    protected int level = 1; //Tower level
    protected float range; //Range of the tower
    protected float power; //Satisfaction it provides
    //int piercing; //Number of enemies it can go through
    protected float AOE; //Area of Effect on landing
    protected float fire_rate = 0; // How fast the tower can shoot
    protected int cost = 0; // Cost of the tower
    protected float slow = 0; // The amount the target is slowed when shot

    protected float shootTimer = 0;

    Person currentTarget = null;
    Texture currentState;
    Texture[] states = new Texture[16];

    String projectileTexture = "gfx/spriteFinal/Towers/PresentShooter/projectileCandyYellow01.png";
    ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

    public void levelUp(){
        level += 1;
    }

    public Tower(String texPath, int size2, Level currentLevel){
        super(texPath + "01.png", size2, size2);
        for(int i = 1; i < 10; i++){
            states[i - 1] = new Texture(Gdx.files.internal(texPath + "0" + i + ".png"));
        }
        for(int i = 10; i < 17; i++){
            states[i - 1] = new Texture(Gdx.files.internal(texPath + i + ".png"));
        }
        this.currentLevel = currentLevel;
        currentState = states[0];
    }

    @Override
    public void update(float delta){
        ArrayList<Projectile> toRemove = new ArrayList<Projectile>();
        for(Projectile p : projectiles){
            if(p.isVisible()) {
                p.update(delta);
            }else{
                toRemove.add(p);
            }
        }

        for(Projectile p : toRemove){
            projectiles.remove(p);
        }
        toRemove.clear();

        if(acquireTarget()) {
            shootTimer += delta;
            if (shootTimer >= 1 / fire_rate) {
                shootTimer = 0;
                projectiles.add(new Projectile(projectileTexture, 64, 64, this, currentTarget));
            }
        }
    }

    @Override
    public void draw(SpriteBatch batch){
        for(Projectile p : projectiles){
            p.draw(batch);
        }

        batch.draw(currentState, xPos - (width / 2), yPos - (height / 2), width, height);
    }

    public boolean acquireTarget(){
        ArrayList<Person> people = currentLevel.getCustomers();
        if(people.size() == 0) return false;
        Person closest = people.get(0);
        float closestDistance = getDistance(closest);
        for(Person p : people){
            if(getDistance(p) < closestDistance){
                closest = p;
                closestDistance = getDistance(p);
            }
        }
        if(closestDistance > range) return false;

        currentTarget = closest;

        //Find angle, do integer division by 45
        float dx = closest.getxPos() - xPos;
        float dy = closest.getyPos() - yPos;
        double theta = Math.toDegrees(Math.atan(dy / dx)) + ((dx < 0)?180:0);
        int state = (int) Math.floor(theta / 22.5);
        currentState = states[((state + 4) %  16)];

        return true;
    }

}
