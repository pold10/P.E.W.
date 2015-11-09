package com.nightcap.gameworld;

import java.util.ArrayList;

import com.nightcap.gameobjects.Enemy;
import com.nightcap.gameobjects.Player;
import com.nightcap.gameobjects.SmallEnemy;
import com.nightcap.pewhelpers.AudioHandler;

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
			if (!enemies.get(i).isAlive())
				enemies.remove(i);
		}

		// Enemies x Projectiles collisions
		for (int i = 0; i < enemies.size(); i++) {
			for (int j = 0; j < player.getProjectiles().size(); j++) {
				// If both rectangles collide, it's a collision.
				if (enemies
						.get(i)
						.getCollisionArea()
						.overlaps(
								player.getProjectiles().get(j)
										.getCollisionArea())) {
					// Gdx.app.log("GameWorld", "Collision!");
					AudioHandler.mediumExplosion.play();
					player.getProjectiles().get(j).setVisible(false);
					enemies.get(i).die();
				}
			}
		}
	}

	public Player getPlayer() {
		return player;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

}
