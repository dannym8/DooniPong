package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

import static com.game.Platform.PLATFORM_HEIGHT;
import static com.game.Platform.PLATFORM_WIDTH;

public class TileGrid {

    int gridWidth;
    int gridHeight;
    ArrayList<Tile> tiles;

    public TileGrid(int gridWidth, int gridHeight, ArrayList<Tile> tiles) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.tiles = tiles;
    }

    // constructor without array list
    public TileGrid(int gridWidth, int gridHeight) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
    }

    Tile tile;

    public void createTiles() {
        int heightGap = 0;
        double tileGap = 60;
        for (int y = 0; y < gridHeight; y++) {
            heightGap--;
            for (int t = 0; t < gridWidth; t++) {
                tile = new Tile((PLATFORM_WIDTH / 1.5F), (PLATFORM_HEIGHT / 1.5F), new Color(0xaee6f8));
                tile.setX((float) (41F + (tileGap * t)));
                tile.setY((Gdx.graphics.getHeight() - 40) + heightGap * 15);
                tile.setCol(y + 1);
                tile.setRow(t + 1);
                tiles.add(tile);
            }
        }
    }

    public void renderTiles(ShapeRenderer renderer, Ball ball) {
        for (Tile tile: tiles) {
            tile.renderTile(renderer);
            ball.checkCollision(tile);
        }
    }

}