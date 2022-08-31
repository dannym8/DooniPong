package com.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.screens.menuscreen.MainMenuScreen;

public class DooniPong extends Game {

    public SpriteBatch batch;
    public BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont(); // Arial font by default
        this.setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render() {
        super.render(); // Important!
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
