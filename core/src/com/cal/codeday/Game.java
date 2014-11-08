package com.cal.codeday;

import com.cal.codeday.entity.Entity;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Game extends ApplicationAdapter {
    OrthographicCamera camera = new OrthographicCamera();
	SpriteBatch batch;
	Texture img;

    public static float gameTime = 0.0f;
    public static final int gameFPS = 60;

    ArrayList<Entity> entities = new ArrayList<Entity>();

    public void addEntity(Entity e){
        entities.add(e);
    }

	@Override
	public void create () {
        camera.setToOrtho(false, 800, 600);
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
        float deltaTime = Gdx.graphics.getDeltaTime();
        gameTime += deltaTime;
        for(Entity e: entities){
            e.update(deltaTime);
        }

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		for(Entity e : entities){
            e.draw(batch);
        }
		batch.end();
	}
}
