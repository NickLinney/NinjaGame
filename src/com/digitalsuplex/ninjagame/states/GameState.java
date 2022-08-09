package com.digitalsuplex.ninjagame.states;

import java.awt.Graphics;

import com.digitalsuplex.ninjagame.Handler;
import com.digitalsuplex.ninjagame.stages.Stage;
import com.digitalsuplex.ninjagame.stages.StageList;

public class GameState extends State {
	
	private Stage stage;
	
	public GameState(Handler handler){
		super(handler);
		stage = new Stage(handler, StageList.LevelOne.getPath());
		handler.setStage(stage);
	}
	
	@Override
	public void tick() {
		stage.tick();
	}

	@Override
	public void render(Graphics g) {
		stage.render(g);
	}

}