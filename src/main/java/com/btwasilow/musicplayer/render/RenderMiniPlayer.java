package com.btwasilow.musicplayer.render;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

import com.btwasilow.musicplayer.Driver;
import com.btwasilow.musicplayer.update.UpdateMiniPlayer;

public class RenderMiniPlayer {
	public static String[] songs = {"Break Up", "Changes", "I Need You", "Dirty Sessions", "The Ocean",
									"Don't You Worry Child", "Big Sky", "Got a Feeling", "Can't Afford it All",
									"Happy Endings", "Younger", "Sunday", "No Eyes", "Let Her Go", "Wonkavator",
									"Pompeii", "Generate", "Heading Home", "Youth", "Never Cry Again", "Arigato"};
	
	private RenderMiniPlayer() {
	}
	
	public static void render(Graphics2D g, Driver driver) {
		renderMiniPlayerBackground(g);
		renderArtworkDisplayBox(g);
		
		renderCenterButton(g);
		renderLeftButton(g);
		renderRightButton(g);
		
		renderTimeBarBox(g);
		renderTimeBarFill(g);
		
		renderVolumeBarBox(g);
		renderVolumeBarFill(g);
		
		renderCurrentlyPlayingSong(g);
		
		renderExpandMusicPlayerButton(g);
		renderVolumeMuteButton(g);
		
		renderExitButton(g);
		
		if (!UpdateMiniPlayer.expandMusicPlayerButtonClicked) { // miniplayer rendering routines
			miniMusicPlayerGUISetup(driver);
		} else { // expanded music player rendering routines
			expandedMusicPlayerGUISetup(driver);
	    	
			renderExpandedMusicPlayerBackground(g);
			renderExpandedMusicPlayerScrollBar(g);
			renderExpandedMusicPlayerToolBar(g);
			renderExpandedMusicPlayerMusicLibraryHeader(g);
			renderExpandedMusicPlayerEqualizerBoxFill(g);
			renderExpandedMusicPlayerEqualizer(g);
			
			renderExpandedMusicPlayerSongListHover(g);
			renderExpandedMusicPlayerSongList(g);
		}
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
	
		// name/artist/time header and song-list split (haven't decided yet)
		//g.setColor(new Color(50, 50, 50));
		//g.fillRoundRect(10, 180, 328, 28, 10, 10);
		//g.fillRoundRect(10, 210, 328, 330, 10, 10);
		
		//g.setColor(new Color(30, 30, 30));
		//g.drawRoundRect(9, 179, 331, 28, 10, 10);
		//g.drawRoundRect(9, 209, 331, 330, 10, 10);
	
	}
	
