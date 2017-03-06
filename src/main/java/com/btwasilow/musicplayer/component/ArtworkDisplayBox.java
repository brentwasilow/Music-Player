package com.btwasilow.musicplayer.component;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

public class ArtworkDisplayBox extends NonClickableComponent {
	// singleton
	private static ArtworkDisplayBox artworkDisplayBox = new ArtworkDisplayBox();
	
	private final RoundRectangle2D.Double outerRectangleFillShape = new RoundRectangle2D.Double(20, 20, 60, 60, 10, 10);
	private final Color outerRectangleFillColor = new Color(50, 50, 50);
	
	private final RoundRectangle2D.Double outerRectangleOutlineShape = new RoundRectangle2D.Double(19, 19, 62, 62, 10, 10);
	private final Color outerRectangleOutlineColor = new Color(30, 30, 30);
	
	private ArtworkDisplayBox() {	
	}
	
	public static ArtworkDisplayBox getInstance() {
		return artworkDisplayBox;
	}
	
	@Override
	public void render(Graphics2D g) {
		g.setColor(outerRectangleFillColor);
		g.fill(outerRectangleFillShape);
		
		g.setColor(outerRectangleOutlineColor);
		g.draw(outerRectangleOutlineShape);
	}
}
