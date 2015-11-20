package com.nightcap.gameworld;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nightcap.gameobjects.Enemy;
import com.nightcap.pewhelpers.Assets;

public class StageRenderer {
	private static final int overlaySpeed = 500;

	private ArrayList<Enemy> enemies;

	public StageRenderer(GameWorld world) {
		enemies = world.getStage().getEnemies();
	}

	void drawEnemies(SpriteBatch batcher) {
		for (int i = 0; i < enemies.size(); i++) {
			batcher.draw(Assets.smallRat0, enemies.get(i).getX(), enemies
					.get(i).getY(), 24, 24);
		}
	}

	void drawBackground(SpriteBatch batcher) {
		batcher.draw(Assets.background2, 0, 0,
				Assets.background2.getRegionWidth(),
				Assets.background2.getRegionHeight());
	}

	void drawOverlay(SpriteBatch batcher, float runTime) {
		int y = (int) ((runTime * overlaySpeed) % Assets.overlay0
				.getRegionHeight()) - Gdx.graphics.getHeight();
		
		batcher.draw(Assets.overlay0, 0, y, Assets.overlay0.getRegionWidth(),
				Assets.overlay0.getRegionHeight());
		
		if (y >= 0) {
			batcher.draw(Assets.overlay0, 0,
					y - Assets.overlay0.getRegionHeight(),
					Assets.overlay0.getRegionWidth(),
					Assets.overlay0.getRegionHeight());
		}
	}
}
