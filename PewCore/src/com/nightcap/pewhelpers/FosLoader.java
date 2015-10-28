package com.nightcap.pewhelpers;

import java.util.ArrayList;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
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
	public static ArrayList<TextureRegion> texturesArray = new ArrayList<TextureRegion>();
	public static ArrayList<String> texturesIndexArray = new ArrayList<String>();

	public static ArrayList<Sound> soundsArray = new ArrayList<Sound>();
	public static ArrayList<String> soundsIndexArray = new ArrayList<String>();

	// loading screen method definition goes here in the future

	// Mysterious arcane symbols and tribal chants begin here. WOLOLO!

	public static TextureRegion getTexReg(String fileName) {
		int index = texturesIndexArray.indexOf(fileName); // we don't want
		// index-=1; // multiple
		// searches.
		if (index >= 0) {
			Gdx.app.log("Log", fileName + " found!");
			return texturesArray.get(index);
		} else {
			Gdx.app.log("Error", "Texture " + fileName + " not found.");
			return null; // change to default "missing" texture
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

	public static void load(Array<FileHandle> allFiles) { // we set each file to
		// his own array
		for (FileHandle file : allFiles) {

			if (file.extension().equals("png")) { // dis sum low level
													// programmin'
				Texture texture = new Texture(file);
				texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

				TextureRegion textureRegion = new TextureRegion(texture, 0, 0,
						texture.getWidth(), texture.getHeight()); // completely
																	// modifiable
				textureRegion.flip(false, true);
				texturesArray.add(textureRegion);
				texturesIndexArray.add(file.nameWithoutExtension());
				Gdx.app.log(
						"Load",
						"Texture "
								+ file.name()
								+ " loaded to memory as "
								+ texturesIndexArray.get(texturesIndexArray
										.size() - 1));// Haiku programming

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
						+ " is a file. Added to loading array.");
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
}
