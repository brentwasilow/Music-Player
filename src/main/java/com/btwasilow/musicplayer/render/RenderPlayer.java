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
		
		for (int index = 0; index < State.DISPLAYABLE_SONG_POSITION_COMPONENTS.length; index++) {
			State.DISPLAYABLE_SONG_POSITION_COMPONENTS[index].render(g);
		}
		
		if (ExpandMusicPlayerButton.getInstance().isSelected()) {
			renderExpandedMusicPlayerSongList(g);
		}
		
		for (int index = 0; index < State.CLICKABLE_COMPONENTS.length; index++) {
			State.CLICKABLE_COMPONENTS[index].render(g);
		}
		
		Utility.musicPlayerGUISetup(driver);
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
