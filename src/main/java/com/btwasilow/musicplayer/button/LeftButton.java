package com.btwasilow.musicplayer.button;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import com.btwasilow.musicplayer.input.InputHandler;

public class LeftButton extends Button {
	// singleton
	private static LeftButton leftButton = new LeftButton();
	
	private final Ellipse2D.Double boundingBox = new Ellipse2D.Double(114, 26, 50, 50);
	
	private final Ellipse2D.Double unHoveredOuterEllipticalFillShape = new Ellipse2D.Double(114, 26, 50, 50);
	private final Color unHoveredOuterEllipticalFillColor = new Color(40, 40, 40);
	
	private final Ellipse2D.Double hoveredOuterEllipticalFillShape = new Ellipse2D.Double(114, 26, 50, 50);
	private final Color hoveredOuterEllipticalFillColor = new Color(200, 200, 200);
	
	private final Ellipse2D.Double innerEllipticalFillShape = new Ellipse2D.Double(119, 31, 40, 40);
	private final Color innerEllipticalFillColor = new Color(100, 100, 100);
	
	private final Polygon innerPolygonFillShape1 = new Polygon(new int[]{147, 147, 134}, new int[]{58, 44, 51}, 3);
	private final Rectangle2D.Double innerPolygonFillShape2 = new Rectangle2D.Double(129, 44, 6, 15);
	private final Color innerPolygonFillColor = new Color(50, 50, 50);
	
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
