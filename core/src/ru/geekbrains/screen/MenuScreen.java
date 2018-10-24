package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {
    private SpriteBatch batch;
    private Texture baseFon;
    private Texture redMoon;
    private Vector2 positionOfStart = new Vector2();
    private Vector2 positionOfFinish = new Vector2();
    private Vector2 directions = new Vector2();




    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        baseFon = new Texture("baseFon.jpg");
        redMoon = new Texture("redMoon.png");
        positionOfStart.set(Gdx.graphics.getHeight()/2-150,Gdx.graphics.getWidth()/2+50);
        positionOfFinish.set(Gdx.graphics.getHeight(),Gdx.graphics.getWidth());
        directions.set(positionOfFinish.sub(positionOfStart).nor());
        }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(baseFon, 0, 0);
        batch.draw(redMoon,positionOfStart.x, positionOfStart.y);
        batch.end();
        positionOfStart.add(directions);
        }

    @Override
    public void dispose() {
        batch.dispose();
        baseFon.dispose();
        redMoon.dispose();
        super.dispose();
    }
}
