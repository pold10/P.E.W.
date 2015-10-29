package com.nightcap.pewpew;

import com.badlogic.gdx.Game;
import com.nightcap.pewhelpers.Assets;
import com.nightcap.userinterface.MainMenu;

public class PEWGame extends Game {

	@Override
	public void create() {
		Assets.load();
		setScreen(new MainMenu(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		Assets.dispose();
	}
}
