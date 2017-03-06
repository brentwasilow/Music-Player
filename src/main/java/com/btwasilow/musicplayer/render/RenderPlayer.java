package com.btwasilow.musicplayer.render;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import com.btwasilow.musicplayer.Driver;
import com.btwasilow.musicplayer.button.ExpandMusicPlayerButton;
import com.btwasilow.musicplayer.state.State;
import com.btwasilow.musicplayer.utility.Consts;
import com.btwasilow.musicplayer.utility.Utility;

public class RenderPlayer {
	private RenderPlayer() {
	}
	
	public static void render(Graphics2D g, Driver driver) {
		renderMiniPlayerBackground(g);
	
		// render all buttons
		for (int index = 0; index < State.BUTTONS.length; index++) {
			State.BUTTONS[index].render(g);
		}
		
		renderCurrentlyPlayingSong(g);
		
		if (!ExpandMusicPlayerButton.getInstance().isSelected()) { // miniplayer rendering routines
			Utility.miniMusicPlayerGUISetup(driver);
		} else { // expanded music player rendering routines
			Utility.expandedMusicPlayerGUISetup(driver);
	    	
			renderExpandedMusicPlayerBackground(g);
			renderExpandedMusicPlayerScrollBar(g);
			renderExpandedMusicPlayerToolBar(g);
			renderExpandedMusicPlayerMusicLibraryHeader(g);
			renderExpandedMusicPlayerEqualizerBoxFill(g);
			renderExpandedMusicPlayerEqualizer(g);
			
			renderExpandedMusicPlayerSongListPositionSelected(g);
			renderExpandedMusicPlayerSongList(g);
		}
	}
	
	private static void renderExpandedMusicPlayerBackground(Graphics2D g) {
		// render same background but longer
		g.setColor(new Color(64, 64, 64));
		g.fillRect(0, 150, 350, 400);
		
		// dark outline to longer background
		g.setColor(new Color(30, 30, 30));
		g.drawRoundRect(0, 150, 350-1, 400-1, 15, 15);
		
		// lighter outline to give contrast to longer background
		g.setColor(new Color(100, 100, 100));
		g.drawRoundRect(1, 151, 350-3, 400-3, 15, 15);
	    
	    // render darker inset color to provide contrast for where music library will be listed
		g.setColor(new Color(50, 50, 50));
		g.fillRoundRect(10, 180, 328, 358, 10, 10);
		
		// provide darker outline to give more contrast to inset
		g.setColor(new Color(30, 30, 30));
		g.drawRoundRect(9, 179, 331, 361, 10, 10);	
	}
	
	private static void renderExpandedMusicPlayerScrollBar(Graphics2D g) {
		// darker inset inset
		g.setColor(new Color(40, 40, 40));
		g.fillRoundRect(327, 187, 5, 344, 3, 3);
		
		// determine scroll bar size and change in scrollbar placement
		float scrollBarChange = 14.0F / State.songs.length;
		float scrollBarSize = scrollBarChange * Consts.SCROLL_BAR_PIXEL_HEIGHT; 
		float restOfScroll = Consts.SCROLL_BAR_PIXEL_HEIGHT - scrollBarSize;
		float restOfScrollIncrement = restOfScroll / (State.songs.length - 14.0F);
		float scrollBarPlacement =  restOfScrollIncrement * State.block;
		
		// lighter scroll bar drag area (white)
		g.setColor(new Color(150, 150, 150));
		g.fillRoundRect(327, 187 + (int)(scrollBarPlacement), 5, (int)(scrollBarSize), 3, 3);
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
	
	private static void renderExpandedMusicPlayerEqualizerBoxFill(Graphics2D g) {
		// set color of darker inset fill
		g.setColor(new Color(50, 50, 50));
		g.fillRoundRect(200, 155, 139, 19, 3, 3); // 10 arc
		
		// set color of darker outline to provide contrast
		g.setColor(new Color(30, 30, 30));
		g.drawRoundRect(200, 155, 140, 20, 4, 4); // 10 arc
	}
	
	private static void renderExpandedMusicPlayerEqualizer(Graphics2D g) {
		// equalizer box loop
		for (int width = 0; width < 15; width++) {
			// change color depending on the height of the equalizer box. The higher it is the redder it is.
			for (int height = 0; height < State.rand.nextInt(7); height++) {
				if (height < 1) {
					g.setColor(new Color(0, 255, 0));
				} else if (height < 2) {
					g.setColor(new Color(128, 255, 0));
				} else if (height < 3) {
					g.setColor(new Color(255, 255, 0));
				} else if (height < 4){
					g.setColor(new Color(255, 255, 0));
				} else if (height < 5) {
					g.setColor(new Color(255, 128, 0));
				} else if (height < 6) {
					g.setColor(new Color(255, 0, 0));
				}
				g.fillRoundRect(203+(width*9), 173-(height*3), 8, 2, 1, 2);
			}
		}
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
	
	private static void renderExpandedMusicPlayerSongListPositionSelected(Graphics2D g) {
		// for each of the 14 song display slots in the music library
		for (int i = 0; i < 14; i++) {
			// render a lighter inset box to signify that song
			// selection has been picked
			if (State.DISPLAYABLE_SONG_POSITIONS[i].isSelected()) {
				g.setColor(new Color(64, 64, 64));
				g.fillRoundRect(25, (210+(i*23)), 287, 23, 1, 1);
			}
		}
	}

	private static void renderMiniPlayerBackground(Graphics2D g) {
		// dark gray fill
		g.setColor(new Color(64, 64, 64));
		g.fillRect(0, 0, 350, 150);
		
		// dark black outline to frame component
		g.setColor(new Color(30, 30, 30));
		g.drawRoundRect(0, 0, 349, 149, 15, 15);
		
		// whiter in-set line to give depth at corner
		g.setColor(new Color(100, 100, 100));
		g.drawRoundRect(1, 1, 350-3, 150-3, 15, 15);
	}
	
	private static void renderCurrentlyPlayingSong(Graphics2D g) {
		// clip the currently playing song name
		String songName = "";
		if (State.currentlyPlayingSongName.length() >= 23) {
			songName = State.currentlyPlayingSongName.substring(0, 23);
			songName += "...";
		} else {
			songName = State.currentlyPlayingSongName;
		}
		// draw current song using Arial font with dark fill
		g.setFont(new Font("Arial", 1, 12));
		g.setColor(new Color(50, 50, 50));
		g.drawString(songName, 22, 114);
		
		// draw current song over dark fill with lighter fill to provide contrast
		g.setColor(new Color(175, 175, 175));
		g.drawString(songName, 20, 112);
	}
}
