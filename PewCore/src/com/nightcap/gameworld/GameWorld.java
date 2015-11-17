package com.nightcap.gameworld;

import com.nightcap.gameobjects.Player;
import com.nightcap.pewhelpers.AudioHandler;

public class GameWorld {
	private Player player;
	private StageLoader stage;

	public GameWorld(int xSize, int ySize) {
		stage = new StageLoader();
		
		player = new Player((int) (xSize - 32) / 2, ySize - 37, 32, 32);

	}

	public void update(float delta) {
		player.update(delta);

		stage.update(delta);
		
		// Enemies x Projectiles collisions
		for (int i = 0; i < stage.getEnemies().size(); i++) {
			for (int j = 0; j < player.getProjectiles().size(); j++) {
				// If both rectangles collide, it's a collision.
				if (stage.getEnemies()
						.get(i)
						.getCollisionArea()
						.overlaps(
								player.getProjectiles().get(j)
										.getCollisionArea())) {
					// Gdx.app.log("GameWorld", "Collision!");
					AudioHandler.mediumExplosion.play();
					player.getProjectiles().get(j).setVisible(false);
					stage.getEnemies().get(i).die();
				}
			}
		}
	}

	public Player getPlayer() {
		return player;
	}
	
	public StageLoader getStage() {
		return stage;
	}

}
