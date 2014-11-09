package com.cal.codeday;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cal.codeday.level.Level;

/**
 * Created by Owner on 11/9/2014.
 */
public class MainScreen implements Screen {
    OrthographicCamera camera;
    SpriteBatch batch;

    public MainScreen(){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1000, 600); //Game is 800x600, menu on side is 200x600
        batch = new SpriteBatch();
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

    }

    public void dispose(){
        batch.dispose();
    }

}
