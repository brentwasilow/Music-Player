package com.btwasilow.musicplayer.utility;

public class Consts {
	public static final double UPDATES_PER_SECOND = 60.0;
	public static final double NANOSECONDS_PER_SECOND = 1000000000.0;
	public static final double MILLISECONDS_PER_SECOND = 1000.0;
	
	public static final int NUM_OF_STRATEGY_BUFFERS = 3;
	
	public static final int MINI_MUSIC_PLAYER_WIDTH = 350;
	public static final int MINI_MUSIC_PLAYER_HEIGHT = 150;
	public static final int FULL_MUSIC_PLAYER_WIDTH = 350;
	public static final int FULL_MUSIC_PLAYER_HEIGHT = 400;
	public static final int MUSIC_PLAYER_PIXEL_ARC_WIDTH = 15;
	public static final int MUSIC_PLAYER_PIXEL_ARC_HEIGHT = 15;
	
	public static final int SCROLL_BAR_PIXEL_HEIGHT = 344;
	public static final int NUM_OF_DISPLAYABLE_SONG_POSITIONS = 14;
	public static final int LAST_DISPLAYABLE_SONG_POSITION = 13;
	public static final int FIRST_DISPLAYABLE_SONG_POSITION = 0;
	
	private Consts() {
		throw new AssertionError();
	}
}
