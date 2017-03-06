package com.btwasilow.musicplayer.component;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import com.btwasilow.musicplayer.input.InputHandler;

public class ExitButton extends ClickableComponent {
	// singleton
	private static ExitButton exitButton = new ExitButton();
	
	private final Ellipse2D.Double boundingBox = new Ellipse2D.Double(328, 8, 14, 14);
	
	private final Ellipse2D.Double unHoveredOuterCircleFillShape = new Ellipse2D.Double(328, 8, 14, 14);
	private final Color unHoveredOuterCircleFillColor = new Color(30, 30, 30);
	
	private final Ellipse2D.Double unHoveredInnerCircleFillShape = new Ellipse2D.Double(330, 10, 10, 10);
	private final Color unHoveredInnerCircleFillColor = new Color(255, 0, 0);
	
	private final Ellipse2D.Double hoveredOuterCircleFillShape = new Ellipse2D.Double(328, 8, 14, 14);
	private final Color hoveredOuterCircleFillColor = new Color(200, 200, 200);
	
	private final Ellipse2D.Double hoveredInnerCircleFillShape = new Ellipse2D.Double(330, 10, 10, 10);
	private final Color hoveredInnerCircleFillColor = new Color(255, 0, 0);

	private ExitButton() {
	}
	
	public static ExitButton getInstance() {
		return exitButton;
	}
	
	@Override
	public Shape getBoundingBox() {
		return boundingBox;
	}

	@Override
	public void render(Graphics2D g) {
		if (!hoveredOver) {
			g.setColor(unHoveredOuterCircleFillColor);
			g.fill(unHoveredOuterCircleFillShape);
			
			g.setColor(unHoveredInnerCircleFillColor);
			g.fill(unHoveredInnerCircleFillShape);
		} else {
			g.setColor(hoveredOuterCircleFillColor);
			g.fill(hoveredOuterCircleFillShape);
			
			g.setColor(hoveredInnerCircleFillColor);
			g.fill(hoveredInnerCircleFillShape);
		}
	}

	@Override
	public void updateClickState(InputHandler input) {
		System.exit(0);
	}
}
