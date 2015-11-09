package com.nightcap.userinterface;

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
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.nightcap.pewhelpers.PreferencesHandler;
import com.nightcap.pewpew.PEWGame;

public class SettingsMenu implements Screen {
	private PEWGame game;
	private Skin skin;
	private Stage stage;
	private BitmapFont bfont;
	private Pixmap pixmap;

	private Table table;

	final private float[] backgroundColor = new float[3];

	// Actors
	private Label menuTitle, audioCategory, videoCategory, volumeLabel;
	private TextButton audioOn, backButton;
	private Slider volumeSlider;

	public SettingsMenu(PEWGame game) {
		this.game = game;
		// Note: Background Color RGB Range: 0-1
		backgroundColor[0] = 0.2f;
		backgroundColor[1] = 0.2f;
		backgroundColor[2] = 0.2f;

		create();
	}

	public void create() {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

		// TextureAtlas atlas = new
		// TextureAtlas(Gdx.files.internal("skins/uiskin.atlas"));
		skin = new Skin();

		// Generate a 1x1 white texture and store it in the skin named "white".
		// Note: Button size
		pixmap = new Pixmap(125, 75, Format.RGBA8888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		skin.add("big", new Texture(pixmap));

		// Store the font under the name "default".
		// Note: Has to be moved to AssetLoader (FosLoader).
		bfont = new BitmapFont();
		skin.add("default", bfont);

		// Configure a TextButtonStyle and name it "default". Skin resources are
		// stored by type, so this doesn't overwrite the font.
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.newDrawable("big", Color.TEAL);
		textButtonStyle.down = skin.newDrawable("big", Color.TEAL);
		textButtonStyle.checked = skin.newDrawable("big", Color.NAVY);
		textButtonStyle.over = skin.newDrawable("big", Color.CYAN);

		textButtonStyle.font = skin.getFont("default");

		// Label Style for the skin
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = skin.getFont("default");

		// Slyder Style
		pixmap = new Pixmap(150, 20, Format.RGBA8888);
		pixmap.setColor(Color.PURPLE);
		pixmap.fill();
		skin.add("sliderB", new Texture(pixmap));
		pixmap = new Pixmap(20, 20, Format.RGBA8888);
		pixmap.setColor(Color.PURPLE);
		pixmap.fill();
		skin.add("sliderK", new Texture(pixmap));
		SliderStyle sliderStyle = new SliderStyle(skin.newDrawable("sliderB",
				Color.DARK_GRAY), skin.newDrawable("sliderK", Color.GRAY));

		skin.add("default", textButtonStyle);
		skin.add("default", labelStyle);
		skin.add("default-horizontal", sliderStyle);

		// Actors
		menuTitle = new Label("Settings", skin);
		menuTitle.setFontScale(1.5f);
		// audioCategory = new Label("Audio", skin);
		// videoCategory = new Label("Video", skin);

		audioOn = new TextButton("Audio: Off", skin);
		volumeLabel = new Label("Volume: 0", skin);
		volumeSlider = new Slider(0f, 100f, 1f, false, skin);

		backButton = new TextButton("Back", skin);

		// Load presets
		loadPresets();

		table = new Table();
		table.setFillParent(true);
		table.add(menuTitle).pad(50).colspan(2);

		// table.row();
		// table.add(audioCategory).pad(50);
		// table.add(videoCategory).pad(50);

		table.row();
		table.add(audioOn);

		table.row();
		table.add(volumeLabel);
		table.add(volumeSlider);

		table.row();
		table.add();
		table.add(backButton).pad(50).right();

		stage.addActor(table);

		// Button Listeners
		audioOn.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				if (audioOn.isChecked())
					audioOn.setText("Audio: On");
				else
					audioOn.setText("Audio: Off");
				PreferencesHandler.AudioToggle();
			}
		});

		volumeSlider.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				int volume = (int) volumeSlider.getValue(); // Knob Value
				volumeLabel.setText("Volume: " + volume);
				PreferencesHandler.setVolume(volume);
			}
		});

		backButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				game.getScreen().hide();
				game.setScreen(new MainMenu(game));
			}
		});
	}

	private void loadPresets() {
		if (PreferencesHandler.AudioOn()) {
			audioOn.setChecked(true);
			audioOn.setText("Audio: On");
		}
		volumeLabel.setText("Volume: " + (int) PreferencesHandler.getVolume());
		volumeSlider.setValue(PreferencesHandler.getVolume());
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
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

}
