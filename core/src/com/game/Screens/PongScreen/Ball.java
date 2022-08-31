package com.game.Screens.PongScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static com.game.Screens.PongScreen.Platform.PLATFORM_HEIGHT;
import static com.game.Screens.PongScreen.Platform.PLATFORM_WIDTH;

public class Ball {

    private float x;
    private float y;
    private float radius;
    private float xSpeed;
    private float ySpeed;
    private Color color;
    private float velLeft;
    private float velRight;
    private float velUp;
    private float velDown;

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
        velLeft = x - radius;
        velRight = x + radius;
        velUp = y - radius;
        velDown = y + radius;
        if ( velLeft < 0 || velRight > Gdx.graphics.getWidth()) {
            xSpeed = -xSpeed;
        }
        if ( velUp > Gdx.graphics.getHeight()) {
            ySpeed = -ySpeed;
        }
        if ( velDown < 0) {
            y = (float) Gdx.graphics.getHeight()/2 - 50;
            x = (float) Gdx.graphics.getWidth()/2;
        }
    }

    public void updatePosDebug() {
        x = Gdx.input.getX();
        y = Gdx.graphics.getHeight() - Gdx.input.getY();
        velLeft = x - radius;
        velRight = x + radius;
        velUp = y + radius;
        velDown = y - radius;

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
            counter = 0;
            tile.destroyed = true;
        } else {
            color = Color.WHITE;
        }
    }

    int counter = 0;
    public boolean collidesWith(Tile tile) {
        counter++;
        if (counter >= 200) {
            if (y + radius >= tile.y && y - radius <= tile.y + tile.height) {
                if (velRight >= tile.x && velLeft <= tile.x + tile.width) {
                    if (ySpeed > 0) {
                        ySpeed = -ySpeed;
                    }
                    if (velRight >= tile.x && velRight <= tile.x + 12 || velLeft <= tile.x + tile.width && velLeft >= tile.x + tile.width - 12) {
                            xSpeed = -xSpeed;

                        counter = 0;
                    }
                        return true;
                }
            }
        }
        return false;
    }

    public void checkCollisionDebug(Tile tile) {
        if (collidesWithDebug(tile)) {
            //color = Color.GOLD;
            ySpeed = -ySpeed;
        } else {
            color = Color.WHITE;
        }
    }

    public boolean collidesWithDebug(Tile tile) {
        if (velUp >= tile.y && velDown <= tile.y + tile.height) {
            color = Color.RED;
                if (velRight >= tile.x + 4 && velLeft <= tile.x + tile.width - 4) {
                    color = Color.YELLOW;
                    if (velRight >= tile.x && velRight <= tile.x + 12 || velLeft <= tile.x + tile.width && velLeft >= tile.x + tile.width - 12) {
                        color = Color.GREEN;
                    }
                }
                return true;
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
