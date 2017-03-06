package com.btwasilow.musicplayer.component;

import java.awt.Shape;

import com.btwasilow.musicplayer.input.InputHandler;

public abstract class ClickableComponent extends Component {
	protected boolean hoveredOver = false;
	protected boolean selected;
	
	public ClickableComponent() {
	}
	
	public abstract Shape getBoundingBox();
	
	public abstract void updateClickState(InputHandler input);
	
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
}
