package com.cal.codeday;

import com.badlogic.gdx.Screen;
import com.cal.codeday.entity.Entity;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Game extends ApplicationAdapter {

    Screen screen;
    GameScreen gameScreen;

    public static float gameTime = 0.0f;
    public static final float gameFPS = 60;

	@Override
	public void create () {
        gameScreen = new GameScreen();
	}

	@Override
	public void render () {

    }

}
