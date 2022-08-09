package com.digitalsuplex.ninjagame;

import com.digitalsuplex.ninjagame.entities.Player;
import com.digitalsuplex.ninjagame.stages.Stage;

public class Handler {
	
	private Game game;
	private Stage stage;
	
	public Handler(Game game) {
		this.game = game;
	}

	public Game getGame() {
		return game;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Player getPlayer() {
		return getStage().getPlayer();
	}

	public PhysicsManager getPhysicsManager() {
		return game.getPhysicsManager();
	}
	
}
