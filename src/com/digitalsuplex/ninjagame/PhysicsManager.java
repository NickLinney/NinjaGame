package com.digitalsuplex.ninjagame;

import java.awt.Rectangle;

import com.digitalsuplex.ninjagame.entities.Entity;
import com.digitalsuplex.ninjagame.entities.Player;
import com.digitalsuplex.ninjagame.gfx.Tile;

public class PhysicsManager {

	private Handler handler;
	private Player player;
	
	private float gravity;
	
	public PhysicsManager(Handler handler) {
		this.handler = handler;
		player = handler.getPlayer();
		setGravity(1.0f);
	}
	
	public boolean checkTileCollisions(float xOffset, float yOffset) {
		Rectangle path = getCollisionBounds(player, xOffset, yOffset);
		int startX = path.x / Tile.TILEWIDTH;
		int startY = path.y / Tile.TILEHEIGHT;
		int endX = (path.x + path.width) / Tile.TILEWIDTH;
		int endY = (path.y + path.height) / Tile.TILEHEIGHT;
		int tx, ty;
		
		for (tx = startX; tx <= endX; tx++) {
			for (ty = startY; ty <= endY; ty++) {
				return handler.getStage().getTile(tx, ty).isSolid();
			}
		}
		
		return false;
	}
	
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for(Entity e : handler.getStage().getEntityManager().getEntities()){
			if(e.equals(player))
				continue;
			if(getCollisionBounds(e, 0f, 0f).intersects(getCollisionBounds(player, xOffset, yOffset)))
				return true;
		}
		return false;
	}
	
	public Rectangle getCollisionBounds(Entity e, float xOffset, float yOffset) {
		return new Rectangle((int) (e.getX() + e.getBounds().x + xOffset), (int) (e.getY() + e.getBounds().y + yOffset), e.getBounds().width, e.getBounds().height);
	}

	private void moveX(Entity e, float tx){
		e.setX(e.getX() + tx);
	}
	
	private void moveY(Entity e, float ty){
		e.setY(e.getY() + ty);
	}
	
	public void move(Entity e, float tx, float ty){
		if(!checkEntityCollisions(tx, 0f) && !checkTileCollisions(tx, 0f))
			moveX(e, tx);
		if(!checkEntityCollisions(0f, ty) && !checkTileCollisions(0f, ty))
			moveY(e, ty);
	}

	public void fall(Entity e) {
	}

	public void setGravity(float gravity) {
		this.gravity = gravity * (0.19f);
	}
	
	public float getGravity() {
		return gravity;
	}

}
