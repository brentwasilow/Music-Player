package com.btwasilow.musicplayer.button;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import com.btwasilow.musicplayer.input.InputHandler;
import com.btwasilow.musicplayer.state.State;
import com.btwasilow.musicplayer.utility.Consts;

public class VolumeFillBar extends Button {
	// singleton
	private static VolumeFillBar volumeFillBar = new VolumeFillBar();
	
	private final RoundRectangle2D.Double boundingBox = new RoundRectangle2D.Double(236, 102, 102, 7, 4, 4);
	
	private VolumeFillBar() {
	}
	
	public static VolumeFillBar getInstance() {
		return volumeFillBar;
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
		// unmute and update the volume level based on
		// physical coordinates of click
		MuteVolumeButton.getInstance().select(false);
		State.volume = input.mouseClickedPosition.x - Consts.VOLUME_FILL_BAR_STARTING_PIXEL_POS;
		
		// squash volume level between 0 and 100 (min and max volume levels)
		if (State.volume < Consts.MIN_VOLUME_LEVEL) {
			State.volume = Consts.MIN_VOLUME_LEVEL;
 		} else if (State.volume > Consts.MAX_VOLUME_LEVEL) {
 			State.volume = Consts.MAX_VOLUME_LEVEL;
 		}
	}
}
