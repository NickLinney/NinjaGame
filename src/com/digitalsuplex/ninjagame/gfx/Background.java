package com.digitalsuplex.ninjagame.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Background {
	
	private BufferedImage image;
	private float x, y, dx, dy;
	private float moveScale;
	
	public Background(String s, float moveScale) {
		image = Assets.background1;
		this.moveScale = moveScale;
	}
	
	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void setVector(float dx, float dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.drawImage(image, (int) x, (int) y, null);
		
		if (x < 0)
			g.drawImage(image, (int) x, (int) y, null);
		if (x > 0)
			g.drawImage(image, (int) x, (int) y, null);
		
	}

}
