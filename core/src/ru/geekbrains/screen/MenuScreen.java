package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import ru.geekbrains.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {
    private SpriteBatch batch;
    private Texture baseFon;
    private Texture redMoon;
    private Vector2 positionOfStart = new Vector2();
    private Vector2 positionOfFinish = new Vector2();
    private Vector2 touchPos;


    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        baseFon = new Texture("baseFon.jpg");
        redMoon = new Texture("redMoon.png");
        positionOfStart.set(Gdx.graphics.getHeight() / 2 - 150, Gdx.graphics.getWidth() / 2 + 50);
        positionOfFinish.set(Gdx.graphics.getHeight(), Gdx.graphics.getWidth());
        touchPos = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(baseFon, 0, 0);
        batch.draw(redMoon, positionOfStart.x, positionOfStart.y);
        batch.end();

        if (Gdx.input.isTouched()) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY());
            positionOfStart.x = touchPos.x;
            positionOfStart.y = Gdx.graphics.getHeight() - touchPos.y;
            }
         if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
             positionOfStart.x -= 150 * Gdx.graphics.getDeltaTime();
             if (positionOfStart.x < 0)
                 positionOfStart.x = 0;
         }
         if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            positionOfStart.x += 150 * Gdx.graphics.getDeltaTime();
             if (positionOfStart.x > Gdx.graphics.getWidth()-redMoon.getWidth())
                 positionOfStart.x = Gdx.graphics.getWidth()-redMoon.getWidth();
         }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            positionOfStart.y += 150 * Gdx.graphics.getDeltaTime();
            if (positionOfStart.y > Gdx.graphics.getHeight()-redMoon.getHeight())
                positionOfStart.y = Gdx.graphics.getHeight()-redMoon.getHeight();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            positionOfStart.y -= 150 * Gdx.graphics.getDeltaTime();
            if (positionOfStart.y < 0)
                positionOfStart.y = 0;
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        baseFon.dispose();
        redMoon.dispose();
        super.dispose();
    }
}
