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
import java.util.Random;

import com.btwasilow.musicplayer.Driver;
import com.btwasilow.musicplayer.render.RenderPlayer;
import com.btwasilow.musicplayer.utility.Consts;
import com.btwasilow.musicplayer.utility.Utility;

public class InputHandler implements MouseListener, FocusListener, MouseMotionListener, KeyListener, MouseWheelListener {
	public Driver driver; // reference to AWT container of main class

	public Point mouseMovedPosition = new Point(0, 0); // position of mouse when moved
	public Point mouseClickedPosition = new Point(0, 0); // position of mouse when clicked
	public boolean mouseClicked = false;

	public boolean[] keys = new boolean[256]; // boolean array for determining which key was pressed
	
	public static String currentlyPlayingSongName = "";
	public static int currentlyPlayingSongVolume = 25;
	public static int currentlyPlayingSongTimePosition = 0;
	public static int currentSongSelection = 0;
	public static int currentDisplayableSongPosition = 0;
	
	public static Random rand = new Random(); // used for equalizer rendering
	
	public static int block = 0;

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
		// the current song selection)
		updateCurrentDisplayableSongPosition();
		updateCurrentSongSelection();
	}
	
	private void updateCurrentDisplayableSongPosition() {
		// if in miniplayer mode then we cannot move our song selection
		// up or down so do nothing and just return
		if (!Utility.EXPAND_MUSIC_PLAYER_BUTTON.isSelected()) {
			return;
		}
		
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
		if (currentSongSelection < RenderPlayer.songs.length-1) {
				currentSongSelection++;
				
				// allows us to not scroll the display list until we have
				// reached the bottom (the 14th position), whereby we scroll
				// the songs by one position in the downward direction for
				// each down key press
				//if (!Utility.DISPLAYABLE_SONG_POSITIONS[Consts.LAST_DISPLAYABLE_SONG_POSITION_INDEX].isSelected()) {
				//	for (int i = 0; i < 14; i++) {
				//		if (Utility.DISPLAYABLE_SONG_POSITIONS[i].isSelected()) {
				//			Utility.DISPLAYABLE_SONG_POSITIONS[i].select(false);
				//			Utility.DISPLAYABLE_SONG_POSITIONS[i+1].select(true);
				//			break;
				//		}
				//	}
				//} else {
				//	block++;
				//}
				if (currentDisplayableSongPosition != Consts.LAST_DISPLAYABLE_SONG_POSITION) {
					currentDisplayableSongPosition++;
					Utility.DISPLAYABLE_SONG_POSITIONS[currentDisplayableSongPosition-1].select(false);
					Utility.DISPLAYABLE_SONG_POSITIONS[currentDisplayableSongPosition].select(true);
				} else {
					block++;
				}
		}
	}
	
	private void moveCurrentDisplayableSongPositionUpOne() {
		// make sure we have not reached the start of the song list
		if (currentSongSelection > 0) {
			currentSongSelection--;
			
			//if (!Utility.DISPLAYABLE_SONG_POSITIONS[0].isSelected()) {
			//	for (int i = 0; i < 14; i++) {
			//		if (Utility.DISPLAYABLE_SONG_POSITIONS[i].isSelected()) {
			//			Utility.DISPLAYABLE_SONG_POSITIONS[i].select(false);
			//			Utility.DISPLAYABLE_SONG_POSITIONS[i-1].select(true);
			//			break;
			//		}
			//	}
			if (currentDisplayableSongPosition != Consts.FIRST_DISPLAYABLE_SONG_POSITION) {
				currentDisplayableSongPosition--;
				Utility.DISPLAYABLE_SONG_POSITIONS[currentDisplayableSongPosition+1].select(false);
				Utility.DISPLAYABLE_SONG_POSITIONS[currentDisplayableSongPosition].select(true);
			} else {
				block--;
			}
		}
	}

	private void updateCurrentSongSelection() {
		if (!Utility.EXPAND_MUSIC_PLAYER_BUTTON.isSelected()) {
			return;
		}
		if (keys[KeyEvent.VK_ENTER]) { // select this song to display it
			currentlyPlayingSongName = RenderPlayer.songs[currentSongSelection];
		}
	}

	public void keyReleased(KeyEvent arg0) {
		// when the key is released revert that key position
		// back to false
		keys[arg0.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent arg0) {
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

	public void mouseMoved(MouseEvent arg0) {
		mouseMovedPosition = arg0.getPoint();
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

	public void mousePressed(MouseEvent arg0) {
		// get position of mouse click and determine parent container to allow movement
		mouseClickedPosition = arg0.getPoint();
		driver.getComponentAt(mouseClickedPosition);
		
		
		mousePressedUpdateRoutines();
	}

	public void mouseReleased(MouseEvent arg0) {
	}
	
	private void mousePressedUpdateRoutines() {
		updateExitButtonClickState();
		
		updateLeftButtonClickState();
		updateCenterButtonClickState();
		updateRightButtonClickState();
		
		updateMuteVolumeButtonClickState();
		updateVolumeFillBarClickState();
		
		updateExpandMusicPlayerButtonClickState();
		
		updateSongTimeFillBarClickState();
		
		updateMusicLibrarySongSelectionClickState();
	}
	
	private void updateExitButtonClickState() {
		if (Utility.EXIT_BUTTON.isHoveredOver()) {
			System.exit(0);
		}
	}
	
	private void updateLeftButtonClickState() {
		if (Utility.LEFT_BUTTON.isHoveredOver()) {
			// left button click logic
			Utility.LEFT_BUTTON.select(true);
		}
	}
	
	private void updateCenterButtonClickState() {
		if (Utility.CENTER_BUTTON.isHoveredOver()) {
			// center button click logic
			Utility.CENTER_BUTTON.select(true);
		}
	}

	private void updateRightButtonClickState() {
		if (Utility.RIGHT_BUTTON.isHoveredOver()) {
			// right button click logic
			Utility.RIGHT_BUTTON.select(true);
		}
	}
	
	private void updateMuteVolumeButtonClickState() {
		/*if (UpdateMiniPlayer.muteVolumeButtonHover) {
			if (UpdateMiniPlayer.muteVolumeButtonClicked) { // if volume is muted, then un-mute
				UpdateMiniPlayer.muteVolumeButtonClicked = false;
			} else { // if volume is not muted, then mute
				UpdateMiniPlayer.muteVolumeButtonClicked = true;
			}
		}*/
		if (Utility.VOLUME_MUTE_BUTTON.isHoveredOver()) {
			if (Utility.VOLUME_MUTE_BUTTON.isSelected()) {
				Utility.VOLUME_MUTE_BUTTON.select(false);
			} else {
				Utility.VOLUME_MUTE_BUTTON.select(true);
			}
		}
	}
	
	private void updateVolumeFillBarClickState() {
		// if hovering over volume fill bar and clicked, then unmute if muted and
		// update the volume value
		if (Utility.VOLUME_FILL_BAR.isHoveredOver()) {
			Utility.VOLUME_MUTE_BUTTON.select(false);
			currentlyPlayingSongVolume = (mouseClickedPosition.x - 237);
		}
	}
	
	private void updateExpandMusicPlayerButtonClickState() {
		if (Utility.EXPAND_MUSIC_PLAYER_BUTTON.isHoveredOver()) {
			if (Utility.EXPAND_MUSIC_PLAYER_BUTTON.isSelected()) { // if music player is expanded then miniaturize
				Utility.EXPAND_MUSIC_PLAYER_BUTTON.select(false);
			} else { // expand music player
				Utility.EXPAND_MUSIC_PLAYER_BUTTON.select(true);;
			}
		}
	}
	
	private void updateSongTimeFillBarClickState() {
		if (Utility.SONG_FILL_BAR.isHoveredOver()) { // update song time position according to position clicked
			currentlyPlayingSongTimePosition = (mouseClickedPosition.x - 10);
		}
	}
	
	private void updateMusicLibrarySongSelectionClickState() {
		if (!Utility.EXPAND_MUSIC_PLAYER_BUTTON.isSelected()) {
			return;
		}
		int j = 0;
		for (; j < 14; j++) {
			if (Utility.DISPLAYABLE_SONG_POSITIONS[j].isSelected()) {
				break;
			}
		}
		for (int i = 0; i < 14; i++) {
			if (Utility.DISPLAYABLE_SONG_POSITIONS[i].isHoveredOver()) {
				resetClickedPositions();
				Utility.DISPLAYABLE_SONG_POSITIONS[i].select(true);
				
				// check to see if click state is lower on the list or higher, and adjust
				// song selection variable accordingly
				currentSongSelection += (i-j);
			}
		}
	}
	
	private void resetClickedPositions() {
		for (int i = 0; i < 14; i++) {
			Utility.DISPLAYABLE_SONG_POSITIONS[i].select(false);
		}
	}

	public void mouseWheelMoved(MouseWheelEvent arg0) {
		if (!Utility.EXPAND_MUSIC_PLAYER_BUTTON.isSelected()) {
			return;
		}
		int notches = arg0.getWheelRotation();
		if (notches < 0) {
			// moved up
			moveCurrentDisplayableSongPositionUpOne();
		} else {
			// moved down
			moveCurrentDisplayableSongPositionDownOne();
		}
	}
}
