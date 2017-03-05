package com.btwasilow.musicplayer.button;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import com.btwasilow.musicplayer.input.InputHandler;

public class ExpandMusicPlayerButton extends Button {
	// singleton
	private static ExpandMusicPlayerButton expandMusicPlayerButton = new ExpandMusicPlayerButton();
	
	private final RoundRectangle2D.Double boundingBox = new RoundRectangle2D.Double(181, 97, 18, 17, 4, 4);
	
	private ExpandMusicPlayerButton() {
	}
	
	public static ExpandMusicPlayerButton getInstance() {
		return expandMusicPlayerButton;
	}
	
	@Override
	public Shape getBoundingBox() {
		return boundingBox;
	}

	@Override
	public void render(Graphics2D g) {
	}

	@Override
	public void updateClickState(InputHandler input) {
		// switch music player mode based on current state
		// (make mini if already expanded or expand if already mini)
		if (selected) {
			selected = false;
		} else {
			selected = true;
		}
	}
}
