package ru.geekbrains;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StarGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture baseFon;
	Texture redMoon;

	@Override
	public void create () {
		batch = new SpriteBatch();
		baseFon = new Texture("baseFon.jpg");
		redMoon = new Texture("redMoon.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(baseFon, 0, 0);
		batch.draw(redMoon, 100, 350);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		baseFon.dispose();
		redMoon.dispose();
	}
}

