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

    float xPos, yPos;
    float xVel, yVel;

    Texture animSheet;
    TextureRegion[] animFrames;
    int TILE_NUM_WIDTH, TILE_NUM_HEIGHT;
    Animation anim;

    public Entity(String texPath, int tileWidth, int tileHeight){
        animSheet = new Texture(Gdx.files.internal(texPath));
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

    public void update(float delta){

    }

    public void draw(SpriteBatch batch){
        batch.draw(anim.getKeyFrame(Game.gameTime), xPos, yPos);
    }

}
