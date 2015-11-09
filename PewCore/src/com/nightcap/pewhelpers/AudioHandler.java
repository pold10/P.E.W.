package com.nightcap.pewhelpers;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class AudioHandler {
	public static Sound shoot, mediumExplosion;

	public static Music music;

	public static void load() {
		// Audio
		shoot = FosLoader.getSound("small_plasma_fire");
		mediumExplosion = FosLoader.getSound("medium_generic_explosion");
		// Music
		music = FosLoader.getMusic("calm_space_loop");
		music.setLooping(true);
		music.setVolume(PreferencesHandler.getVolume()/100);
		
		if (PreferencesHandler.AudioOn()) {
			music.play();
		}
		
	}

	public static void musicToogle(boolean status) {
		if (status)
			music.play();
		else
			music.stop();
	}

	public static void setVolume(float volume) {
		music.setVolume((volume)/100);
	}
}
