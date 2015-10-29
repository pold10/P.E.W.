package com.nightcap.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class SmallEnemy implements Enemy {
	private Vector2 position;
	private int width = 24, height = 24;
	private boolean alive = true;

	// Shapes for collisions
	private Rectangle collisionArea;

	public SmallEnemy(int x, int y) {
		position = new Vector2(x, y);
		collisionArea = new Rectangle();
	}

	@Override
	public void shoot(int posX, int posY, int dX, int dY) {
		// TODO Auto-generated method stub

	}

	@Override
	public void die() {
		alive = false;
	}

	@Override
	public void update(float delta) {
		collisionArea.set(position.x, position.y, width, height);
	}

	// Getters
	public Vector2 getPosition() {
		return position;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public Rectangle getCollisionArea() {
		return collisionArea;
	}

	@Override
	public boolean isAlive() {
		return alive;
	}

	@Override
	public float getX() {
		return position.x;
	}

	@Override
	public float getY() {
		return position.y;
	}

	// Setters
	@Override
	public void setX(int x) {
		position.x = x;
	}

	@Override
	public void setY(int y) {
		position.y = y;
	}

	public void setCollisionArea(Rectangle collisionArea) {
		this.collisionArea = collisionArea;
	}

}
