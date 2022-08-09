package com.digitalsuplex.ninjagame.entities;

import com.digitalsuplex.ninjagame.Handler;

public abstract class Creature extends Entity {

	protected int health, speed;
	protected boolean isJumping;
	protected int jumpHeight;
	
	public Creature(Handler handler, int x, int y, int width, int height) {
		super(handler, x, y, width, height);
	}
	
	public void jump() {
		if (!isJumping) {
			isJumping = true;
		}
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isJumping() {
		return isJumping;
	}

	public void setJumping(boolean isJumping) {
		this.isJumping = isJumping;
	}

}
