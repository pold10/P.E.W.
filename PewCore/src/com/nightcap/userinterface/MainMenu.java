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
		// Note: Has to be moved to AssetLoader (FosLoader).
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

		// Note: Unneeded part using Table
		// playButton.setPosition(200, 600);
		// settingsButton.setPosition(200, 400);
		// exitButton.setPosition(200, 200);
		// stage.addActor(playButton);
		// stage.addActor(settingsButton);
		// stage.addActor(exitButton);

		// For some reason the guide uses this command three times.
		// stage.addActor(textButton);
		// stage.addActor(textButton);

		// Add a listener to the button. ChangeListener is fired when the
		// button's checked state changes, eg when clicked, Button#setChecked()
		// is called, via a key press, etc. If the event.cancel() is called, the
		// checked state will be reverted.

		// ClickListener could have been used, but would only fire when clicked.
		// Also, canceling a ClickListener event won't revert the checked state.
		playButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(new GameScreen());

			}
		});

		settingsButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(new SettingsMenu(game));

			}
		});
		
		exitButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
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
		// Note: This method is deprecated.
		// Tablet.drawDebug(stage)
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
