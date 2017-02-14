package com.btwasilow.musicplayer.render;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import com.btwasilow.musicplayer.update.UpdateMiniPlayer;

public class RenderMiniPlayer {
	private static int currentlyPlayingSongTimePosition = 150; // for rendering blue time bar (hard coded for now)
	private static String currentlyPlayingSongName = "Dirty Sessions - NeverH..."; // (hard coded for now)
	private static int currentlyPlayingSongVolume = 50; // 100 is the max (hard coded for now)
	
	private RenderMiniPlayer() {
	}
	
	public static void render(Graphics2D g) {
		renderBackground(g);
		renderArtworkDisplayBox(g);
		
		renderCenterButton(g);
		renderLeftButton(g);
		renderRightButton(g);
		
		renderTimeBarBox(g);
		renderTimeBarFill(g);
		
		renderVolumeBarBox(g);
		renderVolumeBarFill(g);
		
		renderCurrentlyPlayingSong(g);
		
		renderMaximizeMusicPlayerButton(g);
		renderVolumeMuteButton(g);
		
		renderExitButton(g);
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
		if (!UpdateMiniPlayer.centerButtonHover) { 
			// dark fill oval (darker than miniplayer background)
			g.setColor(new Color(40, 40, 40));
			g.fillOval(185, 21,  60,  60);
		} else {
			// lighter fill oval when hovered over
			g.setColor(new Color(200, 200, 200));
			g.fillOval(185, 21, 60, 60);
		}
		// light fill oval to provide contrast
		g.setColor(new Color(100, 100, 100));
		g.fillOval(190, 26, 50, 50);
		
		// render play button triangle (always renders the same no matter if hovered or not)
		g.setColor(new Color(50, 50, 50));
		int[] x = {208, 208, 225};
		int[] y = {61, 41, 51};
		g.fillPolygon(x, y, 3);
	}
	
	private static void renderLeftButton(Graphics2D g) {
		if (!UpdateMiniPlayer.leftButtonHover) {
			// dark left fill oval (smaller than center button)
			g.setColor(new Color(40, 40, 40));
			g.fillOval(114, 26, 50, 50);
		} else {
			// lighter left fill oval if hovered over
			g.setColor(new Color(200, 200, 200));
			g.fillOval(114, 26, 50, 50);
		}
		// light fill oval (also smaller than center button)
		g.setColor(new Color(100, 100, 100));
		g.fillOval(119, 31, 40, 40);
		
		// render left button triangle and bar (same regardless of hover)
		int[] x = {147, 147, 134};
		int[] y = {58, 44, 51};
		g.setColor(new Color(50, 50, 50));
		g.fillPolygon(x, y, 3);
		g.fillRect(129, 44, 6, 15);
	}
	
	private static void renderRightButton(Graphics2D g) {
		if (!UpdateMiniPlayer.rightButtonHover) {
			// dark right fill oval (smaller than center button)
			g.setColor(new Color(40, 40, 40));
			g.fillOval(264, 26, 50, 50);
		} else {
			// lighter right fill oval if hovered over
			g.setColor(new Color(200, 200, 200));
			g.fillOval(264, 26, 50, 50);
		}
		// right fill oval (also smaller than center button)
		g.setColor(new Color(100, 100, 100));
		g.fillOval(269, 31, 40, 40);
		
		// render right button triangle and bar
		int[] x = {280, 280, 293};
		int[] y = {58, 44, 51};
		g.setColor(new Color(50, 50, 50));
		g.fillPolygon(x, y, 3);
		g.fillRect(292, 44, 6, 15);
	}
	
	private static void renderTimeBarBox(Graphics2D g) {
		// dark time bar fill
		g.setColor(new Color(50, 50, 50));
		g.fillRoundRect(10, 131, 328, 7, 4, 4);
		
		// darker time bar inset
		g.setColor(new Color(30, 30, 30));
		g.drawRoundRect(9, 130, 330, 9, 4, 4);
	}
	
