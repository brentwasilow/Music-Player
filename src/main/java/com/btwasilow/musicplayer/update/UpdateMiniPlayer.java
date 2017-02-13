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
		
		updateExitState(input);
	}
	
	private static void resetStateVariables() {
		exitButtonHover = false;
		leftButtonHover = false;
		centerButtonHover = false;
		rightButtonHover = false;
		expandMusicPlayerButtonHover = false;
		muteVolumeButtonHover = false;
	}
	
	private static void updateExitState(InputHandler input) {
		if (input.mouseMovedPosition.x >= 328 && input.mouseMovedPosition.x <= 342 &&
			input.mouseMovedPosition.y >= 8 && input.mouseMovedPosition.y <= 22) {
			exitButtonHover = true;

			if (input.mouseClicked) {
				System.exit(0);
			}
		}
	}
}
