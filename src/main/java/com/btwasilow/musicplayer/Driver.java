package com.btwasilow.musicplayer;

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.btwasilow.musicplayer.input.InputHandler;
import com.btwasilow.musicplayer.render.RenderPlayer;
import com.btwasilow.musicplayer.update.UpdatePlayer;
import com.btwasilow.musicplayer.utility.Consts;
import com.btwasilow.musicplayer.utility.Utility;

public class Driver extends JFrame implements Runnable {
	private static final long serialVersionUID = -252037378789659231L;
	
	private Thread thread;
	private boolean running = false;
	
	private InputHandler input;
	
	private Graphics2D g;

	public Driver() {
		// setup routines
		Utility.initialGUISetup(this);
		setupInput();
		
		// start the program
		start();
	}
	
	private void setupInput() {
		// setup input handling and associated listeners
		input = new InputHandler(this);
		
		addMouseMotionListener(input);
		addMouseListener(input);
		addKeyListener(input);
		addFocusListener(input);
		addMouseWheelListener(input);
	}
	
	public void start() {
		// starts the game thread
		running = true;
		
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double delta = 0;
		int frames = 0;
		int updates = 0;

		// game loop using preset update rate with unbounded frame rate
		while (running) {
			requestFocus();

			final double ns = Consts.NANOSECONDS_PER_SECOND / Consts.UPDATES_PER_SECOND;
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while (delta > 0) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;

			if ((System.currentTimeMillis() - timer) > Consts.MILLISECONDS_PER_SECOND) {
				timer += Consts.MILLISECONDS_PER_SECOND;
				System.out.println(updates + " ups" + " | " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
	}
	
	public void render() {
		// get the buffer for the JFrame and/or create one 
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(Consts.NUM_OF_STRATEGY_BUFFERS);
			return;
		}
		
		// get graphics and set antialiasing
		g = (Graphics2D) bs.getDrawGraphics();	
	    g.setRenderingHints(Consts.renderingHints);
	    
	    // perform ALL music player rendering
	    RenderPlayer.render(g, this);
		
		g.dispose();
		bs.show();
	}
	
	public void update() {
		// perform ALL music player updating
		UpdatePlayer.update(input);
	}
	
	public static void main(String[] args) {
		new Driver();
	}

}
