package com.btwasilow.musicplayer.component;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import com.btwasilow.musicplayer.input.InputHandler;

public class RightButton extends ClickableComponent {
	// singleton
	private static RightButton rightButton = new RightButton();
	
	private final Ellipse2D.Double boundingBox = new Ellipse2D.Double(264, 26, 50, 50);
	
	private final Ellipse2D.Double unHoveredOuterEllipticalFillShape = new Ellipse2D.Double(264, 26, 50, 50);
	private final Color unHoveredOuterEllipticalFillColor = new Color(40, 40, 40);
	
	private final Ellipse2D.Double hoveredOuterEllipticalFillShape = new Ellipse2D.Double(264, 26, 50, 50);
	private final Color hoveredOuterEllipticalFillColor = new Color(200, 200, 200);
	
	private final Ellipse2D.Double innerEllipticalFillShape = new Ellipse2D.Double(269, 31, 40, 40);
	private final Color innerEllipticalFillColor = new Color(100, 100, 100);
	
	private final Polygon innerPolygonFillShape1 = new Polygon(new int[]{280, 280, 293}, new int[]{58, 44, 51}, 3);
	private final Rectangle2D.Double innerPolygonFillShape2 = new Rectangle2D.Double(292, 44, 6, 15);
	private final Color innerPolygonFillColor = new Color(50, 50, 50);
	
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
		if (!hoveredOver) {
			g.setColor(unHoveredOuterEllipticalFillColor);
			g.fill(unHoveredOuterEllipticalFillShape);
		} else {
			g.setColor(hoveredOuterEllipticalFillColor);
			g.fill(hoveredOuterEllipticalFillShape);
		}
		g.setColor(innerEllipticalFillColor);
		g.fill(innerEllipticalFillShape);
		
		g.setColor(innerPolygonFillColor);
		g.fill(innerPolygonFillShape1);
		g.fill(innerPolygonFillShape2);
	}

	@Override
	public void updateClickState(InputHandler input) {
		selected = true;
	}
}
