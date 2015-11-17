package com.nightcap.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class SmallEnemy implements Enemy {
	private Vector2 position;
	private int width = 24, height = 24, movementPattern;
	private boolean alive = true;
	private String direction;

	// Shapes for collisions
	private Rectangle collisionArea;

	public SmallEnemy(int x, int y, int movementPattern) {
		position = new Vector2(x, y);
		collisionArea = new Rectangle();
		this.movementPattern = movementPattern;
	}

	@Override
	public void shoot(int posX, int posY, int dX, int dY) {
		// TODO Auto-generated method stub

	}

	@Override
	public void die() {
		alive = false;
	}

	/*
	 * Movement Patterns: 0.- Stay 1.- Horizontal
	 * 
	 * * More to be added *
	 */
	@Override
	public void update(float delta) {
		if (movementPattern == 1) {
			moveHorizontal(delta);
		}
		collisionArea.set(position.x, position.y, width, height);
	}

	private void moveHorizontal(float delta) {
		if (direction == "right")
			position.add(new Vector2(100, 0).scl(delta)); // Has to be changed
															// to velocity
		else
			position.add(new Vector2(-100, 0).scl(delta));

		if (position.x > 640 + 50)
			direction = "left";

		else if (position.x < -50)
			direction = "right";

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
