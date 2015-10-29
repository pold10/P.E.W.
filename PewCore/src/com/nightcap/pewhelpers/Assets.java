package com.nightcap.pewhelpers;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

	public static TextureRegion bg, projectile, smallEnemy;
	
	public static Animation player;

	public static Sound shoot, mediumExplosion;
	
	public static Music music;

	public static void load() {
		
		//Fosforito loader bootstrap
		FosLoader.getHandles(FosLoader.getRoot(), FosLoader.fileArray);
		FosLoader.load(FosLoader.fileArray);
		
		// Background
		bg = FosLoader.getTexReg("background_0");
		// Player
		player = FosLoader.getAnimation(0.2f,"raw_medium_player_0");
		// Player's projectiles
		projectile = FosLoader.getTexReg("small_lead_normal");
		// Enemies
		smallEnemy = FosLoader.getTexReg("small_rat_0");
		// Audio
		shoot = FosLoader.getSound("small_plasma_fire");
		mediumExplosion = FosLoader.getSound("medium_generic_explosion");
		//Music
		music = FosLoader.getMusic("calm_space_loop");
		music.play();
		music.setLooping(true);
		
	}

	public static void dispose() {
	}
}
