package com.btwasilow.musicplayer.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import com.btwasilow.musicplayer.input.InputHandler;

public class ControlsButton extends ClickableComponent {
	// singleton
	private static ControlsButton controlsButton = new ControlsButton();
	
	private final Rectangle2D.Double boundingBox = new Rectangle2D.Double(126, 152, 61, 27);
	
	private final Rectangle2D.Double dropdownBox = new Rectangle2D.Double(126, 179, 150, 200);
	private final Color dropdownBoxColor = new Color(175, 175, 175);
	
	private final Font font = new Font("Arial", 1, 12);
	private final Color unSelectedOutlineColor = new Color(30, 30, 30);
	private final Color unSelectedFillColor = new Color(175, 175, 175);
	
	private final Color selectedOutlineColor = new Color(255, 255, 255);
	
	private ControlsButton() {
	}
	
	public static ControlsButton getInstance() {
		return controlsButton;
	}

	@Override
	public Shape getBoundingBox() {
		return boundingBox;
	}
	
	public Shape getDropdownBox() {
		return dropdownBox;
	}

	@Override
	public void updateClickState(InputHandler input) {
		if (selected) {
			selected = false;
		} else {
			selected = true;
			FileButton.getInstance().select(false);
			EditButton.getInstance().select(false);
			ViewButton.getInstance().select(false);
		}
	}

	@Override
	public void render(Graphics2D g) {
		g.setFont(font);
		
		if (!selected) {
			g.setColor(unSelectedOutlineColor);
			g.drawString("Controls", 134, 172);
		
			g.setColor(unSelectedFillColor);
			g.drawString("Controls", 132, 170);
		} else {
			g.setColor(new Color(43, 94, 255));
			g.fill(boundingBox);
			
			g.setColor(selectedOutlineColor);
			g.drawString("Controls", 132, 170);
			
			g.setColor(dropdownBoxColor);
			g.fill(dropdownBox);
		}
	}
}
