package com.btwasilow.musicplayer.utility;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

import com.btwasilow.musicplayer.button.Button;

public final class Utility {
	
	public static final int SCROLL_BAR_PIXEL_WIDTH = 344;
	public static final int NUM_OF_SONG_POSITIONS = 14;
	
	public static final Button EXIT_BUTTON = new Button(new Ellipse2D.Double(328, 8, 14, 14), new Ellipse2D.Double(328, 8, 14, 14), new Color(30, 30, 30),
														new Ellipse2D.Double(330, 10, 10, 10), new Color(255, 0, 0),
														new Ellipse2D.Double(328, 8, 14, 14), new Color(200, 200, 200),
														new Ellipse2D.Double(330, 10, 10, 10), new Color(255, 0, 0));
	public static final Button VOLUME_MUTE_BUTTON = new Button(new RoundRectangle2D.Double(208, 97, 18, 17, 4, 4), new RoundRectangle2D.Double(209, 98, 16, 16, 4, 4), new Color(50, 50, 50),
															   new RoundRectangle2D.Double(208, 97, 18, 17, 4, 4), new Color(30, 30, 30), new RoundRectangle2D.Double(209, 98, 17, 16, 4, 4),
															   new Color(150, 150, 150), new RoundRectangle2D.Double(208, 97, 18, 17, 4, 4), new Color(30, 30, 30));
	
	private Utility() {
	}
}
