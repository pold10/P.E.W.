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

	private PEWGame game;

	public MainMenu(PEWGame game) {
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
		pixmap = new Pixmap(100, 100, Format.RGBA8888);
		pixmap.setColor(Color.GREEN);
		pixmap.fill();
		skin.add("white", new Texture(pixmap));

		// Store the font under the name "default".
		// Note: Has to be moved to AssetLoader (FosLoader).
		bfont = new BitmapFont();
		skin.add("default", bfont);

		// Configure a TextButtonStyle and name it "default". Skin resources are
		// stored by type, so this doesn't overwrite the font.
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.down = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
		textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);

		textButtonStyle.font = skin.getFont("default");

		skin.add("default", textButtonStyle);
		// Note: Skin setup's end

		// Create a button with the "default" TextButtonStyle. A 3rd parameter
		// can be used to specify a name other than "default".
		final TextButton textButton = new TextButton("PLAY", textButtonStyle);
		textButton.setPosition(200, 200);
		stage.addActor(textButton);
		// For some reason the guide uses this command three times.
		// stage.addActor(textButton);
		// stage.addActor(textButton);

		// Add a listener to the button. ChangeListener is fired when the
		// button's checked state changes, eg when clicked, Button#setChecked()
		// is called, via a key press, etc. If the event.cancel() is called, the
		// checked state will be reverted.

		// ClickListener could have been used, but would only fire when clicked.
		// Also, canceling a ClickListener event won't revert the checked state.
		textButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				// System.out.println("Clicked! Is checked: " +
				// button.isChecked());
				textButton.setText("Starting new game");
				game.setScreen(new GameScreen());

			}
		});
	}

	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
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
