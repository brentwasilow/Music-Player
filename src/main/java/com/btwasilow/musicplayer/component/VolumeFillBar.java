package com.btwasilow.musicplayer.component;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import com.btwasilow.musicplayer.input.InputHandler;
import com.btwasilow.musicplayer.state.State;
import com.btwasilow.musicplayer.utility.Consts;

public class VolumeFillBar extends Component {
	// singleton
	private static VolumeFillBar volumeFillBar = new VolumeFillBar();
	
	private final RoundRectangle2D.Double boundingBox = new RoundRectangle2D.Double(236, 102, 102, 7, 4, 4);
	
	private final RoundRectangle2D.Double outerRectangleFillShape = new RoundRectangle2D.Double(237, 103, 100, 5, 4, 4);
	private final Color outerRectangleFillColor = new Color(50, 50, 50);
	
	private final RoundRectangle2D.Double outerRectangleOutlineShape = new RoundRectangle2D.Double(236, 102, 102, 7, 4, 4);
	private final Color outerRectangleOutlineColor = new Color(30, 30, 30);
	
	private final RoundRectangle2D.Double innerRectangleFillShape = new RoundRectangle2D.Double(237, 103, 50, 5, 3, 3);
	private final Color innerRectangleFillColor = new Color(90, 230, 0);
	
	private final RoundRectangle2D.Double innerRectangleOutlineShape = new RoundRectangle2D.Double(237, 103, 50, 5, 4, 4);
	private final Color innerRectangleOutlineColor = new Color(34, 140, 30);
	
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
		// render volume fill bar outline box area
		g.setColor(outerRectangleFillColor);
		g.fill(outerRectangleFillShape);
		
		g.setColor(outerRectangleOutlineColor);
		g.draw(outerRectangleOutlineShape);
		
		// if volume is muted then we render 0 volume otherwise render current song volume
		if (!MuteVolumeButton.getInstance().isSelected()) {
			innerRectangleFillShape.width = State.volume;
			innerRectangleOutlineShape.width = State.volume;
		} else {
			innerRectangleFillShape.width = 0;
			innerRectangleOutlineShape.width = 0;
		}
		
		// now we render volume fill bar itself based on volume 
		g.setColor(innerRectangleFillColor);
		g.fill(innerRectangleFillShape);
		
		g.setColor(innerRectangleOutlineColor);
		g.draw(innerRectangleOutlineShape);
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
