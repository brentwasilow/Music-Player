package com.btwasilow.musicplayer.button;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import com.btwasilow.musicplayer.input.InputHandler;
import com.btwasilow.musicplayer.state.State;
import com.btwasilow.musicplayer.utility.Consts;

public class SongFillBar extends Button {
	// singleton
	private static SongFillBar songFillBar = new SongFillBar();
	
	private final RoundRectangle2D.Double boundingBox = new RoundRectangle2D.Double(9, 130, 330, 9, 4, 4);
	
	private SongFillBar() {
	}
	
	public static SongFillBar getInstance() {
		return songFillBar;
	}
	
	@Override
	public Shape getBoundingBox() {
		return boundingBox;
	}

	@Override
	public void render(Graphics2D g) {
	}

	@Override
	public void updateClickState(InputHandler input) {
		// update song temporal position according to physical
		// coordinates of click
		State.currentlyPlayingSongTimePosition = input.mouseClickedPosition.x - Consts.SONG_FILL_BAR_STARTING_PIXEL_POS;
	}
}
