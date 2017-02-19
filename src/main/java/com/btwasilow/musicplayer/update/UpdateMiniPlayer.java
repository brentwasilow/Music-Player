package com.btwasilow.musicplayer.update;

import java.util.Random;

import com.btwasilow.musicplayer.input.InputHandler;

public class UpdateMiniPlayer {
	public static boolean exitButtonHover = false;
	
	public static boolean leftButtonHover = false;
	public static boolean leftButtonClicked = false;
	
	public static boolean centerButtonHover = false;
	public static boolean centerButtonClicked = false;
	
	public static boolean rightButtonHover = false;
	public static boolean rightButtonClicked = false;
	
	public static boolean muteVolumeButtonHover = false;
	public static boolean muteVolumeButtonClicked = false;
	public static boolean volumeFillBarHover = false;
	
	public static boolean expandMusicPlayerButtonHover = false;
	public static boolean expandMusicPlayerButtonClicked = false;
	
	public static boolean songTimeFillBarHover = false;
	
	public static String currentlyPlayingSongName = "";
	public static int currentlyPlayingSongVolume = 25;
	public static int currentlyPlayingSongTimePosition = 0;
	public static int currentSongSelection = 0;
	
	public static int scrollBarSize = 344;
	
	public static Random rand = new Random();
	
	public static int block = 0;
	
	public static boolean songListHoverPosition[] = new boolean[14];
	public static boolean songListHoverPositionClicked[] = {true, false, false, false, false,
															false, false, false, false, false,
															false, false, false, false};
	
	private UpdateMiniPlayer() {
	}
	
	public static void update(InputHandler input) {
		resetStateVariables();

		updateExitButtonHoverState(input);
		
		updateLeftButtonHoverState(input);
		updateCenterButtonHoverState(input);
		updateRightButtonHoverState(input);
		
		updateMuteVolumeButtonHoverState(input);
		updateVolumeFillBarHoverState(input);
		
		updateExpandMusicPlayerButtonHoverState(input);
		
		updateSongTimeFillBarHoverState(input);
		
		updateExpandedMusicPlayerSongListHoverState(input);
	}
	
	private static void resetStateVariables() {
		exitButtonHover = false;
		
		leftButtonHover = false;
		centerButtonHover = false;
		rightButtonHover = false;
		
		muteVolumeButtonHover = false;
		volumeFillBarHover = false;
		
		expandMusicPlayerButtonHover = false;
		
		songTimeFillBarHover = false;
		
		for (int i = 0; i < 14; i++) {
			songListHoverPosition[i] = false;
		}
	}
	
	private static void updateExitButtonHoverState(InputHandler input) {
		if (input.mouseMovedPosition.x >= 328 && input.mouseMovedPosition.x <= 342 &&
			input.mouseMovedPosition.y >= 8 && input.mouseMovedPosition.y <= 22) {
			exitButtonHover = true;
		}
	}
	
	private static void updateLeftButtonHoverState(InputHandler input) {
		if (input.mouseMovedPosition.x >= 119 && input.mouseMovedPosition.x <= 159 &&
			input.mouseMovedPosition.y >= 31 && input.mouseMovedPosition.y <= 71) {
			leftButtonHover = true;
		}
	}
	
	private static void updateCenterButtonHoverState(InputHandler input) {
		if (input.mouseMovedPosition.x >= 190 && input.mouseMovedPosition.x <= 240 &&
			input.mouseMovedPosition.y >= 26 && input.mouseMovedPosition.y <= 76) {
			centerButtonHover = true;
		}
	}
	
	private static void updateRightButtonHoverState(InputHandler input) {
		if (input.mouseMovedPosition.x >= 269 && input.mouseMovedPosition.x <= 309 &&
			input.mouseMovedPosition.y >= 31 && input.mouseMovedPosition.y <= 71) {
			rightButtonHover = true;
		}
	}
	
	private static void updateMuteVolumeButtonHoverState(InputHandler input) {
		if (input.mouseMovedPosition.x >= 210 && input.mouseMovedPosition.x <= 227 &&
			input.mouseMovedPosition.y >= 101 && input.mouseMovedPosition.y <= 117) {
			muteVolumeButtonHover = true;
		}
	}
	
	private static void updateVolumeFillBarHoverState(InputHandler input) {
		if (input.mouseMovedPosition.x >= 237 && input.mouseMovedPosition.x <= 339 &&
			input.mouseMovedPosition.y >= 106 && input.mouseMovedPosition.y <= 111) {
			volumeFillBarHover = true;
		}
	}
	
	private static void updateExpandMusicPlayerButtonHoverState(InputHandler input) {
		if (input.mouseMovedPosition.x >= 183 && input.mouseMovedPosition.x <= 200 &&
			input.mouseMovedPosition.y >= 101 && input.mouseMovedPosition.y <= 117) {
			expandMusicPlayerButtonHover = true;
		}
	}
	
	private static void updateSongTimeFillBarHoverState(InputHandler input) {
		if (input.mouseMovedPosition.x >= 10 && input.mouseMovedPosition.x <= 339 &&
			input.mouseMovedPosition.y >= 134 && input.mouseMovedPosition.y <= 142) {
			songTimeFillBarHover = true;
		}
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
