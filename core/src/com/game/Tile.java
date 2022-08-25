package com.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Tile {

    float x;
    float y;
    float width;
    float height;
    int row;
    int col;
    Color color;

    public Tile (float x, float y, float width, float height,int row, int col, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public void renderTile(ShapeRenderer renderer) {
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(color);
        renderer.rect(x,y,width,height);
        renderer.end();
    }

    @Override
    public String toString() {
        return "Tile at: [" + row + "]" + "[" + col + "]";
    }

}
