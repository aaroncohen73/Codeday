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
    Button credits;
    Button help;
    Button play;

    public MainScreen(){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1000, 600); //Game is 800x600, menu on side is 200x600
        batch = new SpriteBatch();
        mainBG = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuMainBG.png"));
        options = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/buttonOptions.png"));
        credits = new Button("gfx/spriteFinal/Menu/menuMainButtonCredits", true, 400, 100, 300, 116);
        help = new Button("gfx/spriteFinal/Menu/menuMainButtonHelp", true, 400, 250, 300, 116);
        play = new Button("gfx/spriteFinal/Menu/menuMainButtonPlay", true, 400, 400, 300, 116);
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

    public void pollInput(){
        float mX = Gdx.input.getX();
        float mY = 600 - Gdx.input.getY();
        if(credits.click(mX, mY)){

        }
        if(help.click(mX, mY)){

        }
        if(play.click(mX, mY)){
            Game.screen = Game.gameScreen;
        }
    }

    public void render(float delta){
        pollInput();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(mainBG, 0, 0);
        batch.draw(options, 400, 100);
        credits.draw(batch);
        help.draw(batch);
        play.draw(batch);

        batch.end();
    }

    public void dispose(){
        batch.dispose();
    }

}
