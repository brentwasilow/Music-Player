package com.btwasilow.musicplayer.update;

import com.btwasilow.musicplayer.input.InputHandler;
import com.btwasilow.musicplayer.state.State;

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
		for (int index = 0; index < State.CLICKABLE_COMPONENTS.length; index++) {
			State.CLICKABLE_COMPONENTS[index].setHoveredOver(false);
		}
		
		// assume same state reset but for all of the displayable song positions
		for (int index = 0; index < State.DISPLAYABLE_SONG_POSITION_COMPONENTS.length; index++) {
			State.DISPLAYABLE_SONG_POSITION_COMPONENTS[index].setHoveredOver(false);
		}
}
	
	private static void updateHoverStates(InputHandler input) {
		// for each button check if mouse is inside bounding box
		for (int index = 0; index < State.CLICKABLE_COMPONENTS.length; index++) {
			if (State.CLICKABLE_COMPONENTS[index].getBoundingBox().contains(input.mouseMovedPosition.x, input.mouseMovedPosition.y)) {
				State.CLICKABLE_COMPONENTS[index].setHoveredOver(true);
			}
		}
		
		// perform the same check but with all of the displayable song positions
		for (int index = 0; index < State.DISPLAYABLE_SONG_POSITION_COMPONENTS.length; index++) {
			if (State.DISPLAYABLE_SONG_POSITION_COMPONENTS[index].getBoundingBox().contains(input.mouseMovedPosition.x, input.mouseMovedPosition.y)) {
				State.DISPLAYABLE_SONG_POSITION_COMPONENTS[index].setHoveredOver(true);
			}
		}
	}
}
