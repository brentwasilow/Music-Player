package com.btwasilow.musicplayer.button;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import com.btwasilow.musicplayer.input.InputHandler;

public class CenterButton extends Button {
	// singleton
	private static CenterButton centerButton = new CenterButton();
	
	private final Ellipse2D.Double boundingBox = new Ellipse2D.Double(185, 21,  60,  60);
	
	private CenterButton() {
	}
	
	public static CenterButton getInstance() {
		return centerButton;
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
