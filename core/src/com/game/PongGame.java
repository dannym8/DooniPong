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

public class PongGame extends ApplicationAdapter {

	private SpriteBatch batch;
	private OrthographicCamera camera;
	private ShapeRenderer renderer;
	private Ball ball;
	private ArrayList<Tile> tiles;
	private TileGrid tileGrid;
	private Background bg;
	private Platform platform;

	public static final float PLATFORM_WIDTH = 83;
	public static final float PLATFORM_HEIGHT = 19;

	@Override
	public void create () {

		batch = new SpriteBatch();
		bg = new Background(0,0,new Texture("bg.jpg"));

		camera = new OrthographicCamera();
		camera.setToOrtho(false,800,600);

		renderer = new ShapeRenderer();
		renderer.setAutoShapeType(true);

		Music rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
		rainMusic.setLooping(true);
		rainMusic.play();

		tiles = new ArrayList<>();
		tileGrid = new TileGrid(12,18,tiles);

		ball = new Ball(camera.viewportWidth/2,camera.viewportHeight/2,9,3,3);

		platform = new Platform(ShapeRenderer.ShapeType.Filled, Color.WHITE);

	}

	public void render () {
		// render background image
		bg.renderBackground(batch);
		// render player platform (paddle)
		platform.renderPlatform(renderer);
		// draw tile grid
		tileGrid.drawGrid(renderer);
		// update ball position (movement)
		ball.updatePos();
		// render ball
		ball.renderBall(renderer);
	}

	@Override
	public void dispose () {
		batch.dispose();
		renderer.dispose();
	}
}
