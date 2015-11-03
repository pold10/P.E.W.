package com.nightcap.pewhelpers;

import java.util.ArrayList;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/*WARNING:
 * Fosforito code incoming, expect the unexpected. Not for the faint-hearted.
 * 
 * DISCLAIMER:
 * The author disclaims any kind of damage caused by reading this code.
 * If you're left utterly confused, the author says sorry and
 * reserves the right to feel sympathy and move on.
 *  
 */
public class FosLoader { // awesome name. Should it be an interface?

	public static Array<FileHandle> fileArray = new Array<FileHandle>();
	// ALL THE RAW FILES. SHOULD BE DELETED AFTER BEING USED!

	// Specific type arrays begin. Add as many as you see fit.
	// rawTexturesArray added for any purpose I might've missed.
	public static ArrayList<Texture> rawTexturesArray = new ArrayList<Texture>();
	public static ArrayList<String> rawTexturesIndexArray = new ArrayList<String>();

	// FosLoader.load() sets TextureRegion width and height to the
	// png's file .width() and .height()
	public static ArrayList<TextureRegion> texturesArray = new ArrayList<TextureRegion>();
	public static ArrayList<String> texturesIndexArray = new ArrayList<String>();

	public static ArrayList<Sound> soundsArray = new ArrayList<Sound>();
	public static ArrayList<String> soundsIndexArray = new ArrayList<String>();

	public static ArrayList<Music> musicArray = new ArrayList<Music>();
	public static ArrayList<String> musicIndexArray = new ArrayList<String>();

	// loading screen method definition goes here in the future

	// Mysterious arcane symbols and tribal chants begin here. WOLOLO!

	public static Texture getRawTexture(String fileName) {
		int index = rawTexturesIndexArray.indexOf(fileName);

		if (index >= 0) {
			Gdx.app.log("Log", fileName + " found!");
			return rawTexturesArray.get(index);
		} else {
			Gdx.app.log("Error", "Raw texture " + fileName + " not found.");
			return null;
		}
	}

	public static TextureRegion getTexReg(String fileName) {
		int index = texturesIndexArray.indexOf(fileName);
		// we don't want to cause multiple searches

		if (index >= 0) {
			Gdx.app.log("Log", fileName + " found!");
			return texturesArray.get(index);

		} else {
			Gdx.app.log("Error", "Texture " + fileName + " not found.");
			return null; // change to default "missing" texture
		}
	}

	// nice little method here v creates animation from image sheet.
	public static Animation getAnimation(float timeInterval, String fileName) {
		int index = rawTexturesIndexArray.indexOf(fileName);
		if (index >= 0) {
			Gdx.app.log("Log", fileName + " found!");
			Texture texture = rawTexturesArray.get(index);
			int keyFrames = texture.getWidth() / texture.getHeight();
			TextureRegion[][] splitTexture = TextureRegion.split(texture,
					texture.getWidth() / keyFrames, texture.getHeight());
			TextureRegion[] unidim = new TextureRegion[keyFrames];

			for (int i = 0; i < keyFrames; i++) {
				unidim[i] = splitTexture[0][i];
				unidim[i].flip(false, true);
			}
			Animation animation = new Animation(timeInterval, unidim);
			return animation;
		} else {
			Gdx.app.log("Error", fileName + " not found.");
			Gdx.app.log("Error", "No raw texture file.");
			return null;
		}
	}

	public static Sound getSound(String fileName) {
		int index = soundsIndexArray.indexOf(fileName);
		if (index >= 0) {
			Gdx.app.log("Log", fileName + " found!");
			return soundsArray.get(index);
		} else {
			Gdx.app.log("Error", "Sound " + fileName + " not found.");
			return null; // I should change this to a default 'silent' sound.
		}
	}

	public static Music getMusic(String fileName) {
		int index = musicIndexArray.indexOf(fileName);
		if (index >= 0) {
			Gdx.app.log("Log", fileName + " found!");
			return musicArray.get(index);
		} else {
			Gdx.app.log("Error", "Song " + fileName + " not found.");
			return null; // change to default 'silent' sound.
		}
	}

	public static void load(Array<FileHandle> allFiles) { // we set each file to
		// his own array
		for (FileHandle file : allFiles) {

			// Pold's note: Make this loader not load the "skins" folder, so
			// these weird exclusions "!" can be deleted
			if (file.extension().equals("png")
					&& !file.name().equals("default.png")
					&& !file.name().equals("uiskin.png")) { // dis sum low level
				// programmin'
				Texture texture = new Texture(file);
				texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

				// filtering specific textures for raw use only.
				if (file.name().toLowerCase().startsWith("raw")) {
					rawTexturesArray.add(texture);
					rawTexturesIndexArray.add(file.nameWithoutExtension());
					Gdx.app.log(
							"Load",
							"Raw Texture "
									+ file.name()
									+ " loaded to memory as "
									+ rawTexturesIndexArray
											.get(rawTexturesIndexArray.size() - 1));
				} else {

					TextureRegion textureRegion = new TextureRegion(texture, 0,
							0, texture.getWidth(), texture.getHeight());
					textureRegion.flip(false, true);
					texturesArray.add(textureRegion);
					texturesIndexArray.add(file.nameWithoutExtension());
					Gdx.app.log(
							"Load",
							"Texture "
									+ file.name()
									+ " loaded to memory as "
									+ texturesIndexArray.get(texturesIndexArray
											.size() - 1));
				}

				// Haiku programming

			} else if (file.extension().equals("wav")) {

				Sound sound = Gdx.audio.newSound(file);

				soundsArray.add(sound);
				soundsIndexArray.add(file.nameWithoutExtension());
				Gdx.app.log(
						"Load",
						"Sound "
								+ file.name()
								+ " loaded to memory as"
								+ soundsIndexArray.get(soundsIndexArray.size() - 1));

			} else if (file.extension().equals("mp3")) {

				Music music = Gdx.audio.newMusic(file);

				musicArray.add(music);
				musicIndexArray.add(file.nameWithoutExtension());
				Gdx.app.log(
						"Load",
						"Song "
								+ file.name()
								+ " loaded to memory as"
								+ musicIndexArray.get(musicIndexArray.size() - 1));

			} else {

				Gdx.app.log("Load", file.path() + " is not loaded.");

			}
		}
	}

	// here comes the magic. getRoot() vvv Goes there.
	public static Array<FileHandle> getHandles(FileHandle root,
			Array<FileHandle> allFiles) {

		FileHandle[] newHandles = root.list();

		for (FileHandle file : newHandles) {

			if (file.isDirectory()) {

				Gdx.app.log("Seek", file.name() + " is a folder. Accessing "
						+ file.name() + " folder.");
				getHandles(file, allFiles); // recursive to the rescue. TADAA!!!

			} else {

				Gdx.app.log("Seek", file.name()
						+ " is a file. Queued to loader.");
				allFiles.add(file);

			}

		}
		return allFiles; // ALL. THE. FILES. NO EXCEPTION.
	}

	public static FileHandle getRoot() {
		if (Gdx.app.getType() == ApplicationType.Android) {
			return Gdx.files.internal("/");
		} else {
			return Gdx.files.internal("./assets/"); // THIS. IS. FUCKING
													// REDIRECTING TO
													// DESKTOP. WHAT DO?
		}
	}

	public static void disposeAll() {
		// dispose ALL
		fileArray.clear();
		musicArray.clear();
		musicIndexArray.clear();
		rawTexturesArray.clear();
		rawTexturesIndexArray.clear();
		soundsArray.clear();
		soundsIndexArray.clear();
		texturesArray.clear();
		texturesIndexArray.clear();		
	}
}