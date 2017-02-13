package com.btwasilow.musicplayer.timer;

public class Timer {
	public int sixtieth = 0;
	public int seconds = 0;
	public int minutes = 0;
	public int hours = 0;
	public int days = 0;
	
	public Timer() {
	}
	
	public void update() {
		sixtieth++;
		if (sixtieth == 60) {
			sixtieth = 0;
			seconds++;
			if (seconds == 60) {
				seconds = 0;
				minutes++;
				if (minutes == 60) {
					minutes = 0;
					hours++;
					if (hours == 24) {
						hours = 0;
						days++;
					}
				}
			}
		}
	}
	
	public void reset() {
		sixtieth = 0;
		seconds = 0;
		minutes = 0;
		hours = 0;
		days = 0;
	}
}
