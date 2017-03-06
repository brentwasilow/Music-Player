package com.btwasilow.musicplayer.state;

import java.awt.geom.RoundRectangle2D;
import java.util.Random;

import com.btwasilow.musicplayer.button.ArtworkDisplayBox;
import com.btwasilow.musicplayer.button.Button;
import com.btwasilow.musicplayer.button.CenterButton;
import com.btwasilow.musicplayer.button.DisplayableSongPosition;
import com.btwasilow.musicplayer.button.ExitButton;
import com.btwasilow.musicplayer.button.ExpandMusicPlayerButton;
import com.btwasilow.musicplayer.button.LeftButton;
import com.btwasilow.musicplayer.button.MuteVolumeButton;
import com.btwasilow.musicplayer.button.RightButton;
import com.btwasilow.musicplayer.button.SongFillBar;
import com.btwasilow.musicplayer.button.VolumeFillBar;

public class State {
	public static final Button[] BUTTONS = {ExitButton.getInstance(), LeftButton.getInstance(), CenterButton.getInstance(),
										    RightButton.getInstance(), MuteVolumeButton.getInstance(), VolumeFillBar.getInstance(),
										    SongFillBar.getInstance(), ExpandMusicPlayerButton.getInstance(), ArtworkDisplayBox.getInstance()};
	
	private static final DisplayableSongPosition POSITION_1 = new DisplayableSongPosition(new RoundRectangle2D.Double(25, 210, 287, 23, 1, 1), true);
	private static final DisplayableSongPosition POSITION_2 = new DisplayableSongPosition(new RoundRectangle2D.Double(25, 233, 287, 23, 1, 1), false);
	private static final DisplayableSongPosition POSITION_3 = new DisplayableSongPosition(new RoundRectangle2D.Double(25, 256, 287, 23, 1, 1), false);
	private static final DisplayableSongPosition POSITION_4 = new DisplayableSongPosition(new RoundRectangle2D.Double(25, 279, 287, 23, 1, 1), false);
	private static final DisplayableSongPosition POSITION_5 = new DisplayableSongPosition(new RoundRectangle2D.Double(25, 302, 287, 23, 1, 1), false);
	private static final DisplayableSongPosition POSITION_6 = new DisplayableSongPosition(new RoundRectangle2D.Double(25, 325, 287, 23, 1, 1), false);
	private static final DisplayableSongPosition POSITION_7 = new DisplayableSongPosition(new RoundRectangle2D.Double(25, 348, 287, 23, 1, 1), false);
	private static final DisplayableSongPosition POSITION_8 = new DisplayableSongPosition(new RoundRectangle2D.Double(25, 371, 287, 23, 1, 1), false);
	private static final DisplayableSongPosition POSITION_9 = new DisplayableSongPosition(new RoundRectangle2D.Double(25, 394, 287, 23, 1, 1), false);
	private static final DisplayableSongPosition POSITION_10 = new DisplayableSongPosition(new RoundRectangle2D.Double(25, 417, 287, 23, 1, 1), false);
	private static final DisplayableSongPosition POSITION_11 = new DisplayableSongPosition(new RoundRectangle2D.Double(25, 440, 287, 23, 1, 1), false);
	private static final DisplayableSongPosition POSITION_12 = new DisplayableSongPosition(new RoundRectangle2D.Double(25, 463, 287, 23, 1, 1), false);
	private static final DisplayableSongPosition POSITION_13 = new DisplayableSongPosition(new RoundRectangle2D.Double(25, 486, 287, 23, 1, 1), false);
	private static final DisplayableSongPosition POSITION_14 = new DisplayableSongPosition(new RoundRectangle2D.Double(25, 509, 287, 23, 1, 1), false);
	public static final Button[] DISPLAYABLE_SONG_POSITIONS = {POSITION_1, POSITION_2, POSITION_3,
															   POSITION_4, POSITION_5, POSITION_6,
															   POSITION_7, POSITION_8, POSITION_9,
															   POSITION_10, POSITION_11, POSITION_12,
															   POSITION_13, POSITION_14};
	public static String currentlyPlayingSongName = "";
	public static int volume = 50;
	public static int currentlyPlayingSongTimePosition = 0;
	public static int currentSongSelection = 0;
	public static int currentDisplayableSongPosition = 0;
	public static Random rand = new Random();
	public static int block = 0;
	
	public static String[] songs = {"Break Up", "Changes", "I Need You", "Dirty Sessions", "The Ocean",
	"Don't You Worry Child", "Big Sky", "Got a Feeling", "Can't Afford it All",
	"Happy Endings", "Younger", "Sunday", "No Eyes", "Let Her Go", "Wonkavator",
	"Pompeii", "Generate", "Heading Home", "Youth", "Never Cry Again", "Arigato"};

	private State() {
		throw new AssertionError();
	}
}
