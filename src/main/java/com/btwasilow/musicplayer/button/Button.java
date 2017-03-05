package com.btwasilow.musicplayer.button;

import java.awt.Graphics2D;
import java.awt.Shape;

import com.btwasilow.musicplayer.input.InputHandler;

public abstract class Button {
	protected boolean hoveredOver = false;
	protected boolean selected;
	
	public Button() {
	}
	
	public void setHoveredOver(boolean hoveredOver) {
		this.hoveredOver = hoveredOver;
	}
	
	public boolean isHoveredOver() {
		return hoveredOver;
	}
	
	public void select(boolean clicked) {
		this.selected = clicked;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public abstract Shape getBoundingBox();
	
	public abstract void render(Graphics2D g);
	
	public abstract void updateClickState(InputHandler input);
}
