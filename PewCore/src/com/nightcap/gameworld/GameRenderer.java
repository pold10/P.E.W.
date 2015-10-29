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
	float stateTime = 0f;
	TextureRegion currentFrame;

	public GameRenderer(GameWorld world, int width, int height) {
		myWorld = world;
		cam = new OrthographicCamera();
		cam.setToOrtho(true, 640, 960);

		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
	}

	public void render(float runTime) {
		Player player = myWorld.getPlayer();
		ArrayList<Enemy> enemies = myWorld.getEnemies();

		// Fill the entire screen with black, to prevent potential flickering.
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();
		currentFrame = Assets.player.getKeyFrame(stateTime, true);

		// Begin ShapeRenderer
		shapeRenderer.begin(ShapeType.Filled);

		// Draw Background color
		shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
		shapeRenderer.rect(0, 0, 640, 960);

		shapeRenderer.end();

		// Begin SpriteBatch
		batcher.begin();

		// Disable transparency
		// This is good for performance when drawing images that do not require
		// transparency.
		batcher.disableBlending();
		batcher.draw(Assets.bg, 0, 0, 640, 960);

		batcher.enableBlending();
		
		

		batcher.draw(currentFrame, player.getX(), player.getY(),
				player.getWidth(), player.getHeight());

		// Draw bullets
		for (int i = 0; i < player.getProjectiles().size(); i++) {
			batcher.draw(Assets.projectile, player.getProjectiles().get(i)
					.getX(), player.getProjectiles().get(i).getY(), 2, 3);
		}

		// Draw enemies
		for (int i = 0; i < enemies.size(); i++) {
			batcher.draw(Assets.smallEnemy, enemies.get(i).getX(),
					enemies.get(i).getY(), 24, 24);
		}

		// End SpriteBatch
		batcher.end();

		// // Shape rendering for testing purposes
		// shapeRenderer.begin(ShapeType.Filled);
		// shapeRenderer.setColor(Color.RED);
		// shapeRenderer.rect(enemies.get(0).getCollisionArea().x,
		// enemies.get(0)
		// .getCollisionArea().y, 24, 24);
		// shapeRenderer.end();
	}
}