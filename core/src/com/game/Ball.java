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
            System.out.println("bounce");
        } else {
            color = Color.WHITE;
        }
    }

    public boolean collidesWith(Platform platform) {
        if (y - radius <= platform.y + PLATFORM_HEIGHT) {
            if (x - radius <= platform.x + PLATFORM_WIDTH && x + radius >= platform.x) {
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
            System.out.println("hit tile");
        } else {
            color = Color.WHITE;
        }
    }

    public boolean collidesWith(Tile tile) {
        if (y - radius >= tile.y) {
            if (x - radius <= tile.x + tile.width && x + radius >= tile.x) {
                return true;
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

public float getX() {
        return x;
        }

public void setX(float x) {
        this.x = x;
        }

public float getY() {
        return y;
        }

public void setY(float y) {
        this.y = y;
        }

public float getRadius() {
        return radius;
        }

public void setRadius(float radius) {
        this.radius = radius;
        }

public float getxSpeed() {
        return xSpeed;
        }

public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
        }

public float getySpeed() {
        return ySpeed;
        }

public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
        }

        }
