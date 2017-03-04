package com.btwasilow.musicplayer.update;

import com.btwasilow.musicplayer.input.InputHandler;
import com.btwasilow.musicplayer.utility.Utility;

public class UpdatePlayer {
	private UpdatePlayer() {
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
		
		// assume same state reset but for all of the displayable song positions
		for (int index = 0; index < Utility.DISPLAYABLE_SONG_POSITIONS.length; index++) {
			Utility.DISPLAYABLE_SONG_POSITIONS[index].setHoveredOver(false);
		}
	}
	
	private static void updateHoverStates(InputHandler input) {
		// for each button check if mouse is inside bounding box
		for (int index = 0; index < Utility.buttons.length; index++) {
			if (Utility.buttons[index].getBoundingBox().contains(input.mouseMovedPosition.x, input.mouseMovedPosition.y)) {
				Utility.buttons[index].setHoveredOver(true);
			}
		}
		
		// perform the same check but with all of the displayable song positions
		for (int index = 0; index < Utility.DISPLAYABLE_SONG_POSITIONS.length; index++) {
			if (Utility.DISPLAYABLE_SONG_POSITIONS[index].getBoundingBox().contains(input.mouseMovedPosition.x, input.mouseMovedPosition.y)) {
				Utility.DISPLAYABLE_SONG_POSITIONS[index].setHoveredOver(true);
			}
		}
	}
}
