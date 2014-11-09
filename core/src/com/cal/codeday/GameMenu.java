package com.cal.codeday;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.cal.codeday.entity.Entity;
import com.cal.codeday.entity.enemy.Person;
import com.cal.codeday.entity.tower.BottledEggnogLauncher;
import com.cal.codeday.entity.tower.CandyShooter;
import com.cal.codeday.entity.tower.PresentShooter;

/**
 * Created by acohen on 11/8/14.
 * The sidebar in-game (Purchase towers, etc.) (Could be called player class, idk)
 */
public class GameMenu {

    BitmapFont font = new BitmapFont(Gdx.files.internal("font/Minecraftia-Regular-32.fnt"));

    Texture menuBG;
    Texture menuStats01;
    Texture menuStats02;
    Texture menuOverlay;
    Texture menuCoin;
    Texture menuHealth;

    Button presentShooter;
    Button christmasLightShooter;
    Button candyShooter;
    Button bottledEggnogLauncher;
    Button christmasTreeMortar;

    Rectangle towerScroll;
    Texture turretScrollBase;
    Button turretScrollDrag;
    float scrollValue = 0.0f;

    Button playButton;

    public static int money = 500;
    public static int health = 20;

    int state = 0;

    public GameMenu(){
        christmasLightShooter = new Button("gfx/spriteFinal/Towers/PresentShooter/presentShooter01.png", false, 825 + 256, 400, 64, 64);
        candyShooter = new Button("gfx/spriteFinal/Towers/CandyShooter/towerCandyShooter01.png", false, 825 + 196, 400, 64, 64);
        bottledEggnogLauncher = new Button("gfx/spriteFinal/Towers/NogLauncher/noglauncher01.png", false, 825 + 128, 400, 64, 64);
        christmasTreeMortar = new Button("gfx/spriteFinal/Towers/PresentShooter/presentShooter01.png", false, 825 + 64, 400, 64, 64);
        presentShooter = new Button("gfx/spriteFinal/Towers/PresentShooter/presentShooter01.png", false, 825, 400, 64, 64);

        menuBG = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuPlayBG.png"));
        menuStats01 = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuStats01.png"));
        //menuStats02 = new Texture(Gdx.files.internal("gfx/spriteFinal/menuStatus02.png"));
        menuOverlay = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuPlayOverlay.png"));
        menuCoin = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuPlayMoney.png"));
        menuHealth = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuPlayHealth.png"));

        towerScroll = new Rectangle(825, 400, 150, 64);

        turretScrollBase = new Texture(Gdx.files.internal("gfx/spriteFinal/Menu/menuTurretScrollBase.png"));
        turretScrollDrag = new Button("gfx/spriteFinal/Menu/menuPlayScrollDrag.png", false, 825, 360, 32, 40);

        playButton = new Button("gfx/spriteFinal/Menu/menuPlay.png", false, 868, 100, 64 ,64);
    }

    public void pollInput() {
        float mX = Gdx.input.getX();
        float mY = 600 - Gdx.input.getY();
        if (presentShooter.click(mX, mY)) {
            state = 1; //Place present shooter
        }
        if (turretScrollDrag.click(mX, mY)) {
            turretScrollDrag.move(Math.max(Math.min(mX - 16, 945), 825), 360);
            scrollValue = turretScrollDrag.x - 825;
        }

        if (state == 1) {
            if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT) && money >= 50) {
                money -= 50;
                state = 0;
                Game.gameScreen.currentLevel.towers.add(new PresentShooter(Game.gameScreen.currentLevel, mX, mY));
            }
        }
        if (candyShooter.click(mX, mY)) {
            state = 2; // place candy shooter
        }
        if (state == 2) {
            if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT) && money >= 100) {
                money -= 100;
                state = 0;
                Game.gameScreen.currentLevel.towers.add(new CandyShooter(Game.gameScreen.currentLevel, mX, mY));
            }
        }
        if (bottledEggnogLauncher.click(mX, mY)) {
            state = 3; // place nog shooter
        }
        if (state == 3) {
            if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT) && money >= 250) {
                money -= 250;
                state = 0;
                Game.gameScreen.currentLevel.towers.add(new BottledEggnogLauncher(Game.gameScreen.currentLevel, mX, mY));
            }
        }
        if(playButton.click(mX, mY)){
            Game.gameScreen.currentLevel.start();
        }
    }



    public void update(){
        bottledEggnogLauncher.move(825 + 128 - scrollValue, 400);
        candyShooter.move(825 + 64 - scrollValue, 400);
        presentShooter.move(825 - scrollValue, 400);
    }

    public void draw(SpriteBatch batch) {
        pollInput();

        update();

        batch.draw(menuBG, 800, 0);
        batch.draw(menuStats01, 805, 100);
        Rectangle scissors = new Rectangle();
        ScissorStack.calculateScissors(GameScreen.camera, batch.getTransformMatrix(), towerScroll, scissors);
        ScissorStack.pushScissors(scissors);
        presentShooter.draw(batch);
        candyShooter.draw(batch);
        bottledEggnogLauncher.draw(batch);
        batch.flush();
        ScissorStack.popScissors();
        font.draw(batch, "TOWERS:", 830, 500);
        batch.draw(turretScrollBase, 825, 370, 150, 20);
        turretScrollDrag.draw(batch);
        batch.draw(menuHealth, 800, 275, 102, 64);
        font.draw(batch, Integer.toString(health), 900, 295);
        batch.draw(menuCoin, 800, 175, 102, 64);
        font.draw(batch, Integer.toString(money), 900, 200);
        playButton.draw(batch);
        batch.draw(menuOverlay, 800, 0, 200, 600, 0, 0, 200, 600, true, false);
    }

}


