package com.nightcap.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Player {
	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;

	private int width;
	private int height;

	public Player(float x, float y, int width, int height) {
		this.width = width;
		this.height = height;
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 0);
	}

	public void update(float delta) {
		position.add(velocity.cpy().scl(delta));

		// Position boundaries
		if (position.x > 640) {
			position.x = 640;
		} else if (position.x < 0) {
			position.x = 0;
		}
		if (position.y > 960) {
			position.y = 960;
		} else if (position.y < 100) {
			position.y = 0;
		}

		// Acceleration is always half the inverse speed, approaching 0.
		acceleration.set(velocity.cpy().scl((float) -0.5));

		velocity.add(acceleration.cpy().scl(delta));

		// // Velocity boundaries. Not needed (yet)
		// if (velocity.x > 300) {
		// velocity.x = 300;
		// } else if (velocity.x < -300) {
		// velocity.x = -300;
		// }
		// if (velocity.y > 300) {
		// velocity.y = 300;
		// } else if (velocity.y < -300) {
		// velocity.y = -300;
		// }

	}

	// Movement actions
	public void up() {
		Gdx.app.log("Player", "UP");
		velocity.y = -200;
	}

	public void down() {
		Gdx.app.log("Player", "DOWN");
		velocity.y = 200;
	}

	public void right() {
		Gdx.app.log("Player", "RIGHT");
		velocity.x = 200;
	}

	public void left() {
		Gdx.app.log("Player", "LEFT");
		velocity.x = -200;
	}

	// Getters
	public float getX() {
		return position.x;
	}

	public float getY() {
		return position.y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

}
