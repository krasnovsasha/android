package ru.geekbrains.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.math.MatrixUtils;
import ru.geekbrains.math.Rect;

public class Base2DScreen implements Screen, InputProcessor {
    /*
     * screenBounds -границы области рисования в пикселях
     * worldBounds - границы проекции мировых координат;высота фикс ,ширина плавающая, точка 0.0 посередине экрана
     * glBounds - границы проекции мира в OpenGL
     * worldToGl - матрица проекции для batch
     * screenToWorld - матрица преобразования системы событий
     * */
    private Rect screenBounds;
    private Rect worldBounds;
    private Rect glBounds;
    protected Matrix4 worldToGl;
    protected Matrix3 screenToWorld;
    protected SpriteBatch batch;
    private Vector2 touchPos;

    @Override
    public void show() {
        System.out.println("show");
        this.batch = new SpriteBatch();
        Gdx.input.setInputProcessor(this);
        this.screenBounds = new Rect();
        this.worldBounds = new Rect();
        this.glBounds = new Rect(0, 0, 1f, 1f);
        this.worldToGl = new Matrix4();
        this.screenToWorld = new Matrix3();
        this.touchPos = new Vector2();

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        System.out.println("resize width: " + width + " resize height: " + height);
        screenBounds.setSize(width, height);
        screenBounds.setLeft(0);
        screenBounds.setBottom(0);
        float aspect = width / (float) height;
        worldBounds.setHeight(42f);
        worldBounds.setWidth(42f * aspect);
        MatrixUtils.calcTransitionMatrix(worldToGl, worldBounds, glBounds);
        batch.setProjectionMatrix(worldToGl);
        MatrixUtils.calcTransitionMatrix(screenToWorld, screenBounds, worldBounds);


    }

    @Override
    public void pause() {
        System.out.println("pause");

    }

    @Override
    public void resume() {
        System.out.println("resume");

    }

    @Override
    public void hide() {
        System.out.println("hide");
        dispose();

    }

    @Override
    public void dispose() {
        batch.dispose();
        System.out.println("dispose");

    }

    @Override
    public boolean keyDown(int keycode) {
        System.out.println("keyDown keyCode " + keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        System.out.println("keyUp keyCode " + keycode);
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        System.out.println("keyTyped character " + character);
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touchPos.set(screenX, screenBounds.getHeight() - screenY).mul(screenToWorld);
        touchDown(touchPos, pointer);
        return false;
    }

    public boolean touchDown(Vector2 touchPos, int pointer) {
        System.out.println("touchDown: " + "X " + touchPos.x + "Y " + touchPos.y);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        touchPos.set(screenX, screenBounds.getHeight() - screenY).mul(screenToWorld);
        touchUp(touchPos, pointer);
        return false;
    }
    public boolean touchUp(Vector2 touchPos, int pointer) {
        System.out.println("touchUp: " + "x " + touchPos.x + "y " + touchPos.y);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        System.out.println("touchDragged: " + " screenX " + screenX + " screenY " + screenY);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
