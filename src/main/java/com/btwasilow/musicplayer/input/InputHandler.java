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
import com.btwasilow.musicplayer.render.RenderMiniPlayer;
import com.btwasilow.musicplayer.update.UpdateMiniPlayer;

public class InputHandler implements MouseListener, FocusListener, MouseMotionListener, KeyListener, MouseWheelListener {
	public Driver driver; // reference to AWT container of main class

	public Point mouseMovedPosition = new Point(0, 0);
	public Point mouseClickedPosition = new Point (0, 0);
	public boolean mouseClicked = false;

	private boolean[] keys = new boolean[256]; // boolean array for determining which key was pressed
	public boolean up; // handles up key
	public boolean down; // handles down key
	public boolean left; // handles left key
	public boolean right; // handles right key
	public boolean escape; // handles escape key
	public boolean space; // handles space key
	public boolean enter;

	public InputHandler(Driver driver) {
		this.driver = driver;
	}

	public void update() {
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		escape = keys[KeyEvent.VK_ESCAPE];
		space = keys[KeyEvent.VK_SPACE];
		enter = keys[KeyEvent.VK_ENTER];
	}
	
	public void keyPressed(KeyEvent arg0) {
		keys[arg0.getKeyCode()] = true;
		update();
		
		keyPressedUpdateRoutines();
	}

	public void keyReleased(KeyEvent arg0) {
		keys[arg0.getKeyCode()] = false;
		update();
	}
	
	private void keyPressedUpdateRoutines() {
		updateMusicLibrarySongsBeingDisplayed();
		updateCurrentSongSelection();

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
		if (UpdateMiniPlayer.exitButtonHover) {
			System.exit(0);
		}
	}
	
	private void updateLeftButtonClickState() {
		if (UpdateMiniPlayer.leftButtonHover) {
			// left button click logic
		}
	}
	
	private void updateCenterButtonClickState() {
		if (UpdateMiniPlayer.centerButtonHover) {
			// center button click logic
		}
	}

	private void updateRightButtonClickState() {
		if (UpdateMiniPlayer.rightButtonHover) {
			// right button click logic
		}
	}
	
	private void updateMuteVolumeButtonClickState() {
		if (UpdateMiniPlayer.muteVolumeButtonHover) {
			if (UpdateMiniPlayer.muteVolumeButtonClicked) { // if volume is muted, then un-mute
				UpdateMiniPlayer.muteVolumeButtonClicked = false;
			} else { // if volume is not muted, then mute
				UpdateMiniPlayer.muteVolumeButtonClicked = true;
			}
		}
	}
	
	private void updateVolumeFillBarClickState() {
		// if hovering over volume fill bar and clicked, then unmute if muted and
		// update the volume value
		if (UpdateMiniPlayer.volumeFillBarHover) {
			UpdateMiniPlayer.muteVolumeButtonClicked = false;
			UpdateMiniPlayer.currentlyPlayingSongVolume = (mouseClickedPosition.x - 237);
		}
	}
	
	private void updateExpandMusicPlayerButtonClickState() {
		if (UpdateMiniPlayer.expandMusicPlayerButtonHover) {
			if (UpdateMiniPlayer.expandMusicPlayerButtonClicked) { // if music player is expanded then miniaturize
				UpdateMiniPlayer.expandMusicPlayerButtonClicked = false;
			} else { // expand music player
				UpdateMiniPlayer.expandMusicPlayerButtonClicked = true;
			}
		}
	}
	
	private void updateSongTimeFillBarClickState() {
		if (UpdateMiniPlayer.songTimeFillBarHover) { // update song time position according to position clicked
			UpdateMiniPlayer.currentlyPlayingSongTimePosition = (mouseClickedPosition.x - 10);
		}
	}
	
	private void updateMusicLibrarySongsBeingDisplayed() {
		if (!UpdateMiniPlayer.expandMusicPlayerButtonClicked) {
			return;
		}
		if (down) { // change current song selection by 1 but only if it isnt the end of the list
			moveSongSelectionClickedDown();
		}
		if (up) { // change current song selection until the start of the library list
			moveSongSelectionClickedUp();
		}
	}

	private void updateCurrentSongSelection() {
		if (!UpdateMiniPlayer.expandMusicPlayerButtonClicked) {
			return;
		}
		if (enter) { // select this song to display it
			UpdateMiniPlayer.currentlyPlayingSongName = RenderMiniPlayer.songs[UpdateMiniPlayer.currentSongSelection];

			// start playing the song (no implementation yet)
		}
	}
	
	private void updateMusicLibrarySongSelectionClickState() {
		if (!UpdateMiniPlayer.expandMusicPlayerButtonClicked) {
			return;
		}
		int j = 0;
		for (; j < 14; j++) {
			if (UpdateMiniPlayer.songListHoverPositionClicked[j]) {
				break;
			}
		}
		for (int i = 0; i < 14; i++) {
			if (UpdateMiniPlayer.songListHoverPosition[i]) {
				resetClickedPositions();
				UpdateMiniPlayer.songListHoverPositionClicked[i] = true;
				
				// check to see if click state is lower on the list or higher, and adjust
				// song selection variable accordingly
				UpdateMiniPlayer.currentSongSelection += (i-j);
			}
		}
	}
	
	private void resetClickedPositions() {
		for (int i = 0; i < 14; i++) {
			UpdateMiniPlayer.songListHoverPositionClicked[i] = false;
		}
	}

	public void mouseWheelMoved(MouseWheelEvent arg0) {
		if (!UpdateMiniPlayer.expandMusicPlayerButtonClicked) {
			return;
		}
		int notches = arg0.getWheelRotation();
		if (notches < 0) {
			// moved up
			moveSongSelectionClickedUp();
		} else {
			// moved down
			moveSongSelectionClickedDown();
		}
	}
	
	private void moveSongSelectionClickedUp() {
		if (UpdateMiniPlayer.currentSongSelection > 0) {
			UpdateMiniPlayer.currentSongSelection--;
			
			if (!UpdateMiniPlayer.songListHoverPositionClicked[0]) {
				for (int i = 0; i < 14; i++) {
					if (UpdateMiniPlayer.songListHoverPositionClicked[i]) {
						UpdateMiniPlayer.songListHoverPositionClicked[i] = false;
						UpdateMiniPlayer.songListHoverPositionClicked[i-1] = true;
						break;
					}
				}
			} else {
				UpdateMiniPlayer.block--;
			}
		}
	}
	
	private void moveSongSelectionClickedDown() {
		if (UpdateMiniPlayer.currentSongSelection < RenderMiniPlayer.songs.length-1) {
				UpdateMiniPlayer.currentSongSelection++;
				
				if (!UpdateMiniPlayer.songListHoverPositionClicked[13]) {
					for (int i = 0; i < 14; i++) {
						if (UpdateMiniPlayer.songListHoverPositionClicked[i]) {
							UpdateMiniPlayer.songListHoverPositionClicked[i] = false;
							UpdateMiniPlayer.songListHoverPositionClicked[i+1] = true;
							break;
						}
					}
				} else {
					UpdateMiniPlayer.block++;
				}
		}
	}
}
