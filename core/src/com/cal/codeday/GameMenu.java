package com.cal.codeday;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
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

    Button presentShooter;
    Button christmasLightShooter;
    Button candyShooter;
    Button bottledEggnogLauncher;
    Button christmasTreeMortar;

    Rectangle towerScroll;
    Rectangle turretScrollDragBox;
    Texture turretScrollBase;
    Texture turretScrollDrag;
    float scrollValue = 50.0f;

    public static int money = 100;
    public static int health = 20;

    public GameMenu(){
       christmasLightShooter = new Button("gfx/spriteFinal/Towers/PresentShooter/presentShooter01.png", false, 825 + 256, 400, 64, 64);
       candyShooter = new Button("gfx/spriteFinal/Towers/PresentShooter/presentShooter01.png", false, 825 + 196, 400, 64, 64);
       bottledEggnogLauncher = new Button("gfx/spriteFinal/Towers/PresentShooter/presentShooter01.png", false, 825 + 128, 400, 64, 64);
       christmasTreeMortar = new Button("gfx/spriteFinal/Towers/PresentShooter/presentShooter01.png", false, 825 + 64, 400, 64, 64);
        presentShooter = new Button("gfx/spriteFinal/Towers/PresentShooter/presentShooter01.png", false, 825, 400, 64, 64);

        menuBG = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuPlayBG.png"));
        menuStats01 = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuStats01.png"));
        //menuStats02 = new Texture(Gdx.files.internal("gfx/spriteFinal/menuStatus02.png"));
        menuOverlay = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuPlayOverlay.png"));

        towerScroll = new Rectangle(825, 400, 150, 64);
        turretScrollDragBox = new Rectangle(825, 360, 32, 40);

        turretScrollBase = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuTurretScrollBase.png"));
        turretScrollDrag = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuPlayScrollDrag.png"));

    }

    public void pollInput(){
        float mX = Gdx.input.getX();
        float mY = 600 - Gdx.input.getY();
    }

    public void draw(SpriteBatch batch) {
        pollInput();

        batch.draw(menuBG, 800, 0);
        batch.draw(menuStats01, 805, 100);
        Rectangle scissors = new Rectangle();
        ScissorStack.calculateScissors(GameScreen.camera, batch.getTransformMatrix(), towerScroll, scissors);
        ScissorStack.pushScissors(scissors);
        christmasLightShooter.draw(batch);
        candyShooter.draw(batch);
        bottledEggnogLauncher.draw(batch);
        christmasTreeMortar.draw(batch);
        presentShooter.draw(batch);
        batch.flush();
        ScissorStack.popScissors();
        batch.draw(turretScrollBase, 825, 370, 150, 20);
        batch.draw(turretScrollDrag, 825 + scrollValue, 360, 32, 40);
        batch.draw(menuOverlay, 800, 0, 200, 600, 0, 0, 200, 600, true, false);
    }

}


