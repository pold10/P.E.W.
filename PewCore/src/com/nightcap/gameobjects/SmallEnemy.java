package com.nightcap.gameobjects;

public class SmallEnemy implements Enemy {
	int xPos, yPos;
	boolean Alive = true;

	public SmallEnemy(int x, int y) {
		xPos = x;
		yPos = y;
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
	public int getX() {
		return xPos;
	}

	@Override
	public int getY() {
		return yPos;
	}

	@Override
	public void setX(int x) {
		xPos = x;
	}

	@Override
	public void setY(int y) {
		yPos = y;
	}

}
