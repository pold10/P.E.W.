package com.nightcap.pewhelpers;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

	public static TextureRegion bg, player, projectile, smallEnemy;

	public static Sound shoot, mediumExplosion;

	public static void load() {
		
		//Fosforito loader bootstrap
		FosLoader.getHandles(FosLoader.getRoot(), FosLoader.fileArray);
		FosLoader.load(FosLoader.fileArray);
		
		// Background
		bg = FosLoader.getTexReg("background_0");
		// Player
		player = FosLoader.getTexReg("medium_player_0");
		// Player's projectiles
		projectile = FosLoader.getTexReg("small_lead_normal");
		// Enemies
		smallEnemy = FosLoader.getTexReg("small_rat_0");
		// Audio
		shoot = FosLoader.getSound("small_plasma_fire");
		mediumExplosion = FosLoader.getSound("medium_generic_explosion");
	}

	public static void dispose() {
	}
}
