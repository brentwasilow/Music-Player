package com.btwasilow.musicplayer.button;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import com.btwasilow.musicplayer.input.InputHandler;

public class LeftButton extends Button {
	// singleton
	private static LeftButton leftButton = new LeftButton();
	
	private final Ellipse2D.Double boundingBox = new Ellipse2D.Double(114, 26, 50, 50);
	
	private LeftButton() {
	}
	
	public static LeftButton getInstance() {
		return leftButton;
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
