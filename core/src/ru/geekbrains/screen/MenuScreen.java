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
    private Texture baseFon;
    private Texture redMoon;
    private Vector2 positionOfStart = new Vector2();
    private Vector2 positionOfFinish = new Vector2();
    private Vector2 touchPos = new Vector2();
    private Vector2 buffer = new Vector2();


    @Override
    public void show() {
        super.show();
        baseFon = new Texture("baseFon.jpg");
        redMoon = new Texture("redMoon.png");
        positionOfStart.set(-20f,10f);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        buffer.set(touchPos);
        if (buffer.sub(positionOfStart).len() > positionOfFinish.len()) {
            positionOfStart.add(positionOfFinish);
        } else {
            positionOfStart.set(touchPos);
        }
        batch.begin();
        batch.draw(baseFon,-42f,-21f,84f,42f);
        batch.draw(redMoon,positionOfStart.x,positionOfStart.y,2.5f,2.5f);
        batch.end();
    }

    @Override
    public boolean touchDown(Vector2 touchPos, int pointer) {
        this.touchPos = touchPos;
        positionOfFinish.set(touchPos.cpy().sub(positionOfStart).scl(0.01f));
        return false;
    }

    @Override
    public void dispose() {
        baseFon.dispose();
        redMoon.dispose();
        super.dispose();
    }
}
