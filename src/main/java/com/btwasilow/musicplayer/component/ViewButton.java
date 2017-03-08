package com.btwasilow.musicplayer.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import com.btwasilow.musicplayer.input.InputHandler;

public class ViewButton extends ClickableComponent {
	// singleton
	private static ViewButton viewButton = new ViewButton();
	
	private final Rectangle2D.Double boundingBox = new Rectangle2D.Double(85, 152, 40, 27);
	
	private final Font font = new Font("Arial", 1, 12);
	private final Color unSelectedOutlineColor = new Color(30, 30, 30);
	private final Color unSelectedFillColor = new Color(175, 175, 175);
	
	private final Color selectedOutlineColor = new Color(255, 255, 255);
	
	private ViewButton() {
	}
	
	public static ViewButton getInstance() {
		return viewButton;
	}

	@Override
	public Shape getBoundingBox() {
		return boundingBox;
	}

	@Override
	public void updateClickState(InputHandler input) {
		if (selected) {
			selected = false;
		} else {
			selected = true;
			FileButton.getInstance().select(false);
			EditButton.getInstance().select(false);
		}
	}

	@Override
	public void render(Graphics2D g) {
		g.setFont(font);
		
		if (!selected) {
			g.setColor(unSelectedOutlineColor);
			g.drawString("View", 93, 172);
		
			g.setColor(unSelectedFillColor);
			g.drawString("View", 91, 170);
		} else {
			g.setColor(new Color(43, 94, 255));
			g.fill(boundingBox);
			
			g.setColor(selectedOutlineColor);
			g.drawString("View", 91, 170);
		}
	}
}
