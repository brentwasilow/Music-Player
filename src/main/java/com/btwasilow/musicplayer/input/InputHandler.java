package com.btwasilow.musicplayer.input;

import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import com.btwasilow.musicplayer.Driver;
import com.btwasilow.musicplayer.button.Button;
import com.btwasilow.musicplayer.state.State;
import com.btwasilow.musicplayer.utility.Consts;
import com.btwasilow.musicplayer.utility.Utility;

public class InputHandler implements MouseListener, FocusListener, MouseMotionListener, KeyListener, MouseWheelListener {
	public Driver driver; // reference to AWT container of main class

	public Point mouseMovedPosition = new Point(0, 0); // position of mouse when moved
	public Point mouseClickedPosition = new Point(0, 0); // position of mouse when clicked
	public boolean mouseClicked = false;

	public boolean[] keys = new boolean[256]; // boolean array for determining which key was pressed
	
	public InputHandler(Driver driver) {
		// necessary for updating any JFrame-specific settings
		this.driver = driver;
	}
	
	public void keyPressed(KeyEvent arg0) {
		// set the key position, in the keys array, to true
		keys[arg0.getKeyCode()] = true;
		
		// handles all checks for possible scenarios
		// of any given key press
		keyPressedUpdateRoutines();
	}
	
	private void keyPressedUpdateRoutines() {
		// all key pressed update routines: for now only 2 (songs being displayed and
		// the current song selection) - only update if in expanded music player mode
		// otherwise it would not make sense to be allowed to move the song selection
		// position up and down
		if (Utility.EXPAND_MUSIC_PLAYER_BUTTON.isSelected()) {
			updateCurrentDisplayableSongPosition();
			updateCurrentSongSelection();
		}
	}
		
	private void updateCurrentDisplayableSongPosition() {
		// change currently selected displayable song position down by 1
		if (keys[KeyEvent.VK_DOWN]) {
			moveCurrentDisplayableSongPositionDownOne();
		}
		
		// change currently selected displayable song position up by 1
		if (keys[KeyEvent.VK_UP]) {
			moveCurrentDisplayableSongPositionUpOne();
		}
	}
	
	private void moveCurrentDisplayableSongPositionDownOne() {
		// make sure we have not reached the end of the song list
		if (State.currentSongSelection < State.songs.length-1) {
				State.currentSongSelection++;
				
				// we do not move the displayed song names/info until we have
				// reached the last displayable song position, whereby it changes song info
				// down by one place (handled by moving the block variable in the else) 
				if (State.currentDisplayableSongPosition != Consts.LAST_DISPLAYABLE_SONG_POSITION) {
					State.currentDisplayableSongPosition++;
					Utility.DISPLAYABLE_SONG_POSITIONS[State.currentDisplayableSongPosition-1].select(false);
					Utility.DISPLAYABLE_SONG_POSITIONS[State.currentDisplayableSongPosition].select(true);
				} else {
					State.block++;
				}
		}
	}
	
	private void moveCurrentDisplayableSongPositionUpOne() {
		// make sure we have not reached the start of the song list
		if (State.currentSongSelection > 0) {
			State.currentSongSelection--;

			// we do not move the displayed song names/info until we have
			// reached the first displayable song position, whereby it changes song info
			// up by one place (handled by moving the block variable in the else) 
			if (State.currentDisplayableSongPosition != Consts.FIRST_DISPLAYABLE_SONG_POSITION) {
				State.currentDisplayableSongPosition--;
				Utility.DISPLAYABLE_SONG_POSITIONS[State.currentDisplayableSongPosition+1].select(false);
				Utility.DISPLAYABLE_SONG_POSITIONS[State.currentDisplayableSongPosition].select(true);
			} else {
				State.block--;
			}
		}
	}

	private void updateCurrentSongSelection() {
		// set the currently playing song (will begin the logic for
		// playing the audio)
		if (keys[KeyEvent.VK_ENTER]) {
			State.currentlyPlayingSongName = State.songs[State.currentSongSelection];
		}
	}

	public void keyReleased(KeyEvent arg0) {
		// when the key is released revert that key position
		// back to false
		keys[arg0.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent arg0) {
	}

	public void focusGained(FocusEvent arg0) {

	}

	public void focusLost(FocusEvent arg0) {

	}

	public void mouseClicked(MouseEvent arg0) {
		
	}

	public void mouseEntered(MouseEvent arg0) {

	}

	public void mouseExited(MouseEvent arg0) {

	}
	
	public void mouseReleased(MouseEvent arg0) {
	}
	
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		if (!Utility.EXPAND_MUSIC_PLAYER_BUTTON.isSelected()) {
			return;
		}
		
		// grab notches and move either up or down
		int notches = arg0.getWheelRotation();
		if (notches < 0) {
			moveCurrentDisplayableSongPositionUpOne();
		} else {
			moveCurrentDisplayableSongPositionDownOne();
		}
	}
	
	public void mouseMoved(MouseEvent arg0) {
		mouseMovedPosition = arg0.getPoint();
	}
	
