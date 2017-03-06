package com.btwasilow.musicplayer.button;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import com.btwasilow.musicplayer.input.InputHandler;

public class MuteVolumeButton extends Button {
	// singleton
	private static MuteVolumeButton muteVolumeButton = new MuteVolumeButton();
	
	private final RoundRectangle2D.Double boundingBox = new RoundRectangle2D.Double(208, 97, 18, 17, 4, 4);
	
	private final RoundRectangle2D.Double unHoveredOuterRectangleFillShape = new RoundRectangle2D.Double(209, 98, 16, 16, 4, 4);
	private final Color unHoveredOuterRectangleFillColor = new Color(50, 50, 50);
	
	private final RoundRectangle2D.Double unHoveredOuterRectangleOutlineShape = new RoundRectangle2D.Double(208, 97, 18, 17, 4, 4);
	private final Color unHoveredOuterRectangleOutlineColor = new Color(30, 30, 30);
	
	private final Polygon innerPolygonFillShape1 = new Polygon(new int[]{219, 219, 212}, new int[]{111, 100, 105}, 3);
	private final Rectangle2D.Double innerPolygonFillShape2 = new Rectangle2D.Double(212, 103, 4, 5);
	private final Color unHoveredInnerPolygonFillColor = new Color(150, 150, 150);
	private final Color hoveredInnerPolygonFillColor = new Color(50, 50, 50);
	
	private final Arc2D.Double selectedInnerPolygonArcShape1 = new Arc2D.Double(218, 102, 4, 6, 0, -90, Arc2D.OPEN);
	private final Arc2D.Double selectedInnerPolygonArcShape2 = new Arc2D.Double(218, 102, 4, 7, 0, 90, Arc2D.OPEN);
	
	private final RoundRectangle2D.Double hoveredOuterRectangleFillShape = new RoundRectangle2D.Double(209, 98, 17, 16, 4, 4);
	private final Color hoveredOuterRectangleFillColor = new Color(200, 200, 200);
	
	private final RoundRectangle2D.Double hoveredOuterRectangleOutlineShape = new RoundRectangle2D.Double(208, 97, 18, 17, 4, 4);
	private final Color hoveredOuterRectangleOutlineColor = new Color(30, 30, 30);
	
	private MuteVolumeButton() {
	}
	
	public static MuteVolumeButton getInstance() {
		return muteVolumeButton;
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
		g.fill(innerPolygonFillShape1);
		g.fill(innerPolygonFillShape2);
		
		if (!selected) {
			g.draw(selectedInnerPolygonArcShape1);
			g.draw(selectedInnerPolygonArcShape2);
		}
	}

	@Override
	public void updateClickState(InputHandler input) {
		// like a switch (turns off button if clicked already
		// or turns on button if not clicked already)
		if (selected) {
			selected = false;
		} else {
			selected = true;
		}
	}

}
