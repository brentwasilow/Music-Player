package com.btwasilow.musicplayer.button;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

public class Button {
	private Shape boundingBox;
	
	private Shape uhFillShape;
	private Color uhFillColor;
	
	private Shape hFillShape;
	private Color hFillColor;
	
	private Shape uhInsetShape;
	private Color uhInsetColor;
	
	private Shape hInsetShape;
	private Color hInsetColor;
	
	private boolean hover = false;
	private boolean selected = false;
	
	public Button(Shape boundingBox) {
		this.boundingBox = boundingBox;
	}
	
	public Button(Shape boundingBox, boolean selected) {
		this.boundingBox = boundingBox;
		this.selected = selected;
	}
	
	public Button(Shape boundingBox, Shape uhFillShape, Color uhFillColor, Shape uhInsetShape, Color uhInsetColor,
				  Shape hFillShape, Color hFillColor, Shape hInsetShape, Color hInsetColor) {
		this.boundingBox = boundingBox;
		
		this.uhFillShape = uhFillShape;
		this.uhFillColor = uhFillColor;
	
		this.uhInsetShape = uhInsetShape;
		this.uhInsetColor = uhInsetColor;
		
		this.hFillShape = hFillShape;
		this.hFillColor = hFillColor;
		
		this.hInsetShape = hInsetShape;
		this.hInsetColor = hInsetColor;
	}
	
	public Shape getBoundingBox() {
		return boundingBox;
	}
	
	public Shape getUHFillShape() {
		return uhFillShape;
	}
	
	public Color getUHFillColor() {
		return uhFillColor;
	}
	
	public Shape getUHInsetShape() {
		return uhInsetShape;
	}
	
	public Color getUHInsetColor() {
		return uhInsetColor;
	}
	
	public Shape getHFillShape() {
		return hFillShape;
	}
	
	public Color getHFillColor() {
		return hFillColor;
	}
	
	public Shape getHInsetShape() {
		return hInsetShape;
	}
	
	public Color getHInsetColor() {
		return hInsetColor;
	}
	
	public void setHoveredOver(boolean hover) {
		this.hover = hover;
	}
	
	public boolean isHoveredOver() {
		return hover;
	}
	
	public void select(boolean clicked) {
		this.selected = clicked;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public void render(Graphics2D g) {
		
	}
}
