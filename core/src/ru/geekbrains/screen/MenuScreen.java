package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
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
    private Vector2 positionOfStart;
    private Vector2 directions;




    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        baseFon = new Texture("baseFon.jpg");
        redMoon = new Texture("redMoon.png");
        positionOfStart = new Vector2(20, 100);
        directions = new Vector2(0.5f,0.35f);
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
