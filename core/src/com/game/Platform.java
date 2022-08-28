package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static com.game.PongGame.PLATFORM_HEIGHT;
import static com.game.PongGame.PLATFORM_WIDTH;

public class Platform {

    ShapeRenderer.ShapeType type;
    Color color;

    public Platform(ShapeRenderer.ShapeType type, Color color) {
        this.type = type;
        this.color = color;
    }

    public void renderPlatform(ShapeRenderer renderer) {
        renderer.begin(type);
        renderer.setColor(color);
        int mouseX = Gdx.input.getX();
        renderer.rect(mouseX - (PLATFORM_WIDTH/2), 20, PLATFORM_WIDTH, PLATFORM_HEIGHT);
        renderer.end();
    }
}
