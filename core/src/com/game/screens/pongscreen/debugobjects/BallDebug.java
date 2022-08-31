package com.game.screens.pongscreen.debugobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.game.screens.pongscreen.Platform;
import com.game.screens.pongscreen.Tile;

import static com.game.screens.pongscreen.Platform.PLATFORM_HEIGHT;
import static com.game.screens.pongscreen.Platform.PLATFORM_WIDTH;

public class BallDebug {

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

        public BallDebug(float x, float y, float radius, float xSpeed, float ySpeed, Color color) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.xSpeed = xSpeed;
            this.ySpeed = ySpeed;
            this.color = color;
        }

        public void updatePosDebug() {
            x = Gdx.input.getX();
            y = Gdx.graphics.getHeight() - Gdx.input.getY();
            velLeft = x - radius;
            velRight = x + radius;
            velUp = y + radius;
            velDown = y - radius;

        }

        public boolean collidesWithDebug(Platform platform) {
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

        public boolean collidesWithDebug(Tile tile) {
            if (velUp >= tile.getY() && velDown <= tile.getY() + tile.getHeight()) {
                color = Color.RED;
                if (velRight >= tile.getX() + 4 && velLeft <= tile.getX() + tile.getWidth() - 4) {
                    color = Color.YELLOW;
                    if (velRight >= tile.getX() && velRight <= tile.getX() + 12 || velLeft <= tile.getX() + tile.getWidth() && velLeft >= tile.getX() + tile.getWidth() - 12) {
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

