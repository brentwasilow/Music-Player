package com.btwasilow.musicplayer.utility;

import java.awt.Color;
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
	
	public boolean isHoveredOver() {
		return hover;
	}
}
