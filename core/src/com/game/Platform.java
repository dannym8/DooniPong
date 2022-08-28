package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Platform {

    public static final float PLATFORM_WIDTH = 83;
    public static final float PLATFORM_HEIGHT = 19;
    public float x;
    public float y;


    private ShapeRenderer.ShapeType type;
    private Color color;

    public Platform(ShapeRenderer.ShapeType type, Color color) {
        this.type = type;
        this.color = color;
    }

    public void renderPlatform(ShapeRenderer renderer) {
        renderer.begin(type);
        renderer.setColor(color);
        if (!(Gdx.input.getX() - PLATFORM_WIDTH / 2 < 0 || Gdx.input.getX() + PLATFORM_WIDTH / 2 > Gdx.graphics.getWidth() )) {
            x = Gdx.input.getX() - (PLATFORM_WIDTH / 2);
        }
        y =  20;
        renderer.rect(x, y, PLATFORM_WIDTH, PLATFORM_HEIGHT);
        renderer.end();
    }
}
