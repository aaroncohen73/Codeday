package com.cal.codeday;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cal.codeday.entity.Entity;
import com.cal.codeday.level.Level;

import java.util.ArrayList;

/**
 * Created by acohen on 11/8/14.
 */
public class GameScreen implements Screen {

    OrthographicCamera camera;
    SpriteBatch batch;

    Level currentLevel;

    public GameScreen(){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1000, 600); //Game is 800x600, menu on side is 200x600
        batch = new SpriteBatch();
        currentLevel = new Level("SampleLayout");
        currentLevel.start();
    }

    public void show(){

    }

    public void hide(){

    }

    public void resize(int x, int y){
        //Cannot resize
    }

    public void pause(){

    }

    public void resume(){

    }

    public void render(float delta){
        Game.gameTime += delta;
        currentLevel.update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        currentLevel.draw(batch);
        batch.end();
    }

    public void dispose(){
        currentLevel.dispose();
        batch.dispose();
    }

}
