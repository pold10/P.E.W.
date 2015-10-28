package com.nightcap.gameobjects;

public class PlayerProjectile {
	private float x, y, dx, dy;
	private boolean visible = true;

	public PlayerProjectile(float startX, float startY, float playerDx,
			float playerDy) {
		x = startX;
		y = startY;
		dx = playerDx / 3;
		dy = -400 + playerDy / 3;
	}

	public void update(float delta) {
		x += (int) dx * delta;
		y += (int) dy * delta;

		if (x < 0 || x > 640) {
			visible = false;
		} else if (y < 0) {
			visible = false;
		}
	}

	// Getters
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getDx() {
		return dx;
	}

	public float getDy() {
		return dy;
	}

	public boolean isVisible() {
		return visible;
	}

	// Setters
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
