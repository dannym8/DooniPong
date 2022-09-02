package com.game.screens.pongscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.game.screens.DooniPong;

import java.util.ArrayList;

public class PongScreen implements Screen {

	public SpriteBatch batch;
	private final ShapeRenderer renderer;
	private final Ball ball;
	private final TileGrid tileGrid;
	private final Background bg;
	private final Platform platform;
	private final Scoreboard scoreboard;
	private final BitmapFont font;

	private final Music rainMusic;
	final DooniPong game;
	boolean hardMode;

	public PongScreen(final DooniPong game, boolean hardMode) {
		this.game = game;
		this.hardMode = hardMode;
		// sets cursor to be cross-hair (invisible due to cursor catching in the next line)
		Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Crosshair);
		Gdx.input.setCursorCatched(true);

		// Tile grid dimensions
		int gridHeight = 6;
		int gridWidth = 15;

		// batch to render sprites and bg picture
		batch = new SpriteBatch();
		bg = new Background(0, 0, new Texture("images/bg.jpg"));

		// orthographic camera
		OrthographicCamera camera = new OrthographicCamera();
		camera.setToOrtho(false, 1100, 650);

		// shape renderer
		renderer = new ShapeRenderer();
		renderer.setAutoShapeType(true);

		// background music, looping
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/rain.mp3"));
		rainMusic.setLooping(true);
		//rainMusic.play();

		// arraylist to be used for tiles in tile grid
		ArrayList<Tile> tiles = new ArrayList<>();

		// tile grid that takes in width and height and tile list to put tile objects in
		tileGrid = new TileGrid(gridWidth, gridHeight, tiles);
		tileGrid.createTiles();

		// ball that bounces around
		ball = new Ball(camera.viewportWidth / 2, 100 , 9, 2, 3, Color.WHITE);

		// player platform (paddle)
		platform = new Platform(ShapeRenderer.ShapeType.Filled, Color.WHITE);

		// scoreboard init.
		scoreboard = new Scoreboard();

		// font for screen (arial by default)
		font = new BitmapFont();
		font.getData().setScale(1.80f);
		font.setColor(Color.WHITE);

	}

	@Override
	public void render(float delta) {

		// render background image
		bg.renderBackground(batch);

		// render player platform (paddle)
		if (hardMode) {
			platform.renderPlatformHardMode(renderer);
		} else {
			platform.renderPlatformEasyMode(renderer);
		}

		// update ball position (movement)
		ball.updatePos();

		// check platform collision
		ball.checkCollision(platform);

		// check tiles collision
		tileGrid.renderTiles(renderer, ball, scoreboard);

		// render ball
		ball.renderBall(renderer);

		// render scoreboard
		scoreboard.renderScoreboard(font, batch);
		Gdx.input.setCursorPosition(0, 0);

	}

	@Override
	public void dispose () {
		// destroy resources when application stops
		rainMusic.dispose();
		batch.dispose();
		renderer.dispose();
		font.dispose();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

}
