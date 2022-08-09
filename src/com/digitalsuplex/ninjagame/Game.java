package com.digitalsuplex.ninjagame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.digitalsuplex.ninjagame.gfx.Assets;
import com.digitalsuplex.ninjagame.input.KeyManager;
import com.digitalsuplex.ninjagame.states.GameState;
import com.digitalsuplex.ninjagame.states.State;

public class Game implements Runnable {

	private Display display;
	private int width, height;
	private String title;
	
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//Physics
	private PhysicsManager physicsManager;
	//Rate of gravity in frames is 0.19 frames times ratio to Earth's gravity.
	private float gravity = ( 1.0f ) * ( 0.19f );
	
	//States
	private State gameState;
	
	//Input
	private KeyManager keyManager;
	
	//Handler
	private Handler handler;
	
	//Camera
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		
		keyManager = new KeyManager();
	}
	
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);

		handler = new Handler(this);

		Assets.init();
		
		gameState = new GameState(handler);
		State.setState(gameState);
		
		physicsManager = new PhysicsManager(handler);
	}
	
	private void tick() {
		keyManager.tick();
		if (State.getState() != null)
			State.getState().tick();
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Here!
	
		if (State.getState() != null)
			State.getState().render(g);
				
		//End Drawing!
		bs.show();
		g.dispose();
	}

	public void run(){
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		
		@SuppressWarnings("unused")
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				// System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}

	public float getGravity() {
		return gravity;
	}

	public void setGravity(float gravity) {
		this.gravity = gravity;
	}

	public PhysicsManager getPhysicsManager() {
		return physicsManager;
	}

}