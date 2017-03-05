package com.btwasilow.musicplayer.button;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import com.btwasilow.musicplayer.input.InputHandler;

public class RightButton extends Button {
	// singleton
	private static RightButton rightButton = new RightButton();
	
	private final Ellipse2D.Double boundingBox = new Ellipse2D.Double(264, 26, 50, 50);
	
	private RightButton() {
	}
	
	public static RightButton getInstance() {
		return rightButton;
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
		selected = true;
	}
}
