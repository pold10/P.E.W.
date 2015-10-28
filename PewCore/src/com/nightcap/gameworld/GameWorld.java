package com.nightcap.gameworld;

import java.util.ArrayList;

import com.nightcap.gameobjects.Enemy;
import com.nightcap.gameobjects.Player;
import com.nightcap.gameobjects.SmallEnemy;

public class GameWorld {
	private Player player;
	ArrayList<Enemy> enemies;

	public GameWorld(int xSize, int ySize) {
		player = new Player((int) (xSize - 32) / 2, ySize - 37, 32, 32);
		enemies = new ArrayList<Enemy>();
		enemies.add(new SmallEnemy(100, 100));

	}

	public void update(float delta) {
		player.update(delta);

		 for (int i = 0; i < enemies.size(); i++) {
		 enemies.get(i).update(delta);
		 }

	}

	public Player getPlayer() {
		return player;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

}
