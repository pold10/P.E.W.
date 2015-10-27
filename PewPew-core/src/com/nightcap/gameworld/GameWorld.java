package com.nightcap.gameworld;

import com.nightcap.gameobjects.Player;

public class GameWorld {
	private Player player;

	public GameWorld(int xSize, int ySize) {
		player = new Player((int) (xSize-32) / 2, ySize - 37, 32, 32);
	}

	public void update(float delta) {
		player.update(delta);

	}

	public Player getPlayer() {
		return player;
	}

}
