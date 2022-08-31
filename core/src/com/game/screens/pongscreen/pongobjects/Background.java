package com.game.screens.pongscreen.pongobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background {
    int x;
    int y;
    Texture texture;

    public Background (int x, int y, Texture texture) {
        this.x = x;
        this.y = y;
        this.texture = texture;
    }

    public void renderBackground(SpriteBatch batch) {
        batch.begin();
        batch.draw(texture, 0, 0);
        batch.end();
    }
}
