package com.nightcap.pewpew;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.nightcap.pewhelpers.AssetLoader;
import com.nightcap.screens.GameScreen;

public class PewPewGame extends Game {

	@Override
	public void create() {
		Gdx.app.log("ZBGame", "created");
		AssetLoader.load();
		setScreen(new GameScreen());
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}
}