	private static void renderTimeBarFill(Graphics2D g) {
		// blue time bar fill color
		g.setColor(new Color(161, 202, 241));
		g.fillRoundRect(10, 131, currentlyPlayingSongTimePosition, 7, 3, 3);
		
		// daker blue time bar fill outline
		g.setColor(new Color(100, 140, 180));
		g.drawRoundRect(10, 131, currentlyPlayingSongTimePosition, 7, 4, 4);
	}
	
	private static void renderVolumeBarBox(Graphics2D g) {
		// dark volume bar fill box
		g.setColor(new Color(50, 50, 50));
		g.fillRoundRect(237, 103, 100, 5, 4, 4);
		
		// darker volume bar outline
		g.setColor(new Color(30, 30, 30));
		g.drawRoundRect(236, 102, 102, 7, 4, 4);
	}
	
	private static void renderVolumeBarFill(Graphics2D g) {
		// green volume bar fill color
		g.setColor(new Color(90, 230, 0));
		g.fillRoundRect(237, 103, currentlyPlayingSongVolume, 5, 3, 3);
		
		// darker volume bar outline to provide contrast
		g.setColor(new Color(34, 140, 30));
		g.drawRoundRect(237, 103, currentlyPlayingSongVolume, 5, 4, 4);
	}
	
	private static void renderCurrentlyPlayingSong(Graphics2D g) {
		// draw current song using Arial font with dark fill
		g.setFont(new Font("Arial", 1, 12));
		g.setColor(new Color(50, 50, 50));
		g.drawString(currentlyPlayingSongName, 22, 114);
		
		// draw current song over dark fill with lighter fill to provide contrast
		g.setColor(new Color(175, 175, 175));
		g.drawString(currentlyPlayingSongName, 20, 112);
	}
	
	private static void renderMaximizeMusicPlayerButton(Graphics2D g) {
		// dark rectangle fill
		g.setColor(new Color(50, 50, 50));
		g.fillRoundRect(182, 98, 16, 16, 4, 4);
		
		// darker rectangle outline
		g.setColor(new Color(30, 30, 30));
		g.drawRoundRect(181, 97, 18, 17, 4, 4);
		
		// draw maximize music player representation (shown visually as items-in-a-list)
		g.setColor(new Color(150, 150, 150));
		g.drawLine(189,  101, 195, 101);
		g.drawLine(189,  104, 195, 104);
		g.drawLine(189, 107, 195, 107);
		g.drawLine(189,  110, 195, 110);
		g.fillOval(184, 101, 4, 4);
		g.fillOval(184, 107, 4, 4);
	}
	
	private static void renderVolumeMuteButton(Graphics2D g) {
		// lighter fill box
		g.setColor(new Color(50, 50, 50));
		g.fillRoundRect(209, 98, 16, 16, 4, 4);
		
		// darker fill box outline
		g.setColor(new Color(30, 30, 30));
		g.drawRoundRect(208, 97, 18, 17, 4, 4);
		
		// draw volume mute button representation (speaker with arc for noise disseminating outward)
		g.setColor(new Color(150, 150, 150));
		int[] volumeX = {219, 219, 212};
		int[] volumeY = {111, 100, 105};
		g.fillPolygon(volumeX, volumeY, 3);
		g.fillRect(212, 103, 4, 5);
		g.drawArc(218, 102, 4, 6, 0, -90);
		g.drawArc(218, 102, 4, 7, 0, 90);
	}
	
	private static void renderExitButton(Graphics2D g) {
		if (!UpdateMiniPlayer.exitButtonHover) {
			// dark fill circle in corner of music player
			g.setColor(new Color(30, 30, 30));
			g.fillOval(328, 8, 14, 14);
		
			// red fill circle as inset
			g.setColor(new Color(255, 0, 0));
			g.fillOval(330, 10, 10, 10);
		} else {
			// lighter fill circle in corner of music player
			g.setColor(new Color(200, 200, 200));
			g.fillOval(328, 8, 14, 14);
			
			// same red fill circle as inset
			g.setColor(new Color(255, 0, 0));
			g.fillOval(330, 10, 10, 10);
		}
	}
}
