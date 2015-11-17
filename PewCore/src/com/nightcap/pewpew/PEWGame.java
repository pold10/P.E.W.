package com.nightcap.pewpew;

import com.badlogic.gdx.Game;
import com.nightcap.pewhelpers.Assets;
import com.nightcap.pewhelpers.AudioHandler;
import com.nightcap.pewhelpers.FosLoader;
import com.nightcap.pewhelpers.PreferencesHandler;
import com.nightcap.userinterface.MainMenu;

public class PEWGame extends Game {

	@Override
	public void create() {
		PreferencesHandler.load();
		Assets.load();
		AudioHandler.load();
		setScreen(new MainMenu(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		FosLoader.disposeAll();
	}
}
