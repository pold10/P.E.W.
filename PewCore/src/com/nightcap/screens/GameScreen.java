package com.nightcap.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.nightcap.gameworld.GameRenderer;
import com.nightcap.gameworld.GameWorld;
import com.nightcap.pewhelpers.InputHandler;
import com.nightcap.pewpew.PEWGame;

public class GameScreen implements Screen {
	private GameWorld world;
	private GameRenderer renderer;
	private float runTime = 0;

	public GameScreen(PEWGame game) {
		int screenWidth = (int) Gdx.graphics.getWidth();
		int screenHeight = (int) Gdx.graphics.getHeight();

		world = new GameWorld(screenWidth, screenHeight);
		renderer = new GameRenderer(world, screenWidth, screenHeight);

		Gdx.input.setInputProcessor(new InputHandler(world.getPlayer(),game));
	}

	@Override
	public void render(float delta) {
	    runTime += delta;
	    world.update(delta);
	    renderer.render(runTime);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
