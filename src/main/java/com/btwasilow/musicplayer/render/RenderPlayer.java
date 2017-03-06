package com.btwasilow.musicplayer.render;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import com.btwasilow.musicplayer.Driver;
import com.btwasilow.musicplayer.component.ExpandMusicPlayerButton;
import com.btwasilow.musicplayer.state.State;
import com.btwasilow.musicplayer.utility.Utility;

public class RenderPlayer {
	private RenderPlayer() {
	}
	
	public static void render(Graphics2D g, Driver driver) {
		// render all components
		for (int index = 0; index < State.NON_CLICKABLE_COMPONENTS.length; index++) {
			State.NON_CLICKABLE_COMPONENTS[index].render(g);
		}

		for (int index = 0; index < State.CLICKABLE_COMPONENTS.length; index++) {
			State.CLICKABLE_COMPONENTS[index].render(g);
		}
		
		for (int index = 0; index < State.DISPLAYABLE_SONG_POSITION_COMPONENTS.length; index++) {
			State.DISPLAYABLE_SONG_POSITION_COMPONENTS[index].render(g);
		}
		
		Utility.musicPlayerGUISetup(driver);
		
		if (ExpandMusicPlayerButton.getInstance().isSelected()) {
	//		renderExpandedMusicPlayerToolBar(g);
			renderExpandedMusicPlayerMusicLibraryHeader(g);
			renderExpandedMusicPlayerSongList(g);
		}
	}
	
	private static void renderExpandedMusicPlayerToolBar(Graphics2D g) {
		// font and color of toolbar options
		g.setFont(new Font("Arial", 1, 12));
	
		// render options dark inset color
		g.setColor(new Color(30, 30, 30));
		g.drawString("File", 22, 172);
		g.drawString("Edit", 53, 172);
		g.drawString("View", 86, 172);
		g.drawString("Controls", 125, 172);
		
		// render options lighter fill color
		g.setColor(new Color(175, 175, 175));
		g.drawString("File", 20, 170);
		g.drawString("Edit", 51, 170);
		g.drawString("View", 84, 170);
		g.drawString("Controls", 123, 170);
	}
	
	private static void renderExpandedMusicPlayerMusicLibraryHeader(Graphics2D g) {
		// font setup (italic)
		g.setFont(new Font("Arial", 3, 12));
		
		// set color and draw darker header inset
		g.setColor(new Color(30, 30, 30));
		g.drawString("Name", 27, 202);
		g.drawString("Time", 167, 202);
		g.drawString("Artist", 216, 202);
	    
		// draw lines separating each header piece
		g.drawLine(156, 192, 156, 202);
		g.drawLine(205, 192, 205, 202);
	    
		// draw lighter header fill
		g.setColor(new Color(175, 175, 175));
		g.drawString("Name", 25, 200);
		g.drawString("Time", 165, 200);
		g.drawString("Artist", 214, 200);
	    
		// draw same header lines
		g.drawLine(154, 190, 154, 200);
		g.drawLine(203, 190, 203, 200);
	}

	private static void renderExpandedMusicPlayerSongList(Graphics2D g) {
		//set font (italic)
		g.setFont(new Font("Arial", 2, 12));
		
		int height = 227;
		int height2 = 225;
		
		int j = 0;
		for (int i = State.block; j < 14 && i < State.songs.length; i++) {
			// modify song name if exceeds characters that can be displayed
			String songName = State.songs[i];
			if (songName.length() >= 20) {
				songName = songName.substring(0, 20);
				songName = songName + "...";
			}
			// render darker underside and increment height for the next song
			g.setColor(new Color(30, 30, 30));
			g.drawString(songName, 27, height);
			height = height + 23;
			
			// render lighter song name fill
			g.setColor(new Color(175, 175, 175));
			g.drawString(songName, 25, height2);
			height2 = height2 + 23;
			
			j++;
		}
	}
}
