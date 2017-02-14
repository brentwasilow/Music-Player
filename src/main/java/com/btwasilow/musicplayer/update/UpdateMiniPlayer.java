package com.btwasilow.musicplayer.update;

import com.btwasilow.musicplayer.input.InputHandler;

public class UpdateMiniPlayer {
	public static boolean exitButtonHover = false;
	public static boolean leftButtonHover = false;
	public static boolean centerButtonHover = false;
	public static boolean rightButtonHover = false;
	public static boolean expandMusicPlayerButtonHover = false;
	public static boolean muteVolumeButtonHover = false;
	
	private UpdateMiniPlayer() {
	}
	
	public static void update(InputHandler input) {
		resetStateVariables();
		
		updateExitButtonState(input);
		updateLeftButtonState(input);
		updateCenterButtonState(input);
		updateRightButtonState(input);
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
}
