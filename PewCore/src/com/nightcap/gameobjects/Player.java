package com.nightcap.gameobjects;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.nightcap.pewhelpers.AudioHandler;

public class Player {
	private Vector2 position;
	private Vector2 velocity;
	// private Vector2 acceleration;

	private int width;
	private int height;

	private static final double shootCD = 0.2;
	private double shootTimer = 0;

	// Projectiles
	private ArrayList<PlayerProjectile> projectiles = new ArrayList<PlayerProjectile>();

	public static float velocityLimit = 300; // Movement velocity

	public Player(float x, float y, int width, int height) {
		this.width = width;
		this.height = height;
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		// acceleration = new Vector2(0, 0);
	}

	public void update(float delta) {
		shootTimer += delta;

		position.add(velocity.cpy().scl(delta));

		// Position boundaries
		if (position.x > 640 - this.width) {
			position.x = 640 - this.width;
		} else if (position.x < 0) {
			position.x = 0;
		}
		if (position.y > 960 - this.height) {
			position.y = 960 - this.height;
		} else if (position.y < 100) {
			position.y = 100;
		}

		// Deceleration speed factor.
		// acceleration.set(velocity.cpy().scl((float) -0.9));
		//
		// velocity.add(acceleration.cpy().scl(delta));

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

		// Checks whether the projectile is inside the screen or not, if not, it
		// deletes it.
		for (int i = 0; i < projectiles.size(); i++) {
			PlayerProjectile p = (PlayerProjectile) projectiles.get(i);
			if (p.isVisible())
				p.update(delta);
			else
				projectiles.remove(i);
		}

	}

	public void shoot() {
		if (shootTimer > shootCD) {
			float velX = velocity.x, velY = velocity.y;
			AudioHandler.shoot.play();

			// Limit cases
			if (position.x <= 0 || position.x + width >= 640)
				velX = 0;
			if (position.y + height >= 960)
				velY = 0;
			projectiles.add(new PlayerProjectile(position.x + width / 2,
					position.y, velX, velY));
			shootTimer = 0;
		}
	}

	// Movement actions
	public void up() {
		velocity.y += -velocityLimit;
	}

	public void down() {
		velocity.y += velocityLimit;
	}

	public void right() {
		velocity.x += velocityLimit;
	}

	public void left() {
		velocity.x += -velocityLimit;
	}

	// Getters

	public ArrayList<PlayerProjectile> getProjectiles() {
		return projectiles;
	}

	public float getX() {
		return position.x;
	}

	public float getY() {
		return position.y;
	}

	public float getVelX() {
		return velocity.x;
	}

	public float getVelY() {
		return velocity.y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

}
