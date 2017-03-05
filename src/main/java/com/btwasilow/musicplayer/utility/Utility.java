package com.btwasilow.musicplayer.utility;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;

import com.btwasilow.musicplayer.Driver;
import com.btwasilow.musicplayer.button.Button;

public final class Utility {
	public static final Button EXIT_BUTTON = new Button(new Ellipse2D.Double(328, 8, 14, 14), new Ellipse2D.Double(328, 8, 14, 14), new Color(30, 30, 30),
														new Ellipse2D.Double(330, 10, 10, 10), new Color(255, 0, 0),
														new Ellipse2D.Double(328, 8, 14, 14), new Color(200, 200, 200),
														new Ellipse2D.Double(330, 10, 10, 10), new Color(255, 0, 0));
	public static final Button MUTE_VOLUME_BUTTON = new Button(new RoundRectangle2D.Double(208, 97, 18, 17, 4, 4), new RoundRectangle2D.Double(209, 98, 16, 16, 4, 4), new Color(50, 50, 50),
															   new RoundRectangle2D.Double(208, 97, 18, 17, 4, 4), new Color(30, 30, 30), new RoundRectangle2D.Double(209, 98, 17, 16, 4, 4),
															   new Color(150, 150, 150), new RoundRectangle2D.Double(208, 97, 18, 17, 4, 4), new Color(30, 30, 30));
	public static final Button LEFT_BUTTON = new Button(new Ellipse2D.Double(114, 26, 50, 50));
	public static final Button CENTER_BUTTON = new Button(new Ellipse2D.Double(185, 21,  60,  60));
	public static final Button RIGHT_BUTTON = new Button(new Ellipse2D.Double(264, 26, 50, 50));
	public static final Button VOLUME_FILL_BAR = new Button(new RoundRectangle2D.Double(236, 102, 102, 7, 4, 4));
	public static final Button EXPAND_MUSIC_PLAYER_BUTTON = new Button(new RoundRectangle2D.Double(181, 97, 18, 17, 4, 4));
	public static final Button SONG_FILL_BAR = new Button(new RoundRectangle2D.Double(9, 130, 330, 9, 4, 4));
	
	public static final Button[] buttons = {EXIT_BUTTON, LEFT_BUTTON, CENTER_BUTTON, RIGHT_BUTTON,
											MUTE_VOLUME_BUTTON, VOLUME_FILL_BAR, EXPAND_MUSIC_PLAYER_BUTTON,
											SONG_FILL_BAR};
	
	public static final Button DISPLAYABLE_SONG_POSITION_1 = new Button(new RoundRectangle2D.Double(25, 210, 287, 23, 1, 1), true);
	public static final Button DISPLAYABLE_SONG_POSITION_2 = new Button(new RoundRectangle2D.Double(25, 233, 287, 23, 1, 1));
	public static final Button DISPLAYABLE_SONG_POSITION_3 = new Button(new RoundRectangle2D.Double(25, 256, 287, 23, 1, 1));
	public static final Button DISPLAYABLE_SONG_POSITION_4 = new Button(new RoundRectangle2D.Double(25, 279, 287, 23, 1, 1));
	public static final Button DISPLAYABLE_SONG_POSITION_5 = new Button(new RoundRectangle2D.Double(25, 302, 287, 23, 1, 1));
	public static final Button DISPLAYABLE_SONG_POSITION_6 = new Button(new RoundRectangle2D.Double(25, 325, 287, 23, 1, 1));
	public static final Button DISPLAYABLE_SONG_POSITION_7 = new Button(new RoundRectangle2D.Double(25, 348, 287, 23, 1, 1));
	public static final Button DISPLAYABLE_SONG_POSITION_8 = new Button(new RoundRectangle2D.Double(25, 371, 287, 23, 1, 1));
	public static final Button DISPLAYABLE_SONG_POSITION_9 = new Button(new RoundRectangle2D.Double(25, 394, 287, 23, 1, 1));
	public static final Button DISPLAYABLE_SONG_POSITION_10 = new Button(new RoundRectangle2D.Double(25, 417, 287, 23, 1, 1));
	public static final Button DISPLAYABLE_SONG_POSITION_11 = new Button(new RoundRectangle2D.Double(25, 440, 287, 23, 1, 1));
	public static final Button DISPLAYABLE_SONG_POSITION_12 = new Button(new RoundRectangle2D.Double(25, 463, 287, 23, 1, 1));
	public static final Button DISPLAYABLE_SONG_POSITION_13 = new Button(new RoundRectangle2D.Double(25, 486, 287, 23, 1, 1));
	public static final Button DISPLAYABLE_SONG_POSITION_14 = new Button(new RoundRectangle2D.Double(25, 509, 287, 23, 1, 1));
	
	public static final Button[] DISPLAYABLE_SONG_POSITIONS = {DISPLAYABLE_SONG_POSITION_1, DISPLAYABLE_SONG_POSITION_2, DISPLAYABLE_SONG_POSITION_3,
															   DISPLAYABLE_SONG_POSITION_4, DISPLAYABLE_SONG_POSITION_5, DISPLAYABLE_SONG_POSITION_6,
															   DISPLAYABLE_SONG_POSITION_7, DISPLAYABLE_SONG_POSITION_8, DISPLAYABLE_SONG_POSITION_9,
															   DISPLAYABLE_SONG_POSITION_10, DISPLAYABLE_SONG_POSITION_11, DISPLAYABLE_SONG_POSITION_12,
															   DISPLAYABLE_SONG_POSITION_13, DISPLAYABLE_SONG_POSITION_14};
	
	private Utility() {
	}
	
	public static void initialGUISetup(Driver driver) {
		// graphical user interface (GUI) setup of JFrame component
		driver.setUndecorated(true);
		driver.setShape(new RoundRectangle2D.Double(0, 0, Consts.MINI_MUSIC_PLAYER_WIDTH,
												   Consts.MINI_MUSIC_PLAYER_HEIGHT,
												   Consts.MUSIC_PLAYER_PIXEL_ARC_WIDTH,
												   Consts.MUSIC_PLAYER_PIXEL_ARC_HEIGHT));
		driver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		driver.setResizable(false);
		driver.setLocationRelativeTo(null);
		driver.setVisible(true);
	}
	
	public static void expandedMusicPlayerGUISetup(Driver driver) {
		// set JFrame to new expanded music player shape and don't forget to pack
		driver.setShape(new RoundRectangle2D.Double(0, 0, 350, 550, 15 ,15));
		driver.pack();
		driver.setMinimumSize(new Dimension(350, 550));
		driver.setMaximumSize(new Dimension(350, 550));
	}
	
	public static void miniMusicPlayerGUISetup(Driver driver) {
		// set JFrame back to original miniplayer shape and pack
		driver.setShape(new RoundRectangle2D.Double(0, 0, 350, 150, 15, 15));
		driver.pack();
		driver.setMinimumSize(new Dimension(350, 150));
		driver.setMaximumSize(new Dimension(350, 150));
	}
}
