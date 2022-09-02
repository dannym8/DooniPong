package com.game.screens.pongscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Disposable;

import static com.game.screens.pongscreen.Platform.PLATFORM_HEIGHT;
import static com.game.screens.pongscreen.Platform.PLATFORM_WIDTH;

public class Ball implements Disposable {

    private float x;
    private float y;
    private final float radius;
    private float xSpeed;
    private float ySpeed;
    private Color color;
    private float velLeft;
    private float velRight;

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
        float velUp = y - radius;
        float velDown = y + radius;
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

    Sound platformHit1 = Gdx.audio.newSound(Gdx.files.internal("sounds/platformhit1.mp3"));
    Sound platformHit2 = Gdx.audio.newSound(Gdx.files.internal("sounds/platformhit2.mp3"));
    Sound platformHit3 = Gdx.audio.newSound(Gdx.files.internal("sounds/platformhit3.mp3"));


    public void checkCollision(Platform platform) {
        if (collidesWith(platform)) {
            color = Color.GOLD;
            ySpeed = -ySpeed;
            if (Math.random() <= 0.33) {
                platformHit1.play();
            } else if (Math.random() <= 0.66) {
                platformHit2.play();
            } else {
                platformHit3.play();
            }
        } else {
            color = Color.WHITE;
        }
    }

    public boolean collidesWith(Platform platform) {
        if (y + radius >= platform.y && y - radius <= platform.y + PLATFORM_HEIGHT) {
            if (x - radius <= platform.x + PLATFORM_WIDTH && x + radius >= platform.x) {
                if (x - radius < platform.x) {
                    xSpeed = -xSpeed;
                }
                if ( x + radius > platform.x + PLATFORM_WIDTH) {
                    xSpeed = -xSpeed;
                }
                return true;
            }
        }
        return false;
    }

    Sound blip1 = Gdx.audio.newSound(Gdx.files.internal("sounds/destroysound1.mp3"));
    Sound blip2 = Gdx.audio.newSound(Gdx.files.internal("sounds/destroysound2.mp3"));

    public void checkCollision(Tile tile, Scoreboard scoreboard) {
        if (collidesWith(tile)) {
            counter = 0;
            tile.destroyed = true;
            scoreboard.updateScore();
            if (Math.random() <= .50) {
                blip1.play();
            } else {
                blip2.play();
            }
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

    public void renderBall(ShapeRenderer renderer) {
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(color);
        renderer.circle(x,y,radius);
        renderer.end();
    }

    @Override
    public void dispose() {
        platformHit1.dispose();
        platformHit2.dispose();
        platformHit3.dispose();
        blip1.dispose();
        blip2.dispose();
    }
}
