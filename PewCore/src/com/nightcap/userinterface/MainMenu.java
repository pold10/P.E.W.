package com.nightcap.userinterface;

/* @author: Pold 29/10/2015
 * 
 * This entire file should be edited, this is just a test.
 * 
 * Original comments (from several guides) are kept inside
 * the file, in order to make the file understandable.
 * 
 * Personal comments begin with a "Note:" identifier.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.nightcap.pewpew.PEWGame;
import com.nightcap.screens.GameScreen;

public class MainMenu implements Screen {
	private Skin skin;
	private Stage stage;
	private BitmapFont bfont;
	private Pixmap pixmap;
	private Table table;

	private PEWGame game;

	final private float[] backgroundColor = new float[3];

	public MainMenu(PEWGame game) {
		// Note: Background Color RGB Range: 0-1
		backgroundColor[0] = 0.2f;
		backgroundColor[1] = 0.2f;
		backgroundColor[2] = 0.2f;
		this.game = game;
		create();
	}

	public void create() {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

		// A skin can be loaded via JSON or defined programmatically, either is
		// fine. Using a skin is optional but strongly recommended solely for
		// the convenience of getting a texture, region, etc as a drawable,
		// tinted drawable, etc.

		// Note: Here begins the skin setup.
		skin = new Skin();

		// Generate a 1x1 white texture and store it in the skin named "white".
		// Note: Button size
		pixmap = new Pixmap(125, 75, Format.RGBA8888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		skin.add("white", new Texture(pixmap));

		// Store the font under the name "default".
		// Note: Has to be moved to AssetLoader (FosLoader) - Maybe.
		bfont = new BitmapFont();
		skin.add("default", bfont);

		// Configure a TextButtonStyle and name it "default". Skin resources are
		// stored by type, so this doesn't overwrite the font.
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.newDrawable("white", Color.TEAL);
		textButtonStyle.down = skin.newDrawable("white", Color.TEAL);
		textButtonStyle.checked = skin.newDrawable("white", Color.NAVY);
		textButtonStyle.over = skin.newDrawable("white", Color.CYAN);

		textButtonStyle.font = skin.getFont("default");

		skin.add("default", textButtonStyle);
		// Note: Skin setup's end

		// Create a button with the "default" TextButtonStyle. A 3rd parameter
		// can be used to specify a name other than "default".
		final TextButton playButton = new TextButton("Play", textButtonStyle);
		final TextButton settingsButton = new TextButton("Settings",
				textButtonStyle);
		final TextButton exitButton = new TextButton("Exit", textButtonStyle);

		table = new Table();
		table.setFillParent(true);
		table.add(playButton).pad(50);
		table.row();
		table.add(settingsButton).pad(50);
		table.row();
		table.add(exitButton).pad(50);

		stage.addActor(table);

		playButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(new GameScreen(game));

			}
		});

		settingsButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(new SettingsMenu(game));

			}
		});
		
		exitButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				game.dispose();
				game.getScreen().dispose();
				Gdx.app.exit();
			}
		});
	}

	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(backgroundColor[0], backgroundColor[1],
				backgroundColor[2], 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(delta, 1 / 30f));
		stage.draw();
		stage.setDebugAll(true);
	}

	@Override
	public void dispose() {
		stage.dispose();
		skin.dispose();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}
}
