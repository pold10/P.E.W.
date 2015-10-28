package com.nightcap.pewhelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

	public static Texture texture, ptexture, prtexture, etexture;

	public static TextureRegion bg, player, projectile, smallEnemy;

	public static Sound shoot, mediumExplosion;

	public static void load() {
		// Background
		texture = new Texture(Gdx.files.internal("data/background_1.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		bg = new TextureRegion(texture, 0, 0, 640, 960);
		bg.flip(false, true);

		// Player
		ptexture = new Texture(Gdx.files.internal("data/medium_player_0.png"));
		ptexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		player = new TextureRegion(ptexture, 0, 0, 32, 32);
		player.flip(false, true);

		// Player's projectiles
		prtexture = new Texture(
				Gdx.files.internal("data/small_lead_normal.png"));
		prtexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		projectile = new TextureRegion(prtexture, 0, 0, 2, 3);
		projectile.flip(false, true);

		// Enemies
		etexture = new Texture(Gdx.files.internal("data/small_rat_0.png"));
		etexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		smallEnemy = new TextureRegion(etexture, 0, 0, 24, 24);
		smallEnemy.flip(false, true);

		// Audio
		shoot = Gdx.audio.newSound(Gdx.files
				.internal("data/small_plasma_fire.wav"));
		mediumExplosion = Gdx.audio.newSound(Gdx.files
				.internal("data/medium_generic_explosion.wav"));
	}

	public static void dispose() {
		texture.dispose();
		ptexture.dispose();
	}
}
