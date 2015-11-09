package com.nightcap.pewhelpers;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

	public static TextureRegion background0, smallLeadNormal, smallRat0;

	public static Animation player, smallImpactLead;

	public static void load() {

		// Fosforito loader bootstrap
		FosLoader.getHandles(FosLoader.getRoot(), FosLoader.fileArray);
		FosLoader.load(FosLoader.fileArray);

		// Background
		background0 = FosLoader.getTexReg("background_0");
		// Player
		player = FosLoader.getAnimation(0.2f, "raw_medium_player_0");
		// Player's projectiles
		smallLeadNormal = FosLoader.getTexReg("small_lead_normal");
		// Enemies
		smallRat0 = FosLoader.getTexReg("small_rat_0");
		// Enemy explosions
		smallImpactLead = FosLoader.getAnimation(0.2f, "raw_small_impact_lead");
	}

	public static void dispose() {
		// Is this needed? 
	}
}
