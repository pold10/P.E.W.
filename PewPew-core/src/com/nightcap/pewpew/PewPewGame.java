package com.nightcap.pewpew;

import com.badlogic.gdx.Game;
import com.nightcap.pewhelpers.AssetLoader;
import com.nightcap.screens.GameScreen;

public class PewPewGame extends Game {

	@Override
	public void create() {
		AssetLoader.load();
		setScreen(new GameScreen());
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}
}