	private static void renderExpandedMusicPlayerScrollBar(Graphics2D g) {
		// darker inset inset
		g.setColor(new Color(40, 40, 40));
		g.fillRoundRect(327, 187, 5, 344, 3, 3);
		
		// determine scroll bar size and change in scrollbar placement
		float scrollBarChange = 14.0F / songs.length;
		float scrollBarSize = scrollBarChange * UpdateMiniPlayer.scrollBarSize; 
		float restOfScroll = UpdateMiniPlayer.scrollBarSize - scrollBarSize;
		float restOfScrollIncrement = restOfScroll / (songs.length - 14.0F);
		float scrollBarPlacement =  restOfScrollIncrement * UpdateMiniPlayer.currentSongSelection;
		
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
		
		// add underline to font
		//Map<TextAttribute, Object> map =
		//	    new Hashtable<TextAttribute, Object>();
		//	map.put(TextAttribute.UNDERLINE,
		//	    TextAttribute.UNDERLINE_ON);
		//Font font2 = font.deriveFont(map);
		
		// set color and draw darker header inset
		g.setColor(new Color(30, 30, 30));
		g.drawString("Name", 27, 202);
		g.drawString("Time", 167, 202);
		g.drawString("Artist", 216, 202);
	    
		// draw lines separating each header piece
		g.drawLine(156, 192, 156, 202);
		g.drawLine(205, 192, 205, 202);
		
		// dark header line
		//g.drawLine(27, 209, 310, 209);
	    
		// draw lighter header fill
		g.setColor(new Color(175, 175, 175));
		g.drawString("Name", 25, 200);
		g.drawString("Time", 165, 200);
		g.drawString("Artist", 214, 200);
	    
		// draw same header lines
		g.drawLine(154, 190, 154, 200);
		g.drawLine(203, 190, 203, 200);
		
		// lighter header line
		//g.drawLine(25, 207, 308, 207);
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
			for (int height = 0; height < UpdateMiniPlayer.rand.nextInt(7); height++) {
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
		// render song list based on the current song selection
		for (int i = UpdateMiniPlayer.currentSongSelection; (i < (UpdateMiniPlayer.currentSongSelection+14) && i < songs.length); i++) {
			// modify song name if exceeds characters that can be displayed
			String songName = songs[i];
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
		}
	}
	
	private static void renderExpandedMusicPlayerSongListHover(Graphics2D g) {
		// for each of the 14 song display slots in the music library
		for (int i = 0; i < 14; i++) {
			// render a lighter inset box to signify that song
			// selection has been picked
			if (UpdateMiniPlayer.songListHoverPositionClicked[i]) {
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
	
	private static void renderArtworkDisplayBox(Graphics2D g) {
		// dark fill box (darker than miniplayer background)
		g.setColor(new Color(50, 50, 50));
		g.fillRoundRect(20, 20, 60, 60, 10, 10);
		
		// fill box outline to provide contrast
		g.setColor(new Color(30, 30, 30));
		g.drawRoundRect(19, 19, 62, 62, 10, 10);
	}
	
	private static void renderCenterButton(Graphics2D g) {
		if (!UpdateMiniPlayer.centerButtonHover) { 
			// dark fill oval (darker than miniplayer background)
			g.setColor(new Color(40, 40, 40));
			g.fillOval(185, 21,  60,  60);
		} else {
			// lighter fill oval when hovered over
			g.setColor(new Color(200, 200, 200));
			g.fillOval(185, 21, 60, 60);
		}
		// light fill oval to provide contrast
		g.setColor(new Color(100, 100, 100));
		g.fillOval(190, 26, 50, 50);
		
		// render play button triangle (always renders the same no matter if hovered or not)
		g.setColor(new Color(50, 50, 50));
		int[] x = {208, 208, 225};
		int[] y = {61, 41, 51};
		g.fillPolygon(x, y, 3);
	}
	
	private static void renderLeftButton(Graphics2D g) {
		if (!UpdateMiniPlayer.leftButtonHover) {
			// dark left fill oval (smaller than center button)
			g.setColor(new Color(40, 40, 40));
			g.fillOval(114, 26, 50, 50);
		} else {
			// lighter left fill oval if hovered over
			g.setColor(new Color(200, 200, 200));
			g.fillOval(114, 26, 50, 50);
		}
		// light fill oval (also smaller than center button)
		g.setColor(new Color(100, 100, 100));
		g.fillOval(119, 31, 40, 40);
		
		// render left button triangle and bar (same regardless of hover)
		int[] x = {147, 147, 134};
		int[] y = {58, 44, 51};
		g.setColor(new Color(50, 50, 50));
		g.fillPolygon(x, y, 3);
		g.fillRect(129, 44, 6, 15);
	}
	
	private static void renderRightButton(Graphics2D g) {
		if (!UpdateMiniPlayer.rightButtonHover) {
			// dark right fill oval (smaller than center button)
			g.setColor(new Color(40, 40, 40));
			g.fillOval(264, 26, 50, 50);
		} else {
			// lighter right fill oval if hovered over
			g.setColor(new Color(200, 200, 200));
			g.fillOval(264, 26, 50, 50);
		}
		// right fill oval (also smaller than center button)
		g.setColor(new Color(100, 100, 100));
		g.fillOval(269, 31, 40, 40);
		
		// render right button triangle and bar
		int[] x = {280, 280, 293};
		int[] y = {58, 44, 51};
		g.setColor(new Color(50, 50, 50));
		g.fillPolygon(x, y, 3);
		g.fillRect(292, 44, 6, 15);
	}
	
	private static void renderTimeBarBox(Graphics2D g) {
		// dark time bar fill
		g.setColor(new Color(50, 50, 50));
		g.fillRoundRect(10, 131, 328, 7, 4, 4);
		
		// darker time bar inset
		g.setColor(new Color(30, 30, 30));
		g.drawRoundRect(9, 130, 330, 9, 4, 4);
	}
	
	private static void renderTimeBarFill(Graphics2D g) {
		// blue time bar fill color
		g.setColor(new Color(161, 202, 241));
		g.fillRoundRect(10, 131, UpdateMiniPlayer.currentlyPlayingSongTimePosition, 7, 3, 3);
		
		// daker blue time bar fill outline
		g.setColor(new Color(100, 140, 180));
		g.drawRoundRect(10, 131, UpdateMiniPlayer.currentlyPlayingSongTimePosition, 7, 4, 4);
	}
	
	private static void renderVolumeBarBox(Graphics2D g) {
		// dark volume bar fill box
		g.setColor(new Color(50, 50, 50));
		g.fillRoundRect(237, 103, 100, 5, 4, 4);
		
		// darker volume bar outline
		g.setColor(new Color(30, 30, 30));
		g.drawRoundRect(236, 102, 102, 7, 4, 4);
	}
	
	private static void renderVolumeBarFill(Graphics2D g) {
		// if volume is muted then we render 0 volume otherwise render current song volume
		int volume;
		if (UpdateMiniPlayer.muteVolumeButtonClicked) {
			volume = 0;
		} else {
			volume = UpdateMiniPlayer.currentlyPlayingSongVolume;
		}
		
		// green volume bar fill color
		g.setColor(new Color(90, 230, 0));
		g.fillRoundRect(237, 103, volume, 5, 3, 3);
		
		// darker volume bar outline to provide contrast
		g.setColor(new Color(34, 140, 30));
		g.drawRoundRect(237, 103, volume, 5, 4, 4);
	}
	
	private static void renderCurrentlyPlayingSong(Graphics2D g) {
		// clip the currently playing song name
		String songName = "";
		if (UpdateMiniPlayer.currentlyPlayingSongName.length() >= 23) {
			songName = UpdateMiniPlayer.currentlyPlayingSongName.substring(0, 23);
			songName += "...";
		}
		// draw current song using Arial font with dark fill
		g.setFont(new Font("Arial", 1, 12));
		g.setColor(new Color(50, 50, 50));
		g.drawString(songName, 22, 114);
		
		// draw current song over dark fill with lighter fill to provide contrast
		g.setColor(new Color(175, 175, 175));
		g.drawString(songName, 20, 112);
	}
	
	private static void renderExpandMusicPlayerButton(Graphics2D g) {
		if (!UpdateMiniPlayer.expandMusicPlayerButtonHover) {
			// dark rectangle fill
			g.setColor(new Color(50, 50, 50));
			g.fillRoundRect(182, 98, 16, 16, 4, 4);
		
			// darker rectangle outline
			g.setColor(new Color(30, 30, 30));
			g.drawRoundRect(181, 97, 18, 17, 4, 4);
		
			// set unhovered music player button inset color
			g.setColor(new Color(150, 150, 150));
		} else {
			// lighter rectangle fill when hovered over
			g.setColor(new Color(150, 150, 150));
			g.fillRoundRect(182, 98, 17, 16, 4, 4);
			
			// darker rectangle outline
			g.setColor(new Color(30, 30, 30));
			g.drawRoundRect(181, 97, 18, 17, 4, 4);
		
			// set hovered music player button inset color (darker than unhovered)
			g.setColor(new Color(50, 50, 50));
		}
		// draw maximize music player representation (shown visually as items-in-a-list)
		g.drawLine(189,  101, 195, 101);
		g.drawLine(189,  104, 195, 104);
		g.drawLine(189, 107, 195, 107);
		g.drawLine(189,  110, 195, 110);
		g.fillOval(184, 101, 4, 4);
		g.fillOval(184, 107, 4, 4);
	}
	
	private static void renderVolumeMuteButton(Graphics2D g) {
		if (!UpdateMiniPlayer.muteVolumeButtonHover) {
			// lighter fill box
			g.setColor(new Color(50, 50, 50));
			g.fillRoundRect(209, 98, 16, 16, 4, 4);
			
			// darker fill box outline
			g.setColor(new Color(30, 30, 30));
			g.drawRoundRect(208, 97, 18, 17, 4, 4);
		
			// set volume mute button representation lighter
			g.setColor(new Color(150, 150, 150));
		} else {
			// lighter fill box when hovered over
			g.setColor(new Color(150, 150, 150));
			g.fillRoundRect(209, 98, 17, 16, 4, 4);
			
			// darker fill box outline
			g.setColor(new Color(30, 30, 30));
			g.drawRoundRect(208, 97, 18, 17, 4, 4);
			
			// set volume mute button darker when hovered over
			g.setColor(new Color(50, 50, 50));
		}
		// draw volume mute button representation (speaker with arc for noise disseminating outward)
		int[] volumeX = {219, 219, 212};
		int[] volumeY = {111, 100, 105};
		g.fillPolygon(volumeX, volumeY, 3);
		g.fillRect(212, 103, 4, 5);
	
		// only draw arc if volume button isn't muted
		if (!UpdateMiniPlayer.muteVolumeButtonClicked) {
			g.drawArc(218, 102, 4, 6, 0, -90);
			g.drawArc(218, 102, 4, 7, 0, 90);
		}
	}
	
	private static void renderExitButton(Graphics2D g) {
		if (!UpdateMiniPlayer.exitButtonHover) {
			// dark fill circle in corner of music player
			g.setColor(new Color(30, 30, 30));
			g.fillOval(328, 8, 14, 14);
		
			// red fill circle as inset
			g.setColor(new Color(255, 0, 0));
			g.fillOval(330, 10, 10, 10);
		} else {
			// lighter fill circle in corner of music player
			g.setColor(new Color(200, 200, 200));
			g.fillOval(328, 8, 14, 14);
			
			// same red fill circle as inset
			g.setColor(new Color(255, 0, 0));
			g.fillOval(330, 10, 10, 10);
		}
	}
}
