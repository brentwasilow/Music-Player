package com.btwasilow.musicplayer;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.btwasilow.musicplayer.input.InputHandler;
import com.btwasilow.musicplayer.render.RenderMiniPlayer;
import com.btwasilow.musicplayer.timer.Timer;

public class Driver extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	
	private Thread thread;
	private boolean running = false;
	
	private InputHandler input;
	
	private Timer timer;
	
	private Graphics2D g;

	public Driver() {
		// setup routines
		setupGUI();
		setupInput();
		timer = new Timer();
		
		// start the program
		start();
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
		double ups = 120.0;

		// game loop using preset update rate with unbounded frame rate
		while (running) {
			requestFocus();

			final double ns = 1000000000.0 / ups;
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;

			if ((System.currentTimeMillis() - timer) > 1000) {
				timer += 1000;
				System.out.println(updates + " ups" + " | " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();

		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		// get graphics and set antialiasing
		g = (Graphics2D) bs.getDrawGraphics();	
	    RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g.setRenderingHints(rh);
	    
	    // rendering methods
	    RenderMiniPlayer.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public void update() {
		input.update();
		timer.update();
	}
	
	private void setupGUI() {
		// graphical user interface (GUI) setup
		setUndecorated(true);
		setShape(new RoundRectangle2D.Double(0, 0, 350, 150, 15, 15));  // miniplayer = (350x150) | fullplayer = (350x400)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setMinimumSize(new Dimension(350, 150));
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void setupInput() {
		// setup input handling operations
		input = new InputHandler(this);
		addMouseMotionListener(input);
		addMouseListener(input);
		addKeyListener(input);
		addFocusListener(input);
	}
	
	public static void main(String[] args) {
		new Driver();
	}

}
