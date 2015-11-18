package com.nightcap.pewhelpers;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.nightcap.gameobjects.Player;
import com.nightcap.pewpew.PEWGame;
import com.nightcap.userinterface.MainMenu;

public class InputHandler implements InputProcessor {
	PEWGame game;
	private Player player;

	public InputHandler(Player player, PEWGame game) {
		this.game = game;
		this.player = player;
	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case Keys.UP:
			player.up();
			break;
		case Keys.DOWN:
			player.down();
			break;
		case Keys.LEFT:
			player.left();
			break;
		case Keys.RIGHT:
			player.right();
			break;
		case Keys.SPACE:
			player.shoot();
			break;
		case Keys.ESCAPE:
			game.setScreen(new MainMenu(game));
			break;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch (keycode) {
		case Keys.UP:
			player.down();
			break;
		case Keys.DOWN:
			player.up();
			break;
		case Keys.LEFT:
			player.right();
			break;
		case Keys.RIGHT:
			player.left();
			break;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
