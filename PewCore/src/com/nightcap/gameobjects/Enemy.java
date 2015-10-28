package com.nightcap.gameobjects;

public interface Enemy {

	void shoot(int posX, int posY, int dX, int dY);
	
	void die();
	
	void update(float delta);
	
	float getX();
	
	float getY();
	
	void setX(int x);
	
	void setY(int y);
}
