package com.nightcap.gameobjects;

import com.badlogic.gdx.math.Rectangle;

public interface Enemy {

	void shoot(int posX, int posY, int dX, int dY);

	void die();

	/*
	 * Movement Patterns:
	 * 0.- Stay
	 * 1.- Horizontal
	 */
	void update(float delta, int i);

	float getX();

	float getY();

	Rectangle getCollisionArea();

	boolean isAlive();

	void setX(int x);

	void setY(int y);

}
