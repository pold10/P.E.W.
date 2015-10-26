package com.nightcap.gameworld;

import com.nightcap.gameobjects.Player;

public class GameWorld {
	private Player player;

	public GameWorld(int xSize, int ySize) {
		player = new Player(ySize - 50, (int) xSize / 2, 40, 40);
	}

	public void update(float delta) {
		player.update(delta);

	}

	public Player getPlayer() {
		return player;
	}

}
