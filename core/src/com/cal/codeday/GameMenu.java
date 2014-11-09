package com.cal.codeday;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.cal.codeday.entity.Entity;
import com.cal.codeday.entity.enemy.Person;

/**
 * Created by acohen on 11/8/14.
 * The sidebar in-game (Purchase towers, etc.) (Could be called player class, idk)
 */
public class GameMenu {
    Texture menuBG;
    Texture menuStats01;
    Texture menuStats02;
    Texture menuOverlay;
    Texture presentShooter;
    Texture christmasLightShooter;
    Texture candyShooter;
    Texture bottledEggnogLauncher;
    Texture christmasTreeMortar;


    public static int cash = 100; // starting cash
    public static int health = 20;

    public GameMenu(){
        // christmasLightShooter = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuPlayTowerChristmasLightShooter.png"));
        // candyShooter = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuPlayTowerCandyShooter.png"));
        // bottledEggnogLauncher = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuPlayTowerBottledEggnogLauncher.png"));
        // christmasTreeMortar = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuPlayTowerChristmasTreeMortar.png"));

        presentShooter = new Texture(Gdx.files.internal("gfx/spriteFinal/Towers/PresentShooter/presentShooter01.png"));
        menuBG = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuMainBG.png"));
        menuStats01 = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuStats01.png"));
        //menuStats02 = new Texture(Gdx.files.internal("gfx/spriteFinal/menuStatus02.png"));
        menuOverlay = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuOverlay.png"));
    }


    public void draw(SpriteBatch batch) {
        batch.draw(menuBG, 800, 0);
        batch.draw(menuStats01, 805, 100);
        //batch.draw(christmasLightShooter, 825, 400);
        //batch.draw(candyShooter, 825, 400);
        //batch.draw(bottledEggnogLauncher, 825, 400);
        //batch.draw(christmasTreeMortar, 825, 400);
        batch.draw(presentShooter, 825, 400);
        batch.draw(menuOverlay, 800, 0, 200, 600, 0, 0, 200, 600, true, false);
    }

}


