package com.digitalsuplex.ninjagame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	
	public boolean up, down, left, right,
		 start, select, button1, button2,
		 button3, button4, shoulder1, shoulder2,
		 shoulder3, shoulder4;
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		up = keys[KeyEvent.VK_W];
		left = keys[KeyEvent.VK_A];
		down = keys[KeyEvent.VK_S];
		right = keys[KeyEvent.VK_D];
		button1 = keys[KeyEvent.VK_J];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
