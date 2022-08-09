package com.digitalsuplex.ninjagame.gfx;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Tile {
	
	//Statics
	
	public static Tile[] tiles = new Tile[256];
	
	//Class
	
	public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
	
	protected BufferedImage texture;
	protected final int id;
	protected boolean solid;
	
	public Tile(BufferedImage texture, int id, boolean solid){
		this.texture = texture;
		this.id = id;
		this.solid = solid;
		
		tiles[id] = this;
	}
	
	public static void loadTiles() {
		for (TileType type: TileType.values()) {
			tiles[type.getID()] = new Tile(type.getTexture(), type.getID(), type.isSolid());
		}
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
		if (id == 1)
			g.fillRect((x / TILEWIDTH) * TILEWIDTH, (y / TILEHEIGHT) * TILEHEIGHT, TILEWIDTH, TILEHEIGHT);
	}
	
	public boolean isSolid(){
		return solid;
	}
	
	public int getId(){
		return id;
	}

	public Rectangle getBounds(int x, int y) {
		return new Rectangle((x / TILEWIDTH) * TILEWIDTH, (y / TILEHEIGHT) * TILEHEIGHT, TILEWIDTH, TILEHEIGHT);
	}
	
}