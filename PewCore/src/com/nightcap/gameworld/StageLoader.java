package com.nightcap.gameworld;

import java.util.ArrayList;

import com.nightcap.gameobjects.Enemy;
import com.nightcap.gameobjects.SmallEnemy;

public class StageLoader {
	private static ArrayList<Enemy> enemies;

	public StageLoader() {
		enemies = new ArrayList<Enemy>();
		
		// Test enemy
		enemies.add(new SmallEnemy(200,200));
		enemies.add(new SmallEnemy(500,250));
		enemies.add(new SmallEnemy(400,500));
		enemies.add(new SmallEnemy(100,700));
	}

	public void update(float delta) {
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).update(delta, 1);
			if (!enemies.get(i).isAlive())
				enemies.remove(i);
		}
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
}
