package com.game.screens.menuscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.game.screens.DooniPong;
import com.game.screens.pongscreen.PongScreen;

public class MainMenuScreen implements Screen {

    final DooniPong game;

    OrthographicCamera camera;

    public MainMenuScreen(final DooniPong game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false,1100,650);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0.2f,1);
        
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "Welcome to DooniPong!! ", 100, 200);
        game.font.draw(game.batch, "Press 'SPACE' to begin playing HARD MODE!", 100, 100);
        game.font.draw(game.batch, "Press 'LEFT MOUSE' to begin playing EASY MODE!", 100, 150);
        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            game.setScreen(new PongScreen(game,true));
            dispose();
        }
        else if (Gdx.input.isTouched()) {
            game.setScreen(new PongScreen(game,false));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
