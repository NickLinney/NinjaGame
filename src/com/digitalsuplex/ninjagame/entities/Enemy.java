package com.digitalsuplex.ninjagame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.digitalsuplex.ninjagame.Handler;
import com.digitalsuplex.ninjagame.gfx.Animation;
import com.digitalsuplex.ninjagame.gfx.Assets;

public class Enemy extends Creature {

	private static final int DEFAULT_HEALTH = 8,
		DEFAULT_SPEED = 3;
	
	private static final int DEFAULT_WIDTH = 64,
		DEFAULT_HEIGHT = 64;
	
	private static final int DEFAULT_JUMP_HEIGHT = 64;
	
	private Animation walk;
	
	public Enemy(Handler handler, int x, int y) {
		super(handler, x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.health = DEFAULT_HEALTH;
		this.speed = DEFAULT_SPEED;
		this.jumpHeight = DEFAULT_JUMP_HEIGHT;
		
		//Animations
		walk = new Animation(200, Assets.player_walk);
		
		//Custom Bounds
		bounds = new Rectangle(20, 4, 26, 60);
	}

	public void tick() {
		handler.getPhysicsManager().move(this, xMove, yMove);
		
		//Animations
		walk.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) x, (int) y, width, height, null);
		
		//g.setColor(Color.red);
		//g.fillRect((int)x, (int) y, bounds.width, bounds.height);
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		return walk.getCurrentFrame();
	}

}
