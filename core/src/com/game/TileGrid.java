package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

import static com.game.PongGame.PLATFORM_HEIGHT;
import static com.game.PongGame.PLATFORM_WIDTH;

public class TileGrid {

    int gridWidth;
    int gridHeight;
    private Tile tile;
    ArrayList<Tile> tiles;

    public TileGrid(int gridWidth, int gridHeight, ArrayList<Tile> tiles) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.tiles = tiles;
    }

    public void drawGrid(ShapeRenderer renderer) {
        int heightGap = 0;
        double tileGap = 60;
        for (int y = 0; y < gridHeight; y++) {
            heightGap--;
            for (int t = 0; t < gridWidth; t++) {
                tile = new Tile((float) (41F + (tileGap * t)), (Gdx.graphics.getHeight() - 40) + heightGap * 15, (PLATFORM_WIDTH / 1.5F), (PLATFORM_HEIGHT / 1.5F),t+1,y+1, Color.RED);
                tile.renderTile(renderer);
                tiles.add(tile);
                renderer.end();
            }
        }
    }
}