package com.btwasilow.musicplayer.utility;

import java.awt.Dimension;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;

import com.btwasilow.musicplayer.Driver;
import com.btwasilow.musicplayer.component.ExpandMusicPlayerButton;

public final class Utility {
	private Utility() {
		throw new AssertionError();
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
	
	private static void expandedMusicPlayerGUISetup(Driver driver) {
		// set JFrame to new expanded music player shape and don't forget to pack
		driver.setShape(new RoundRectangle2D.Double(0, 0, 350, 550, 15 ,15));
		driver.pack();
		driver.setMinimumSize(new Dimension(350, 550));
		driver.setMaximumSize(new Dimension(350, 550));
	}
	
	private static void miniMusicPlayerGUISetup(Driver driver) {
		// set JFrame back to original miniplayer shape and pack
		driver.setShape(new RoundRectangle2D.Double(0, 0, 350, 150, 15, 15));
		driver.pack();
		driver.setMinimumSize(new Dimension(350, 150));
		driver.setMaximumSize(new Dimension(350, 150));
	}
	
	public static void musicPlayerGUISetup(Driver driver) {
		if (ExpandMusicPlayerButton.getInstance().isSelected()) {
			expandedMusicPlayerGUISetup(driver);
		} else {
			miniMusicPlayerGUISetup(driver);
		}
	}
}