	public void mouseDragged(MouseEvent arg0) {
		// get location of Window
		int thisX = driver.getLocation().x;
		int thisY = driver.getLocation().y;

		// Determine how much the mouse moved since the initial click
		int xMoved = (thisX + arg0.getX()) - (thisX + mouseClickedPosition.x);
		int yMoved = (thisY + arg0.getY()) - (thisY + mouseClickedPosition.y);

		// Move window to this position
		int X = thisX + xMoved;
		int Y = thisY + yMoved;
		driver.setLocation(X, Y);
	}

	public void mousePressed(MouseEvent arg0) {
		// get position of mouse click and determine parent container to allow movement
		mouseClickedPosition = arg0.getPoint();
		driver.getComponentAt(mouseClickedPosition);
		
		// handles all checks for possible scenarios
		// of any given mouse press
		mousePressedUpdateRoutines();
	}
	
	private void mousePressedUpdateRoutines() {
		// update all of the clickable music player boxes/shapes/components
		for (int index = 0; index < Utility.buttons.length; index++) {
			Button button = Utility.buttons[index];
			
			if (button.isHoveredOver()) {
				if (button == Utility.EXIT_BUTTON) {
					updateExitButtonClickState();
				} else if (button == Utility.LEFT_BUTTON) {
					updateLeftButtonClickState();
				} else if (button == Utility.CENTER_BUTTON) {
					updateCenterButtonClickState();
				} else if (button == Utility.RIGHT_BUTTON) {
					updateRightButtonClickState();
				} else if (button == Utility.MUTE_VOLUME_BUTTON) {
					updateMuteVolumeButtonClickState();
				} else if (button == Utility.VOLUME_FILL_BAR) {
					updateVolumeFillBarClickState();
				} else if (button == Utility.EXPAND_MUSIC_PLAYER_BUTTON) {
					updateExpandMusicPlayerButtonClickState();
				} else if (button == Utility.SONG_FILL_BAR) {
					updateSongFillBarClickState();
				}
			}
		}
		updateMusicLibrarySongSelectionClickState();
	}
	
	private void updateExitButtonClickState() {
		System.exit(0);
	}
	
	private void updateLeftButtonClickState() {
		Utility.LEFT_BUTTON.select(true);
	}
	
	private void updateCenterButtonClickState() {
		Utility.CENTER_BUTTON.select(true);
	}

	private void updateRightButtonClickState() {
		Utility.RIGHT_BUTTON.select(true);
	}
	
	private void updateMuteVolumeButtonClickState() {
		// like a switch (turns off button if clicked already
		// or turns on button if not clicked already)
		if (Utility.MUTE_VOLUME_BUTTON.isSelected()) {
			Utility.MUTE_VOLUME_BUTTON.select(false);
		} else {
			Utility.MUTE_VOLUME_BUTTON.select(true);
		}
	}
	
	private void updateVolumeFillBarClickState() {
		// unmute and update the volume level based on
		// physical coordinates of click
		Utility.MUTE_VOLUME_BUTTON.select(false);
		State.volume = mouseClickedPosition.x - Consts.VOLUME_FILL_BAR_STARTING_PIXEL_POS;
		
		// squash volume level between 0 and 100 (min and max volume levels)
		if (State.volume < Consts.MIN_VOLUME_LEVEL) {
			State.volume = Consts.MIN_VOLUME_LEVEL;
 		} else if (State.volume > Consts.MAX_VOLUME_LEVEL) {
 			State.volume = Consts.MAX_VOLUME_LEVEL;
 		}
	}
	
	private void updateExpandMusicPlayerButtonClickState() {
		// switch music player mode based on current state
		// (make mini if already expanded or expand if already mini)
		if (Utility.EXPAND_MUSIC_PLAYER_BUTTON.isSelected()) {
			Utility.EXPAND_MUSIC_PLAYER_BUTTON.select(false);
		} else {
			Utility.EXPAND_MUSIC_PLAYER_BUTTON.select(true);
		}
	}
	
	private void updateSongFillBarClickState() {
		// update song temporal position according to physical
		// coordinates of click
		State.currentlyPlayingSongTimePosition = mouseClickedPosition.x - Consts.SONG_FILL_BAR_STARTING_PIXEL_POS;
	}
	
	private void updateMusicLibrarySongSelectionClickState() {
		// only update song selection if in expanded music player mode
		// otherwise it would not make sense to move song position
		if (!Utility.EXPAND_MUSIC_PLAYER_BUTTON.isSelected()) {
			return;
		}
		
		// check each displayable song position for the one being clicked right now
		for (int index = 0; index < Consts.NUM_OF_DISPLAYABLE_SONG_POSITIONS; index++) {
			if (Utility.DISPLAYABLE_SONG_POSITIONS[index].isHoveredOver()) {
				// unset the old displayable song position and set the new one
				Utility.DISPLAYABLE_SONG_POSITIONS[State.currentDisplayableSongPosition].select(false);
				Utility.DISPLAYABLE_SONG_POSITIONS[index].select(true);
				
				// check to see if click state is lower on the list or higher, and adjust
				// song selection and displayable song position variables accordingly
				State.currentSongSelection += (index - State.currentDisplayableSongPosition);
				State.currentDisplayableSongPosition = index;
			}
		}
	}
}
