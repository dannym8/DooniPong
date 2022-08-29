package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static com.game.Platform.PLATFORM_HEIGHT;
import static com.game.Platform.PLATFORM_WIDTH;

public class Ball {

    private float x;
    private float y;
    private float radius;
    private float xSpeed;
    private float ySpeed;
    private Color color;

    public Ball(float x, float y, float radius, float xSpeed, float ySpeed, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.color = color;
    }

    public void updatePos() {
        x += xSpeed;
        y += ySpeed;
        if ( x - radius < 0 || x + radius > Gdx.graphics.getWidth()) {
            xSpeed = -xSpeed;
        }
        if ( y + radius > Gdx.graphics.getHeight()) {
            ySpeed = -ySpeed;
        }
        if ( y - radius < 0) {
            y = (float) Gdx.graphics.getHeight()/2;
            x = (float) Gdx.graphics.getWidth()/2;
        }
    }

    public void checkCollision(Platform platform) {
        if (collidesWith(platform)) {
            color = Color.GOLD;
            ySpeed = -ySpeed;
        } else {
            color = Color.WHITE;
        }
    }

    public boolean collidesWith(Platform platform) {
        if (y + radius >= platform.y && y - radius <= platform.y + PLATFORM_HEIGHT) {
            if (x - radius <= platform.x + PLATFORM_WIDTH && x + radius >= platform.x) {
                if (x - radius < platform.x || x + radius > platform.x + PLATFORM_WIDTH) {
                    xSpeed = -xSpeed;
                }
                return true;
            }
        }
        return false;
    }

    public void checkCollision(Tile tile) {
        if (collidesWith(tile)) {
            color = Color.GOLD;
            ySpeed = -ySpeed;
            tile.destroyed = true;
        } else {
            color = Color.WHITE;
        }
    }

    int counter = 0;
    public boolean collidesWith(Tile tile) {
        counter++;
        if (counter >= 20) {
            if (y + radius >= tile.y && y - radius <= tile.y + tile.height) {
                if (x - radius <= tile.x + tile.width && x + radius >= tile.x) {
                    if (x - radius < tile.x || x + radius > tile.x + tile.height) {
                        xSpeed = -xSpeed;
                    }
                    counter = 0;
                    return true;
                }
            }
        }
        return false;
    }


    public void renderBall(ShapeRenderer renderer) {
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(color);
        renderer.circle(x,y,radius);
        renderer.end();
    }

}
