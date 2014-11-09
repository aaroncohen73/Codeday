package com.cal.codeday;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.ApplicationAdapter;

public class Game extends ApplicationAdapter {

    Screen screen;
    MainScreen mainMenu;
    public static GameScreen gameScreen;

    public static float gameTime = 0.0f;
    public static final float gameFPS = 60;

	@Override
	public void create () {
        gameScreen = new GameScreen();
        mainMenu = new MainScreen();
        screen = gameScreen;
	}

	@Override
	public void render () {
        screen.render(Gdx.graphics.getDeltaTime());
    }

}
