package com.btwasilow.musicplayer.component;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import com.btwasilow.musicplayer.input.InputHandler;

public class MiniPlayerBox extends NonClickableComponent {
	// singleton
	private static MiniPlayerBox miniPlayerBox = new MiniPlayerBox();
	
	private final Rectangle2D.Double outerRectangleFillShape = new Rectangle2D.Double(0, 0, 350, 150);
	private final Color outerRectangleFillColor = new Color(64, 64, 64);
	
	private final RoundRectangle2D.Double outerRectangleOutlineShape = new RoundRectangle2D.Double(0, 0, 349, 149, 15, 15);
	private final Color outerRectangleOutlineColor = new Color(30, 30, 30);
	
	private final RoundRectangle2D.Double innerRectangleOutlineShape = new RoundRectangle2D.Double(1, 1, 347, 147, 15, 15);
	private final Color innerRectangleOutlineColor = new Color(100, 100, 100);
	
	
	private MiniPlayerBox() {
	}
	
	public static MiniPlayerBox getInstance() {
		return miniPlayerBox;
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(outerRectangleFillColor);
		g.fill(outerRectangleFillShape);
		
		g.setColor(outerRectangleOutlineColor);
		g.draw(outerRectangleOutlineShape);
		
		g.setColor(innerRectangleOutlineColor);
		g.draw(innerRectangleOutlineShape);
	}
}
