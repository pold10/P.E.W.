package com.nightcap.pewhelpers;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

	public static TextureRegion menuBackground0, menuBackground1,
			mainMenuButton0, background0, background1, background2, overlay0,
			smallLeadNormal, smallRat0;

	public static Animation player, smallImpactLead;

	public static void load() {

		// Fosforito loader bootstrap
		FosLoader.getHandles(FosLoader.getRoot(), FosLoader.fileArray);
		FosLoader.load(FosLoader.fileArray);

		// *** Main Menu ***
		menuBackground0 = FosLoader.getTexReg("menu_background_0");
		menuBackground0.flip(false, true);
		menuBackground1 = FosLoader.getTexReg("menu_background_1");
		menuBackground1.flip(false, true);
		mainMenuButton0 = FosLoader.getTexReg("main_menu_button_0");

		// *** Game Screen ***
		// Background
		background0 = FosLoader.getTexReg("background_0");
		background1 = FosLoader.getTexReg("background_1");
		background2 = FosLoader.getTexReg("background_2");
		overlay0 = FosLoader.getTexReg("overlay_0");
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
