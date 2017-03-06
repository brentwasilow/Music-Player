package com.btwasilow.musicplayer.component;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import com.btwasilow.musicplayer.input.InputHandler;

public class DisplayableSongPosition extends Component {
	private RoundRectangle2D.Double boundingBox;
	
	public DisplayableSongPosition(RoundRectangle2D.Double boundingBox, boolean selected) {
		this.boundingBox = boundingBox;
		this.selected = selected;
	}
	
	@Override
	public Shape getBoundingBox() {
		return boundingBox;
	}

	@Override
	public void render(Graphics2D g) {
	}

	@Override
	public void updateClickState(InputHandler input) {
	}
}
