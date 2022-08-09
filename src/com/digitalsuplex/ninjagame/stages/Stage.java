package com.digitalsuplex.ninjagame.stages;

import java.awt.Graphics;

import com.digitalsuplex.ninjagame.Handler;
import com.digitalsuplex.ninjagame.entities.Enemy;
import com.digitalsuplex.ninjagame.entities.EntityManager;
import com.digitalsuplex.ninjagame.entities.Player;
import com.digitalsuplex.ninjagame.gfx.Tile;
import com.digitalsuplex.ninjagame.utils.Utils;

public class Stage {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	//Entities
	private EntityManager entityManager;

	
	public Stage(Handler handler, String path){
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		
		loadStage(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		
		entityManager.addEntity(new Enemy(handler, 200, 300));
	}
	
	public void tick(){
		entityManager.tick();
	}
	
	public void render(Graphics g){
		int xEnd = (int) Math.min(width, handler.getGame().getWidth() / Tile.TILEWIDTH + 1);
		int yEnd = (int) Math.min(height, handler.getGame().getHeight() / Tile.TILEHEIGHT + 1);
		
		for(int y = 0;y < yEnd;y++){
			for(int x = 0;x < xEnd;x++){
				getTile(x, y).render(g, (int) x * Tile.TILEWIDTH, (int) y * Tile.TILEHEIGHT);
			}
		}
		
		//Entities
		entityManager.render(g);
		
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.tiles[0];
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.tiles[0];
		return t;
	}
	
	private void loadStage(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		Tile.loadTiles();
		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public Player getPlayer() {
		return entityManager.getPlayer();
	}
	
}

