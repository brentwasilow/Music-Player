package com.btwasilow.musicplayer.update;

import com.btwasilow.musicplayer.input.InputHandler;

public class UpdateMiniPlayer {
	public static boolean exitButtonHover = false;
	public static boolean leftButtonHover = false;
	public static boolean centerButtonHover = false;
	public static boolean rightButtonHover = false;
	public static boolean expandMusicPlayerButtonHover = false;
	public static boolean muteVolumeButtonHover = false;
	
	public static int currentlyPlayingSongVolume = 25;
	public static int currentlyPlayingSongTimePosition = 0;
	
	private UpdateMiniPlayer() {
	}
	
	public static void update(InputHandler input) {
		resetStateVariables();
		
		updateExitButtonState(input);
		updateLeftButtonState(input);
		updateCenterButtonState(input);
		updateRightButtonState(input);
		updateMuteVolumeButtonState(input);
		updateExpandMusicPlayerButtonState(input);
		
		updateVolumeButtonFillBar(input);
		updateTimeFillBar(input);
	}
	
	private static void resetStateVariables() {
		exitButtonHover = false;
		leftButtonHover = false;
		centerButtonHover = false;
		rightButtonHover = false;
		expandMusicPlayerButtonHover = false;
		muteVolumeButtonHover = false;
	}
	
	private static void updateExitButtonState(InputHandler input) {
		if (input.mouseMovedPosition.x >= 328 && input.mouseMovedPosition.x <= 342 &&
			input.mouseMovedPosition.y >= 8 && input.mouseMovedPosition.y <= 22) {
			exitButtonHover = true;

			if (input.mouseClicked) {
				System.exit(0);
			}
		}
	}
	
	private static void updateLeftButtonState(InputHandler input) {
		if (input.mouseMovedPosition.x >= 119 && input.mouseMovedPosition.x <= 159 &&
			input.mouseMovedPosition.y >= 31 && input.mouseMovedPosition.y <= 71) {
			leftButtonHover = true;
			
			if (input.mouseClicked) {
				// left button click logic
			}
		}
	}
	
	private static void updateCenterButtonState(InputHandler input) {
		if (input.mouseMovedPosition.x >= 190 && input.mouseMovedPosition.x <= 240 &&
			input.mouseMovedPosition.y >= 26 && input.mouseMovedPosition.y <= 76) {
			centerButtonHover = true;
			
			if (input.mouseClicked) {
				// center button click logic
			}
		}
	}
	
	private static void updateRightButtonState(InputHandler input) {
		if (input.mouseMovedPosition.x >= 269 && input.mouseMovedPosition.x <= 309 &&
			input.mouseMovedPosition.y >= 31 && input.mouseMovedPosition.y <= 71) {
			rightButtonHover = true;
			
			if (input.mouseClicked) {
				// right button click logic
			}
		}
	}
	
	private static void updateMuteVolumeButtonState(InputHandler input) {
		if (input.mouseMovedPosition.x >= 210 && input.mouseMovedPosition.x <= 227 &&
			input.mouseMovedPosition.y >= 101 && input.mouseMovedPosition.y <= 117) {
			muteVolumeButtonHover = true;
			
			if (input.mouseClicked) {
				// mute volume click logic
			}
		}
	}
	
	private static void updateExpandMusicPlayerButtonState(InputHandler input) {
		if (input.mouseMovedPosition.x >= 183 && input.mouseMovedPosition.x <= 200 &&
			input.mouseMovedPosition.y >= 101 && input.mouseMovedPosition.y <= 117) {
			expandMusicPlayerButtonHover = true;
			
			if (input.mouseClicked) {
				// music player expand click logic
			}
		}
	}
	
	private static void updateVolumeButtonFillBar(InputHandler input) {
		if (input.mouseMovedPosition.x >= 237 && input.mouseMovedPosition.x <= 339 &&
			input.mouseMovedPosition.y >= 106 && input.mouseMovedPosition.y <= 111) {
			if (input.mouseClicked) {
				UpdateMiniPlayer.currentlyPlayingSongVolume = (input.mouseClickedPosition.x - 237);
			}
		}
	}
	
	private static void updateTimeFillBar(InputHandler input) {
		if (input.mouseMovedPosition.x >= 10 && input.mouseMovedPosition.x <= 339 &&
			input.mouseMovedPosition.y >= 134 && input.mouseMovedPosition.y <= 142) {
			if (input.mouseClicked) {
				UpdateMiniPlayer.currentlyPlayingSongTimePosition = (input.mouseClickedPosition.x - 10);
			}
		}
	}
}
