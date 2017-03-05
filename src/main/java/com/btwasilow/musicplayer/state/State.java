package com.btwasilow.musicplayer.state;

import java.util.Random;

public class State {
	public static String currentlyPlayingSongName = "";
	public static int volume = 25;
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
