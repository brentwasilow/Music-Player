package com.btwasilow.musicplayer.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import com.btwasilow.musicplayer.input.InputHandler;

public class FileButton extends ClickableComponent {
	// singleton
	private static FileButton fileButton = new FileButton();
	
	private final Rectangle2D.Double boundingBox = new Rectangle2D.Double(16, 152, 31, 27);
	
	private final Font font = new Font("Arial", 1, 12);
	private final Color unSelectedOutlineColor = new Color(30, 30, 30);
	private final Color unSelectedFillColor = new Color(175, 175, 175);
	
	private final Color selectedOutlineColor = new Color(255, 255, 255);
	private final Color selectedFillColor = new Color(30, 30, 30);
	
	private FileButton() {
	}
	
	public static FileButton getInstance() {
		return fileButton;
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
		}
	}

	@Override
	public void render(Graphics2D g) {
		g.setFont(font);
		
		if (!selected) {
			g.setColor(unSelectedOutlineColor);
			g.drawString("File", 24, 172);
		
			g.setColor(unSelectedFillColor);
			g.drawString("File", 22, 170);
		} else {
			g.setColor(new Color(43, 94, 255));
			g.fill(boundingBox);
			
			g.setColor(selectedOutlineColor);
			g.drawString("File", 22, 170);
		
			//g.setColor(selectedFillColor);
			//g.drawString("File", 20, 168);
		}
	}
	
	
}
