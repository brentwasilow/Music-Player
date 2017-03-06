package com.btwasilow.musicplayer.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import com.btwasilow.musicplayer.state.State;

public class CurrentlyPlayingSongBox extends NonClickableComponent {
	// singleton
	private static CurrentlyPlayingSongBox currentlyPlayingSongBox = new CurrentlyPlayingSongBox();
	
	private static final Font font = new Font("Arial", 3, 12);
	private static final Color stringFillColor = new Color(50, 50, 50);
	private static final Color stringOutlineColor = new Color(175, 175, 175);
	
	private CurrentlyPlayingSongBox() {
	}
	
	public static CurrentlyPlayingSongBox getInstance() {
		return currentlyPlayingSongBox;
	}

	@Override
	public void render(Graphics2D g) {
		g.setFont(font);
		g.setColor(stringFillColor);
		g.drawString(State.currentlyPlayingSongName, 22, 114);
		
		g.setColor(stringOutlineColor);
		g.drawString(State.currentlyPlayingSongName, 20, 112);
	}
}
