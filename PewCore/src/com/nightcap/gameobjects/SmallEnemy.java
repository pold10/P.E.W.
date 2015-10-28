package com.nightcap.gameobjects;

import com.badlogic.gdx.math.Vector2;

public class SmallEnemy implements Enemy {
	private Vector2 position;
	private boolean Alive = true;

	public SmallEnemy(int x, int y) {
		position = new Vector2(x, y);
	}

	@Override
	public void shoot(int posX, int posY, int dX, int dY) {
		// TODO Auto-generated method stub

	}

	@Override
	public void die() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public float getX() {
		return position.x;
	}

	@Override
	public float getY() {
		return position.y;
	}

	@Override
	public void setX(int x) {
		position.x = x;
	}

	@Override
	public void setY(int y) {
		position.y = y;
	}

}
