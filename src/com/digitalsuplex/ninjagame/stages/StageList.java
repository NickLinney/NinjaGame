package com.digitalsuplex.ninjagame.stages;

public enum StageList {

	LevelOne("res/stages/LevelOne.txt");

	private String path;

	StageList(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
}