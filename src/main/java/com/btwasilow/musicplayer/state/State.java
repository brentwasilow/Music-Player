package com.btwasilow.musicplayer.state;

import java.util.Random;

public class State {
	
	public static String currentlyPlayingSongName = "";
	public static int volume = 25;
	public static int currentlyPlayingSongTimePosition = 0;
	public static int currentSongSelection = 0;
	public static int currentDisplayableSongPosition = 0;
	public static Random rand = new Random(); // used for equalizer rendering
	public static int block = 0;

	private State() {
		throw new AssertionError();
	}
}
