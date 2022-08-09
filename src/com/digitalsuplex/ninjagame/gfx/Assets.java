package com.digitalsuplex.ninjagame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public final static int width = 64, height = 64;

	public static BufferedImage player, blank, floor, background1;
	public static BufferedImage[] player_walk;
	
	public static void init() {
		SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/gfx/scifi_floor.png"));
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/gfx/player_stand.png"));
		SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/gfx/background1.png"));
		SpriteSheet sheet4 = new SpriteSheet(ImageLoader.loadImage("/gfx/player_walk01.png"));
		SpriteSheet sheet5 = new SpriteSheet(ImageLoader.loadImage("/gfx/player_walk02.png"));
		SpriteSheet sheet6 = new SpriteSheet(ImageLoader.loadImage("/gfx/blank.png"));
		
		blank = sheet6.crop(0, 0, width/2, height/2);
		floor = sheet1.crop(0, 0, width, height);
		player = sheet2.crop(0, 0, width/2, height/2);
		background1 = sheet3.crop(0, 0, width, height);
		
		//Animations
		player_walk = new BufferedImage[4];
		player_walk[0] = sheet4.crop(0, 0, width/2, height/2);
		player_walk[1] = sheet5.crop(0, 0, width/2, height/2);
		player_walk[2] = sheet4.crop(0, 0, width/2, height/2);
		player_walk[3] = sheet5.crop(0, 0, width/2, height/2);
		
	}

}
