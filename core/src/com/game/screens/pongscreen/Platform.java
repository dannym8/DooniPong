package com.game.screens.pongscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Platform {

    public static final float PLATFORM_WIDTH = 83;
    public static final float PLATFORM_HEIGHT = 19;
    public float x;
    public float y;

    private final ShapeRenderer.ShapeType type;
    private final Color color;

    public Platform(ShapeRenderer.ShapeType type, Color color) {
        this.type = type;
        this.color = color;
        x = Gdx.graphics.getWidth()/2f;
    }
    public void renderPlatformHardMode(ShapeRenderer renderer) {
        Gdx.input.setCursorPosition(0, 0);
        System.out.println(Gdx.input.getX());
        renderer.begin(type);
        renderer.setColor(color);
        // right side
        if (!(x + PLATFORM_WIDTH > Gdx.graphics.getWidth() - 2)) {
            if (Gdx.input.getX() < 300) x += Gdx.input.getX() * 0.1;
        } else {
            x = Gdx.graphics.getWidth() - PLATFORM_WIDTH - 2;
        }
        // left side
        if (!(x < 2)) {
            if (Gdx.input.getX() < 300) x += Gdx.input.getX() * 0.1;
        } else {
            x = 2;
    }
        y = 20;
        renderer.rect(x, y, PLATFORM_WIDTH, PLATFORM_HEIGHT);
        renderer.end();
    }
    public void renderPlatformEasyMode(ShapeRenderer renderer) {
        renderer.begin(type);
        renderer.setColor(color);
        if (!(Gdx.input.getX() - PLATFORM_WIDTH / 2 < 0 || Gdx.input.getX() + PLATFORM_WIDTH / 2 > Gdx.graphics.getWidth())) {
            x = Gdx.input.getX() - (PLATFORM_WIDTH / 2);
        }
        y =  20;
        renderer.rect(x, y, PLATFORM_WIDTH, PLATFORM_HEIGHT);
        renderer.end();
    }
}
