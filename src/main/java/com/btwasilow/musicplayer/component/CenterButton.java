package com.btwasilow.musicplayer.component;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import com.btwasilow.musicplayer.input.InputHandler;

public class CenterButton extends Component {
	// singleton
	private static CenterButton centerButton = new CenterButton();
	
	private final Ellipse2D.Double boundingBox = new Ellipse2D.Double(185, 21,  60,  60);
	
	private final Ellipse2D.Double unHoveredOuterEllipticalFillShape = new Ellipse2D.Double(185, 21,  60,  60);
	private final Color unHoveredOuterEllipticalFillColor = new Color(40, 40, 40);
	
	private final Ellipse2D.Double hoveredOuterEllipticalFillShape = new Ellipse2D.Double(185, 21, 60, 60);
	private final Color hoveredOuterEllipticalFillColor = new Color(200, 200, 200);
	
	private final Ellipse2D.Double innerEllipticalFillShape = new Ellipse2D.Double(190, 26, 50, 50);
	private final Color innerEllipticalFillColor = new Color(100, 100, 100);
	
	private final Polygon innerPolygonFillShape = new Polygon(new int[]{208, 208, 225}, new int[]{61, 41, 51}, 3);
	private final Color innerPolygonFillColor = new Color(50, 50, 50);
	
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
		g.fill(innerPolygonFillShape);
	}

	@Override
	public void updateClickState(InputHandler input) {
		selected = true;
	}
}
