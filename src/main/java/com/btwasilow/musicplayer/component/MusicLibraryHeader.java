package com.btwasilow.musicplayer.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class MusicLibraryHeader extends NonClickableComponent {
	// singleton
	private static MusicLibraryHeader musicLibraryHeader = new MusicLibraryHeader();
	
	private MusicLibraryHeader() {
	}
	
	public static MusicLibraryHeader getInstance() {
		return musicLibraryHeader;
	}
	
	@Override
	public void render(Graphics2D g) {
		if (ExpandMusicPlayerButton.getInstance().isSelected()) {
			// font setup (italic)
			g.setFont(new Font("Arial", 3, 12));
		
			// set color and draw darker header inset
			g.setColor(new Color(30, 30, 30));
			g.drawString("Name", 27, 202);
			g.drawString("Time", 167, 202);
			g.drawString("Artist", 216, 202);
	    
			// draw lines separating each header piece
			g.drawLine(156, 192, 156, 202);
			g.drawLine(205, 192, 205, 202);
	    
			// draw lighter header fill
			g.setColor(new Color(175, 175, 175));
			g.drawString("Name", 25, 200);
			g.drawString("Time", 165, 200);
			g.drawString("Artist", 214, 200);
	    
			// draw same header lines
			g.drawLine(154, 190, 154, 200);
			g.drawLine(203, 190, 203, 200);
		}
	}
}
