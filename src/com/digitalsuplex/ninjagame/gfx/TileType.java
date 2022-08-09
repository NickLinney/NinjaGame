package com.digitalsuplex.ninjagame.gfx;

import java.awt.image.BufferedImage;

public enum TileType {

	blank(0, Assets.blank, false),
	SciFi_Floor(1, Assets.floor, true);
 
    private int id;
    private BufferedImage texture;
    private boolean solid;
 
    private TileType(int id, BufferedImage texture, boolean solid) {
        this.id = id;
        this.texture = texture;
        this.solid = solid;
    }
 
    static BufferedImage byID(int id) {
        for (TileType type: TileType.values()) {
            if (type.id == id) {
                return type.getTexture();
            }
        }
 
        return null;
    }
 
    public int getID() {
        return id;
    }

	public BufferedImage getTexture() {
		return texture;
	}

	public boolean isSolid() {
		return solid;
	}

}