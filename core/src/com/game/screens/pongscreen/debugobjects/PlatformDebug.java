package com.game.screens.pongscreen.debugobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PlatformDebug {

    public static final float PLATFORM_WIDTH = 83;
    public static final float PLATFORM_HEIGHT = 19;
    public float x;
    public float y;


    private ShapeRenderer.ShapeType type;
    private Color color;

    public PlatformDebug(ShapeRenderer.ShapeType type, Color color) {
        this.type = type;
        this.color = color;
    }

    public void renderPlatformDebug(ShapeRenderer renderer) {
        renderer.begin(type);
        renderer.setColor(color);
        if (!(Gdx.input.getX() - PLATFORM_WIDTH / 2 < 0 || Gdx.input.getX() + PLATFORM_WIDTH / 2 > Gdx.graphics.getWidth() )) {
            x = Gdx.input.getX() - (PLATFORM_WIDTH / 2);
        }
        if (!(Gdx.input.getY() + PLATFORM_HEIGHT / 2 < 0 || Gdx.input.getY() - PLATFORM_HEIGHT / 2 > Gdx.graphics.getHeight() )) {
            y = Gdx.graphics.getHeight() - Gdx.input.getY();
        }
        renderer.rect(x, y, PLATFORM_WIDTH, PLATFORM_HEIGHT);
        renderer.end();
    }
}
