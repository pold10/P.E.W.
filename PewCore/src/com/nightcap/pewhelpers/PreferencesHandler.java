package com.nightcap.pewhelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class PreferencesHandler {
	private static Preferences prefs;

	public static void load() {
		prefs = Gdx.app.getPreferences("PEWPreferences");
	}

	public static boolean AudioOn() {
		return prefs.getBoolean("AudioOn");
	}

	public static void AudioToggle() {
		if (AudioOn()) {
			prefs.putBoolean("AudioOn", false);
		} else {
			prefs.putBoolean("AudioOn", true);
		}
		prefs.flush();
		AudioHandler.musicToogle(prefs.getBoolean("AudioOn"));
	}

	public static void setVolume(float volume) {
		AudioHandler.setVolume(volume);
		prefs.putFloat("Volume", volume);
		prefs.flush();
	}

	public static float getVolume() {
		return prefs.getFloat("Volume");
	}
}
