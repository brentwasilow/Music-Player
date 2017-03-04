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
import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import com.btwasilow.musicplayer.Driver;
import com.btwasilow.musicplayer.render.RenderPlayer;
import com.btwasilow.musicplayer.update.UpdatePlayer;
import com.btwasilow.musicplayer.utility.Utility;

public class InputHandler implements MouseListener, FocusListener, MouseMotionListener, KeyListener, MouseWheelListener {
	public Driver driver; // reference to AWT container of main class
	
	public Clip clip;

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
	
	public static String currentlyPlayingSongName = "";
	public static int currentlyPlayingSongVolume = 25;
	public static int currentlyPlayingSongTimePosition = 0;
	public static int currentSongSelection = 0;
	
	public static Random rand = new Random();
	
	public static int block = 0;

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
		if (Utility.EXIT_BUTTON.isHoveredOver()) {
			System.exit(0);
		}
	}
	
	private void updateLeftButtonClickState() {
		if (Utility.LEFT_BUTTON.isHoveredOver()) {
			// left button click logic
			Utility.LEFT_BUTTON.setClicked(true);
		}
	}
	
	private void updateCenterButtonClickState() {
		if (Utility.CENTER_BUTTON.isHoveredOver()) {
			// center button click logic
			Utility.CENTER_BUTTON.setClicked(true);
		}
	}

	private void updateRightButtonClickState() {
		if (Utility.RIGHT_BUTTON.isHoveredOver()) {
			// right button click logic
			Utility.RIGHT_BUTTON.setClicked(true);
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
			if (Utility.VOLUME_MUTE_BUTTON.isClicked()) {
				Utility.VOLUME_MUTE_BUTTON.setClicked(false);
			} else {
				Utility.VOLUME_MUTE_BUTTON.setClicked(true);
			}
		}
	}
	
	private void updateVolumeFillBarClickState() {
		// if hovering over volume fill bar and clicked, then unmute if muted and
		// update the volume value
		if (Utility.VOLUME_FILL_BAR.isHoveredOver()) {
			Utility.VOLUME_MUTE_BUTTON.setClicked(false);
			currentlyPlayingSongVolume = (mouseClickedPosition.x - 237);
		}
	}
	
	private void updateExpandMusicPlayerButtonClickState() {
		if (Utility.EXPAND_MUSIC_PLAYER_BUTTON.isHoveredOver()) {
			if (Utility.EXPAND_MUSIC_PLAYER_BUTTON.isClicked()) { // if music player is expanded then miniaturize
				Utility.EXPAND_MUSIC_PLAYER_BUTTON.setClicked(false);
			} else { // expand music player
				Utility.EXPAND_MUSIC_PLAYER_BUTTON.setClicked(true);;
			}
		}
	}
	
	private void updateSongTimeFillBarClickState() {
		if (Utility.SONG_FILL_BAR.isHoveredOver()) { // update song time position according to position clicked
			currentlyPlayingSongTimePosition = (mouseClickedPosition.x - 10);
		}
	}
	
	private void updateMusicLibrarySongsBeingDisplayed() {
		if (!Utility.EXPAND_MUSIC_PLAYER_BUTTON.isClicked()) {
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
		if (!Utility.EXPAND_MUSIC_PLAYER_BUTTON.isClicked()) {
			return;
		}
		if (enter) { // select this song to display it
			currentlyPlayingSongName = RenderPlayer.songs[currentSongSelection];

			// start playing the song (no implementation yet)
			//try {
			//	clip.stop();
			//	File file = new File("res/songs/" + RenderMiniPlayer.songs[UpdateMiniPlayer.currentSongSelection] + ".wav");
			//	if (file.exists()) {
			//		AudioInputStream sound = AudioSystem.getAudioInputStream(file);
			//		clip = AudioSystem.getClip();
			//		clip.open(sound);
			//		clip.setFramePosition(0);;
			//		clip.start();
			//	} else {
			//		throw new RuntimeException("Sound: file not found: " + file.getName());
			//	}
			//} catch (Exception e) {
			//	e.printStackTrace();
			//}
		}
	}
	
	private void updateMusicLibrarySongSelectionClickState() {
		if (!Utility.EXPAND_MUSIC_PLAYER_BUTTON.isClicked()) {
			return;
		}
		int j = 0;
		for (; j < 14; j++) {
			if (Utility.DISPLAYABLE_SONG_POSITIONS[j].isClicked()) {
				break;
			}
		}
		for (int i = 0; i < 14; i++) {
			if (Utility.DISPLAYABLE_SONG_POSITIONS[i].isHoveredOver()) {
				resetClickedPositions();
				Utility.DISPLAYABLE_SONG_POSITIONS[i].setClicked(true);
				
				// check to see if click state is lower on the list or higher, and adjust
				// song selection variable accordingly
				currentSongSelection += (i-j);
			}
		}
	}
	
	private void resetClickedPositions() {
		for (int i = 0; i < 14; i++) {
			Utility.DISPLAYABLE_SONG_POSITIONS[i].setClicked(false);
		}
	}

	public void mouseWheelMoved(MouseWheelEvent arg0) {
		if (!Utility.EXPAND_MUSIC_PLAYER_BUTTON.isClicked()) {
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
		if (currentSongSelection > 0) {
			currentSongSelection--;
			
			if (!Utility.DISPLAYABLE_SONG_POSITIONS[0].isClicked()) {
				for (int i = 0; i < 14; i++) {
					if (Utility.DISPLAYABLE_SONG_POSITIONS[i].isClicked()) {
						Utility.DISPLAYABLE_SONG_POSITIONS[i].setClicked(false);
						Utility.DISPLAYABLE_SONG_POSITIONS[i-1].setClicked(true);
						break;
					}
				}
			} else {
				block--;
			}
		}
	}
	
	private void moveSongSelectionClickedDown() {
		if (currentSongSelection < RenderPlayer.songs.length-1) {
				currentSongSelection++;
				
				if (!Utility.DISPLAYABLE_SONG_POSITIONS[13].isClicked()) {
					for (int i = 0; i < 14; i++) {
						if (Utility.DISPLAYABLE_SONG_POSITIONS[i].isClicked()) {
							Utility.DISPLAYABLE_SONG_POSITIONS[i].setClicked(false);
							Utility.DISPLAYABLE_SONG_POSITIONS[i+1].setClicked(true);
							break;
						}
					}
				} else {
					block++;
				}
		}
	}
}
