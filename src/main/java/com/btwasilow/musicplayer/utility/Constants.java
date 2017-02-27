package com.btwasilow.musicplayer.utility;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

public final class Constants {
	
	public static final int SCROLL_BAR_PIXEL_WIDTH = 344;
	public static final int NUM_OF_SONG_POSITIONS = 14;
	
	public static final Button EXIT_BUTTON = new Button(new Ellipse2D.Double(328, 8, 14, 14), new Ellipse2D.Double(328, 8, 14, 14), new Color(30, 30, 30),
														new Ellipse2D.Double(330, 10, 10, 10), new Color(255, 0, 0),
														new Ellipse2D.Double(328, 8, 14, 14), new Color(200, 200, 200),
														new Ellipse2D.Double(330, 10, 10, 10), new Color(255, 0, 0));
	
	private Constants() {
	}
}
