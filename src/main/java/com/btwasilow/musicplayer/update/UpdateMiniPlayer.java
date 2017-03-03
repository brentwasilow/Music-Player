package com.btwasilow.musicplayer.update;

import java.util.Random;

import com.btwasilow.musicplayer.input.InputHandler;
import com.btwasilow.musicplayer.utility.Consts;
import com.btwasilow.musicplayer.utility.Utility;

public class UpdateMiniPlayer {
	public static String currentlyPlayingSongName = "";
	public static int currentlyPlayingSongVolume = 25;
	public static int currentlyPlayingSongTimePosition = 0;
	public static int currentSongSelection = 0;
	
	public static Random rand = new Random();
	
	public static int block = 0;
	
	public static boolean songListHoverPosition[] = new boolean[14];
	public static boolean songListHoverPositionClicked[] = {true, false, false, false, false,
															false, false, false, false, false,
															false, false, false, false};
	
	private UpdateMiniPlayer() {
		throw new AssertionError();
	}
	
	public static void update(InputHandler input) {
		resetStateVariables();
		updateHoverStates(input);
	}
	
	private static void resetStateVariables() {
		// reset the state of all buttons such that we assume none of them
		// are being hovered over until deemed otherwise
		for (int index = 0; index < Utility.buttons.length; index++) {
			Utility.buttons[index].setHoveredOver(false);
		}
		
		for (int index = 0; index < Consts.NUM_OF_DISPLAYABLE_SONG_POSITIONS; index++) {
			songListHoverPosition[index] = false;
		}
	}
	
	private static void updateHoverStates(InputHandler input) {
		for (int i = 0; i < Utility.buttons.length; i++) {
			if (Utility.buttons[i].getBoundingBox().contains(input.mouseMovedPosition.x, input.mouseMovedPosition.y)) {
				Utility.buttons[i].setHoveredOver(true);
			}
		}
		updateExpandedMusicPlayerSongListHoverState(input);
	}
	
	private static void updateExpandedMusicPlayerSongListHoverState(InputHandler input) {
		for (int i = 0; i < 14; i++) {
			if (input.mouseMovedPosition.x >= 25 && input.mouseMovedPosition.x <= 333 &&
				input.mouseMovedPosition.y >= (210+(i*23)) && input.mouseMovedPosition.y < (210+((i+1)*23))) {
				songListHoverPosition[i] = true;
			}
		}
	}
}
