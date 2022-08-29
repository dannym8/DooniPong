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

		// tile grid that takes in width and height and tile list to put tile objects in
		tileGrid = new TileGrid(gridWidth, gridHeight, tiles);
		tileGrid.createTiles();

		// ball that bounces around
		ball = new Ball(camera.viewportWidth / 2, 100 , 9, 3, 3, Color.WHITE);

		// player platform (paddle)
		platform = new Platform(ShapeRenderer.ShapeType.Filled, Color.WHITE);

	}

	public void render () {
		// render background image
		bg.renderBackground(batch);
		// render player platform (paddle)
		platform.renderPlatform(renderer);
		// update ball position (movement)
		ball.updatePos();
		// render ball
		ball.renderBall(renderer);
		// check platform collision
		ball.checkCollision(platform);
		// check tiles collision
		tileGrid.renderTiles(renderer, ball);

	}

	@Override
	public void dispose () {
		// destroy resources when application stops
		batch.dispose();
		renderer.dispose();
	}
}
