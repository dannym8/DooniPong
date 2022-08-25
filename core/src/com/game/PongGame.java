package com.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

public class PongGame extends ApplicationAdapter {

	private SpriteBatch batch;
	private Texture img;
	private OrthographicCamera camera;
	private ShapeRenderer renderer;
	private Music rainMusic;

	private final float PLATFORM_WIDTH = 83;
	private final float PLATFORM_HEIGHT = 19;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("bg.jpg");
		camera = new OrthographicCamera();
		camera.setToOrtho(false,800,600);
		renderer = new ShapeRenderer();
		renderer.setAutoShapeType(true);
		renderPlatform();
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
		rainMusic.setLooping(true);
		rainMusic.play();
	}

	@Override
	public void render () {
		// render batches(sprites)/shapes
		renderBackground();
		renderPlatform();
		renderTiles();
		// print fps
		System.out.println("FPS: " + Gdx.graphics.getFramesPerSecond());
	}

	private void renderTiles() {
		int heightGap = 0;
		double tileGap = 60;

		int TILE_ROW_COUNT = 18;
		for (int y = 0; y < TILE_ROW_COUNT; y++) {
			heightGap--;
			int TILES_IN_ROW = 12;
			for (int t = 0; t < TILES_IN_ROW; t++) {
			renderer.begin(ShapeRenderer.ShapeType.Filled);
			renderer.setColor(100,0,0,100);
			renderer.rect((float) (41F + (tileGap*t)),(camera.viewportHeight-40) + heightGap*15, (PLATFORM_WIDTH/1.5F), (PLATFORM_HEIGHT/1.5F));
			renderer.end();
			}
		}
	}

	private void renderBackground() {
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

	// renders the player platform
	private void renderPlatform() {
		renderer.begin(ShapeRenderer.ShapeType.Filled);
		renderer.setColor(255,50,255,100);
		int mouseX = Gdx.input.getX();
		renderer.rect(mouseX - (PLATFORM_WIDTH/2), 20, PLATFORM_WIDTH, PLATFORM_HEIGHT);
		renderer.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		renderer.dispose();
	}
}
