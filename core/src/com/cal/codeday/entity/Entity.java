package com.cal.codeday.entity;

import com.cal.codeday.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;

/**
 * Created by acohen on 11/8/14.
 */
public class Entity {

    protected float width, height;

    protected float xPos, yPos;
    protected float xVel, yVel;

    protected Texture animSheet;
    protected TextureRegion[] animFrames;
    protected int TILE_NUM_WIDTH, TILE_NUM_HEIGHT;
    protected Animation anim;

    protected boolean isHidden = false;

    public Entity(String texPath, int tileWidth, int tileHeight){
        animSheet = new Texture(Gdx.files.internal(texPath));
        width = tileHeight;
        height = tileWidth;
        TILE_NUM_WIDTH = animSheet.getWidth() / tileWidth;
        TILE_NUM_HEIGHT = animSheet.getHeight() / tileHeight;
        TextureRegion[][] temp = TextureRegion.split(animSheet, tileWidth, tileHeight);
        animFrames = new TextureRegion[TILE_NUM_WIDTH * TILE_NUM_HEIGHT];
        for(int x = 0; x < TILE_NUM_WIDTH; x++){
            for(int y = 0; y < TILE_NUM_HEIGHT; y++){
                animFrames[(x % TILE_NUM_WIDTH) + (y * TILE_NUM_HEIGHT)] = temp[x][y];
            }
        }

        anim = new Animation((1.0f / Game.gameFPS), animFrames);
    }

    public float getxPos(){
        return xPos;
    }

    public float getyPos(){
        return yPos;
    }

    public float getWidth(){ return width; }

    public float getHeight() { return height; }

    public boolean isVisible() {return !isHidden;}

    public float getDistance(Entity e){
        return (float) Math.sqrt(Math.pow(e.getxPos() - xPos, 2) + Math.pow(e.getyPos() - yPos, 2));
    }

    public void update(float delta){
        xPos += xVel * delta;
        yPos += yVel * delta;
    }

    public void draw(SpriteBatch batch){
        if(!isHidden) {
            batch.draw(anim.getKeyFrame(Game.gameTime), xPos - (width / 2), yPos - (height / 2), width, height);
        }
    }

    public void dispose(){
        isHidden = true;
        animSheet.dispose();
    }

}
