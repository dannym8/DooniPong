package com.game.screens.pongscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.game.screens.pongscreen.Ball;
import com.game.screens.pongscreen.Tile;

import java.util.ArrayList;

public class TileGrid {

    int gridWidth;
    int gridHeight;
    ArrayList<Tile> tiles;

    public TileGrid(int gridWidth, int gridHeight, ArrayList<Tile> tiles) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.tiles = tiles;
    }

    Tile tile;
    public void createTiles() {
        int heightGap = 0;
        double tileGap = 70;
        for (int y = 0; y < gridHeight; y++) {
            heightGap--;
            for (int t = 0; t < gridWidth; t++) {
                tile = new Tile(65,25 , new Color(0xaee6f8));
                tile.setX((float) (15F + (tileGap * t)));
                tile.setY((Gdx.graphics.getHeight() - 40) + heightGap * 30);
                tile.setCol(y + 1);
                tile.setRow(t + 1);
                tiles.add(tile);
            }
        }
    }

    public void renderTiles(ShapeRenderer renderer, Ball ball) {
        for (Tile tile : tiles) {
            tile.renderTile(renderer);
            ball.checkCollision(tile);
        }
    }
}