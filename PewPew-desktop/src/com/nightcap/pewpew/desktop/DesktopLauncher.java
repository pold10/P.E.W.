package com.nightcap.pewpew.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nightcap.pewpew.PewPewGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Planetary Extermination War";
        config.width = 640;
        config.height = 960;
		new LwjglApplication(new PewPewGame(), config);
	}
}
