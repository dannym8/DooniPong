package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

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

    // constructor without array list
    public TileGrid(int gridWidth, int gridHeight) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
    }

    public void drawGrid(ShapeRenderer renderer) {
//            int heightGap = 0;
//            double tileGap = 60;
//            for (int y = 0; y < gridHeight; y++) {
//                heightGap--;
//                for (int t = 0; t < gridWidth; t++) {
//                    tiles.get(i).setX((float) (41F + (tileGap * t)));
//                    tiles.get(i).setY((Gdx.graphics.getHeight() - 40) + heightGap * 15);
//                    tiles.get(i).setCol(y + 1);
//                    tiles.get(i).setRow(t + 1);
//                    tiles.get(i).renderTile(renderer);
//                    renderer.end();
                }
            }