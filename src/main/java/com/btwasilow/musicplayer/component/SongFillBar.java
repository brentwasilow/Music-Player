package com.btwasilow.musicplayer.component;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import com.btwasilow.musicplayer.input.InputHandler;
import com.btwasilow.musicplayer.state.State;
import com.btwasilow.musicplayer.utility.Consts;

public class SongFillBar extends Component {
	// singleton
	private static SongFillBar songFillBar = new SongFillBar();
	
	private final RoundRectangle2D.Double boundingBox = new RoundRectangle2D.Double(9, 130, 330, 9, 4, 4);
	
	private final RoundRectangle2D.Double outerRectangleFillShape = new RoundRectangle2D.Double(10, 131, 328, 7, 4, 4);
	private final Color outerRectangleFillColor = new Color(50, 50, 50);
	
	private final RoundRectangle2D.Double outerRectangleOutlineShape = new RoundRectangle2D.Double(9, 130, 330, 9, 4, 4);
	private final Color outerRectangleOutlineColor = new Color(30, 30, 30);
	
	private final RoundRectangle2D.Double innerRectangleFillShape = new RoundRectangle2D.Double(10, 131, 0, 7, 3, 3);
	private final Color innerRectangleFillColor = new Color(161, 202, 241);
	
	private final RoundRectangle2D.Double innerRectangleOutlineShape = new RoundRectangle2D.Double(10, 131, 0, 7, 4, 4);
	private final Color innerRectangleOutlineColor = new Color(100, 140, 180);
	
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
		// render song fill bar outline box area
		g.setColor(outerRectangleFillColor);
		g.fill(outerRectangleFillShape);
		
		g.setColor(outerRectangleOutlineColor);
		g.draw(outerRectangleOutlineShape);
		
		// set song fill bar width
		innerRectangleFillShape.width = State.currentlyPlayingSongTimePosition;
		innerRectangleOutlineShape.width = State.currentlyPlayingSongTimePosition;
		
		// now we song fill bar based on currently playing song time position
		g.setColor(innerRectangleFillColor);
		g.fill(innerRectangleFillShape);
		
		g.setColor(innerRectangleOutlineColor);
		g.draw(innerRectangleOutlineShape);
	}

	@Override
	public void updateClickState(InputHandler input) {
		// update song temporal position according to physical
		// coordinates of click
		State.currentlyPlayingSongTimePosition = input.mouseClickedPosition.x - Consts.SONG_FILL_BAR_STARTING_PIXEL_POS;
	
		// squash song temporal location between constant pixel positions
		if (State.currentlyPlayingSongTimePosition < Consts.MIN_SONG_TIME_POSITION) {
			State.currentlyPlayingSongTimePosition = Consts.MIN_SONG_TIME_POSITION;
		} else if (State.currentlyPlayingSongTimePosition > Consts.MAX_SONG_TIME_POSITION) {
			State.currentlyPlayingSongTimePosition = Consts.MAX_SONG_TIME_POSITION;
		}
	}
}
