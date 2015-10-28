package com.nightcap.pewpew;

import com.badlogic.gdx.Game;
import com.nightcap.pewhelpers.Assets;
import com.nightcap.screens.GameScreen;

public class PewPewGame extends Game {

	@Override
	public void create() {
		Assets.load();
		setScreen(new GameScreen());
	}

	@Override
	public void dispose() {
		super.dispose();
		Assets.dispose();
	}
}
