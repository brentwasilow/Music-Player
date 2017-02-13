package com.btwasilow.musicplayer.render;

import java.awt.Color;
import java.awt.Graphics2D;

public class RenderMiniPlayer {
	private RenderMiniPlayer() {
	}
	
	public static void render(Graphics2D g) {
		renderBackground(g);
		renderArtworkDisplayBox(g);
		renderCenterButton(g);
		renderLeftButton(g);
		renderRightButton(g);
		renderTimeBar(g);
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
	
	private static void renderArtworkDisplayBox(Graphics2D g) {
		// dark fill box (darker than miniplayer background)
		g.setColor(new Color(50, 50, 50));
		g.fillRoundRect(20, 20, 60, 60, 10, 10);
		
		// fill box outline to provide contrast
		g.setColor(new Color(30, 30, 30));
		g.drawRoundRect(19, 19, 62, 62, 10, 10);
	}
	
	private static void renderCenterButton(Graphics2D g) {
		// dark fill oval (darker than miniplayer background)
		g.setColor(new Color(40, 40, 40));
		g.fillOval(185, 21,  60,  60);
		
		// light fill oval to provide contrast
		g.setColor(new Color(100, 100, 100));
		g.fillOval(190, 26, 50, 50);
	}
	
	private static void renderLeftButton(Graphics2D g) {
		// dark left fill oval (smaller than center button)
		g.setColor(new Color(40, 40, 40));
		g.fillOval(114, 26, 50, 50);

		// light fill oval (also smaller than center button)
		g.setColor(new Color(100, 100, 100));
		g.fillOval(119, 31, 40, 40);
	}
	
	private static void renderRightButton(Graphics2D g) {
		// dark right fill oval (smaller than center button)
		g.setColor(new Color(40, 40, 40));
		g.fillOval(264, 26, 50, 50);

		// right fill oval (also smaller than center button)
		g.setColor(new Color(100, 100, 100));
		g.fillOval(269, 31, 40, 40);
	}
	
	private static void renderTimeBar(Graphics2D g) {
		// dark time bar fill
		g.setColor(new Color(50, 50, 50));
		g.fillRoundRect(10, 131, 328, 7, 4, 4);
		
		// darker time bar inset
		g.setColor(new Color(30, 30, 30));
		g.drawRoundRect(9, 130, 330, 9, 4, 4);
	}
}
