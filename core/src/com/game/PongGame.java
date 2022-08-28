package com.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

import static com.game.Platform.PLATFORM_HEIGHT;
import static com.game.Platform.PLATFORM_WIDTH;

public class PongGame extends ApplicationAdapter {

	private SpriteBatch batch;
	private OrthographicCamera camera;
	private ShapeRenderer renderer;
	private Ball ball;
	private ArrayList<Tile> tiles;
	private TileGrid tileGrid;
	private Background bg;
	private Platform platform;
	private Tile tile;

	private int gridHeight;
	private int gridWidth;

	@Override
	public void create () {

		gridHeight = 18;
		gridWidth = 12;

		// batch to render sprites and bg picture
		batch = new SpriteBatch();
		bg = new Background(0, 0, new Texture("bg.jpg"));

		// orthographic camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 600);

		// shape renderer
		renderer = new ShapeRenderer();
		renderer.setAutoShapeType(true);

		// background music, looping
		Music rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
		rainMusic.setLooping(true);
		rainMusic.play();

		// arraylist to be used for tiles in tile grid
		tiles = new ArrayList<>();

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

			// tile grid that takes in width and height and tile list to put tile objects in
			tileGrid = new TileGrid(gridWidth, gridHeight, tiles);

			// ball that bounces around
			ball = new Ball(camera.viewportWidth / 2, 100 , 9, 3, 3, Color.WHITE);

			// player platform (paddle)
			platform = new Platform(ShapeRenderer.ShapeType.Filled, Color.WHITE);

		}
	}

		public void render () {
			// render background image
			bg.renderBackground(batch);
			// render player platform (paddle)
			platform.renderPlatform(renderer);
			// update ball position (movement)
			ball.updatePos();
			// check platform collision
			ball.checkCollision(platform);
			// check tiles collision
			for (Tile tile: tiles) {
				tile.renderTile(renderer);
				ball.checkCollision(tile);
			}
			// render ball
			ball.renderBall(renderer);
		}

		@Override
		public void dispose () {
			// destroy resources when application stops
			batch.dispose();
			renderer.dispose();
		}
	}
