package com.nightcap.gameworld;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.nightcap.gameobjects.Enemy;
import com.nightcap.gameobjects.Player;
import com.nightcap.pewhelpers.Assets;

public class GameRenderer {
	private GameWorld myWorld;
	private OrthographicCamera cam;
	private SpriteBatch batcher;
	private ShapeRenderer shapeRenderer;
	TextureRegion currentFrame;

	// Game Objects
	Player player;
	ArrayList<Enemy> enemies;

	public GameRenderer(GameWorld world, int width, int height) {
		myWorld = world;

		cam = new OrthographicCamera();
		cam.setToOrtho(true, 640, 960);

		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);

		initGameObjects();
	}

	public void render(float runTime) {
		// Fill the entire screen with black, to prevent potential flickering.
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Future initAssets()
		currentFrame = Assets.player.getKeyFrame(runTime, true);

		shapeRenderer.begin(ShapeType.Filled);
		// Background color
		shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
		shapeRenderer.rect(0, 0, 640, 960);

		shapeRenderer.end();

		// Sprite Batch
		batcher.begin();

		// Transparency off
		batcher.disableBlending();
		batcher.draw(Assets.background0, 0, 0, 640, 960);

		// Transparency on
		batcher.enableBlending();

		batcher.draw(currentFrame, player.getX(), player.getY(),
				player.getWidth(), player.getHeight());

		drawBullets();

		drawEnemies();

		batcher.end();
	}

	public void initGameObjects() {
		player = myWorld.getPlayer();
		enemies = myWorld.getEnemies();
	}

	public void drawBullets() {
		for (int i = 0; i < player.getProjectiles().size(); i++) {
			batcher.draw(Assets.smallLeadNormal, player.getProjectiles().get(i)
					.getX(), player.getProjectiles().get(i).getY(), 2, 3);
		}
	}

	public void drawEnemies() {
		for (int i = 0; i < enemies.size(); i++) {
			batcher.draw(Assets.smallRat0, enemies.get(i).getX(), enemies
					.get(i).getY(), 24, 24);
		}
	}
}
