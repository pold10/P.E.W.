package com.nightcap.pewhelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

	public static Texture texture;
	public static Texture ptexture;
	public static TextureRegion bg;
	public static TextureRegion player;

	public static void load() {
		texture = new Texture(Gdx.files.internal("data/background_1.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		bg = new TextureRegion(texture, 0, 0, 640, 960);
		bg.flip(false, true);
		
		ptexture = new Texture(Gdx.files.internal("data/medium_player_0.png"));
		ptexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		player = new TextureRegion(ptexture,0,0,32,32);
		player.flip(false, true);
	}

	public static void dispose() {
		texture.dispose();
		ptexture.dispose();
	}
}
