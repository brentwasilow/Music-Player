package com.btwasilow.musicplayer.component;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class ExpandedMusicPlayerBox extends NonClickableComponent {
	// singleton
	private static ExpandedMusicPlayerBox expandedMusicPlayerBox = new ExpandedMusicPlayerBox();
	
	private final Rectangle2D.Double outerRectangleFillShape = new Rectangle2D.Double(0, 150, 350, 400);
	private final Color outerRectangleFillColor = new Color(64, 64, 64);
	
	private final RoundRectangle2D.Double outerRectangleOutlineShape1 = new RoundRectangle2D.Double(0, 150, 349, 499, 15, 15);
	private final Color outerRectangleOutlineColor1 = new Color(30, 30, 30);
	
	private final RoundRectangle2D.Double outerRectangleOutlineShape2 = new RoundRectangle2D.Double(1, 151, 347, 397, 15, 15);
	private final Color outerRectangleOutlineColor2 = new Color(100, 100, 100);
	
	private final RoundRectangle2D.Double innerRectangleFillShape = new RoundRectangle2D.Double(10, 180, 328, 358, 10, 10);
	private final Color innerRectangleFillColor = new Color(50, 50, 50);
	
	private final RoundRectangle2D.Double innerRectangleOutlineShape = new RoundRectangle2D.Double(9, 179, 331, 361, 10, 10);
	private final Color innerRectangleOutlineColor = new Color(30, 30, 30);
	
	
	private ExpandedMusicPlayerBox() {
	}
	
	public static ExpandedMusicPlayerBox getInstance() {
		return expandedMusicPlayerBox;
	}

	@Override
	public void render(Graphics2D g) {
		if (ExpandMusicPlayerButton.getInstance().isSelected()) {
			g.setColor(outerRectangleFillColor);
			g.fill(outerRectangleFillShape);
			
			g.setColor(outerRectangleOutlineColor1);
			g.draw(outerRectangleOutlineShape1);
			
			g.setColor(outerRectangleOutlineColor2);
			g.draw(outerRectangleOutlineShape2);
			
			g.setColor(innerRectangleFillColor);
			g.fill(innerRectangleFillShape);
			
			g.setColor(innerRectangleOutlineColor);
			g.draw(innerRectangleOutlineShape);
		}
	}
}
