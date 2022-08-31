package com.game.screens.pongscreen.pongobjects.debugobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.game.screens.pongscreen.pongobjects.Ball;
import com.game.screens.pongscreen.pongobjects.Tile;

import java.util.ArrayList;

public class TileDebug {

    int gridWidth;
    int gridHeight;
    ArrayList<Tile> tiles;

    public TileDebug(int gridWidth, int gridHeight, ArrayList<Tile> tiles) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.tiles = tiles;
    }
    Tile tile;

    public void renderTileDebug(ShapeRenderer renderer, Ball ball) {
        tiles.get(0).setX(Gdx.graphics.getWidth()/2 - tiles.get(0).getWidth() /2);
        tiles.get(0).setY(Gdx.graphics.getHeight()/2);
        tiles.get(0).renderTile(renderer);
        ball.checkCollisionDebug(tiles.get(0));
    }

}
