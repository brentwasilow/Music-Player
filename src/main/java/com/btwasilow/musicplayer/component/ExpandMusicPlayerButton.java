package com.btwasilow.musicplayer.component;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;

import com.btwasilow.musicplayer.input.InputHandler;

public class ExpandMusicPlayerButton extends ClickableComponent {
	// singleton
	private static ExpandMusicPlayerButton expandMusicPlayerButton = new ExpandMusicPlayerButton();
	
	private final RoundRectangle2D.Double boundingBox = new RoundRectangle2D.Double(181, 97, 18, 17, 4, 4);
	
	private final RoundRectangle2D.Double unHoveredOuterRectangleFillShape = new RoundRectangle2D.Double(182, 98, 16, 16, 4, 4);
	private final Color unHoveredOuterRectangleFillColor = new Color(50, 50, 50);
	
	private final RoundRectangle2D.Double unHoveredOuterRectangleOutlineShape = new RoundRectangle2D.Double(181, 97, 18, 17, 4, 4);
	private final Color unHoveredOuterRectangleOutlineColor = new Color(30, 30, 30);
	
	private final Color unHoveredInnerPolygonFillColor = new Color(150, 150, 150);
	private final Color hoveredInnerPolygonFillColor = new Color(50, 50, 50);
	private final Line2D.Double innerPolygonFillShape1 = new Line2D.Double(189,  101, 195, 101);
	private final Line2D.Double innerPolygonFillShape2 = new Line2D.Double(189,  104, 195, 104);
	private final Line2D.Double innerPolygonFillShape3 = new Line2D.Double(189, 107, 195, 107);
	private final Line2D.Double innerPolygonFillShape4 = new Line2D.Double(189,  110, 195, 110);
	private final Ellipse2D.Double innerPolygonFillShape5 = new Ellipse2D.Double(184, 101, 4, 4);
	private final Ellipse2D.Double innerPolygonFillShape6 = new Ellipse2D.Double(184, 107, 4, 4);

	
	private final RoundRectangle2D.Double hoveredOuterRectangleFillShape = new RoundRectangle2D.Double(182, 98, 17, 16, 4, 4);
	private final Color hoveredOuterRectangleFillColor = new Color(200, 200, 200);
	
	private final RoundRectangle2D.Double hoveredOuterRectangleOutlineShape = new RoundRectangle2D.Double(181, 97, 18, 17, 4, 4);
	private final Color hoveredOuterRectangleOutlineColor = new Color(30, 30, 30);
	
	private ExpandMusicPlayerButton() {
	}
	
	public static ExpandMusicPlayerButton getInstance() {
		return expandMusicPlayerButton;
	}
	
	@Override
	public Shape getBoundingBox() {
		return boundingBox;
	}

	@Override
	public void render(Graphics2D g) {
		if (!hoveredOver) {
			g.setColor(unHoveredOuterRectangleFillColor);
			g.fill(unHoveredOuterRectangleFillShape);
			
			g.setColor(unHoveredOuterRectangleOutlineColor);
			g.draw(unHoveredOuterRectangleOutlineShape);
			
			g.setColor(unHoveredInnerPolygonFillColor);
		} else {
			g.setColor(hoveredOuterRectangleFillColor);
			g.fill(hoveredOuterRectangleFillShape);
			
			g.setColor(hoveredOuterRectangleOutlineColor);
			g.draw(hoveredOuterRectangleOutlineShape);
			
			g.setColor(hoveredInnerPolygonFillColor);
		}
		g.draw(innerPolygonFillShape1);
		g.draw(innerPolygonFillShape2);
		g.draw(innerPolygonFillShape3);
		g.draw(innerPolygonFillShape4);
		g.fill(innerPolygonFillShape5);
		g.fill(innerPolygonFillShape6);
	}

	@Override
	public void updateClickState(InputHandler input) {
		// switch music player mode based on current state
		// (make mini if already expanded or expand if already mini)
		if (selected) {
			selected = false;
		} else {
			selected = true;
		}
	}
}
