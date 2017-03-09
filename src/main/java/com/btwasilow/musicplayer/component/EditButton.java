package com.btwasilow.musicplayer.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import com.btwasilow.musicplayer.input.InputHandler;

public class EditButton extends ClickableComponent {
	// singleton
	private static EditButton editButton = new EditButton();
	
	private final Rectangle2D.Double boundingBox = new Rectangle2D.Double(49, 152, 35, 27);
	
	private final Rectangle2D.Double dropdownBox = new Rectangle2D.Double(49, 179, 150, 200);
	private final Color dropdownBoxColor = new Color(175, 175, 175);
	
	private final Font font = new Font("Arial", 1, 12);
	private final Color unSelectedOutlineColor = new Color(30, 30, 30);
	private final Color unSelectedFillColor = new Color(175, 175, 175);
	
	private final Color selectedOutlineColor = new Color(255, 255, 255);
	
	private EditButton() {
	}
	
	public static EditButton getInstance() {
		return editButton;
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
			ViewButton.getInstance().select(false);
			ControlsButton.getInstance().select(false);
		}
	}

	@Override
	public void render(Graphics2D g) {
		g.setFont(font);
		
		if (!selected) {
			g.setColor(unSelectedOutlineColor);
			g.drawString("Edit", 57, 172);
		
			g.setColor(unSelectedFillColor);
			g.drawString("Edit", 55, 170);
		} else {
			g.setColor(new Color(43, 94, 255));
			g.fill(boundingBox);
			
			g.setColor(selectedOutlineColor);
			g.drawString("Edit", 55, 170);
			
			g.setColor(dropdownBoxColor);
			g.fill(dropdownBox);
		}
	}
}
