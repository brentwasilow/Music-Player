package com.btwasilow.musicplayer.render;

import java.awt.Color;
import java.awt.Graphics2D;

public class RenderMiniPlayer {
	private RenderMiniPlayer() {
	}
	
	public static void render(Graphics2D g) {
		renderBackground(g);
	}
	
	private static void renderBackground(Graphics2D g) {
		// dark gray fill
		g.setColor(new Color(64, 64, 64));
		g.fillRect(0, 0, 350, 150);
		
		// dark black outline to frame component
		g.setColor(new Color(30, 30, 30));
		g.drawRoundRect(0, 0, 349, 149, 15, 15);
		
		// whiter in-set line to give depth at corner
		g.setColor(new Color(100, 100, 100));
		g.drawRoundRect(1, 1, 350-3, 150-3, 15, 15);
	}
}
