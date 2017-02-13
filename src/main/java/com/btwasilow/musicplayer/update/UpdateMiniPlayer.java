package com.btwasilow.musicplayer.update;

import com.btwasilow.musicplayer.input.InputHandler;

public class UpdateMiniPlayer {
	public static boolean exitButtonHover = false;
	
	private UpdateMiniPlayer() {
	}
	
	public static void update(InputHandler input) {
		exitButtonHover = false;
		
		updateExitState(input);
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
