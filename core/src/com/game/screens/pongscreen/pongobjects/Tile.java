package com.game.screens.pongscreen.pongobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Tile {

    float x;
    float y;
    float width;

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

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    float height;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    int row;
    int col;
    Color color;

    public Tile (float width, float height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void renderTile(ShapeRenderer renderer) {
        if (!isDestroyed()) {
            renderer.begin(ShapeRenderer.ShapeType.Filled);
            renderer.setColor(color);
            renderer.rect(x, y, width, height);
            renderer.end();
        } else {
            x = -200;
            y = -200;
        }
    }

    @Override
    public String toString() {
        return "Tile at: [" + row + "]" + "[" + col + "]";
    }

    boolean destroyed;
    public boolean isDestroyed() {
        return destroyed;
    }

}
