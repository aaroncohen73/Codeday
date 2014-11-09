package com.cal.codeday;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cal.codeday.level.Level;

/**
 * Created by Owner on 11/9/2014.
 */
public class MainScreen implements Screen {
    OrthographicCamera camera;
    SpriteBatch batch;
    Texture mainBG;
    Texture options;
    Texture credits01;
    Texture credits02;
    Texture credits03;
    Texture help01;
    Texture help02;
    Texture help03;
    Texture play01;
    Texture play02;
    Texture play03;


    public MainScreen(){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1000, 600); //Game is 800x600, menu on side is 200x600
        batch = new SpriteBatch();
        mainBG = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuMainBG.png"));
        options = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/buttonOptions.png"));
        credits01 = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuMainButtonCredits01.png"));
        credits02 = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuMainButtonCredits01.png"));
        credits03 = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuMainButtonCredits01.png"));
        help01 = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuMainButtonHelp01.png"));
        help02 = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuMainButtonHelp02.png"));
        help03 = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuMainButtonHelp03.png"));
        play01 = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuMainButtonPlay01.png"));
        play02 = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuMainButtonPlay02.png"));
        play03 = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuMainButtonPlay03.png"));
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
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(mainBG, 0, 0);
        batch.draw(options, 400, 100);
        batch.draw(credits01, 400, 100);
        batch.draw(credits02, 400, 100);
        batch.draw(credits03, 400, 100);
        batch.draw(help01, 400, 250);
        batch.draw(help02, 400, 250);
        batch.draw(help03, 400, 250);
        batch.draw(play01, 400, 400);
        batch.draw(play02, 400, 400);
        batch.draw(play03, 400, 400);

        batch.end();
    }

    public void dispose(){
        batch.dispose();
    }

}
