package com.nightcap.gameworld;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nightcap.gameobjects.Enemy;
import com.nightcap.pewhelpers.Assets;

public class StageRenderer {
	private GameWorld world;

	private ArrayList<Enemy> enemies;

	public StageRenderer(GameWorld world) {
		this.world = world;
		
		enemies = world.getStage().getEnemies();
	}

	void drawEnemies(SpriteBatch batcher) {
		for (int i = 0; i < enemies.size(); i++) {
			batcher.draw(Assets.smallRat0, enemies.get(i).getX(), enemies
					.get(i).getY(), 24, 24);
		}
	}

	void drawBackground(SpriteBatch batcher) {
		batcher.draw(Assets.background0, 0, 0, 640, 960);
	}
}

