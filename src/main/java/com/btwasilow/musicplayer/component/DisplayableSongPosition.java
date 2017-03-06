package com.btwasilow.musicplayer.component;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import com.btwasilow.musicplayer.input.InputHandler;

public class DisplayableSongPosition extends ClickableComponent {
	private RoundRectangle2D.Double boundingBox;
	
	private RoundRectangle2D.Double outerRectangleFillShape;
	private Color outerRectangleFillColor = new Color(64, 64, 64);
	
	public DisplayableSongPosition(RoundRectangle2D.Double boundingBox, boolean selected) {
		this.boundingBox = boundingBox;
		this.outerRectangleFillShape = boundingBox;
		
		this.selected = selected;
	}
	
	@Override
	public Shape getBoundingBox() {
		return boundingBox;
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(outerRectangleFillColor);
		g.fill(outerRectangleFillShape);
	}

	@Override
	public void updateClickState(InputHandler input) {
	}
}
