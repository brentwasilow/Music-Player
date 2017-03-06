package com.btwasilow.musicplayer.component;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

import com.btwasilow.musicplayer.state.State;
import com.btwasilow.musicplayer.utility.Consts;

public class ScrollBar extends NonClickableComponent {
	// singleton
	private static ScrollBar scrollBar = new ScrollBar();
	
	private final RoundRectangle2D.Double outerRectangleFillShape = new RoundRectangle2D.Double(327, 187, 5, 344, 3, 3);
	private final Color outerRectangleFillColor = new Color(40, 40, 40);
	
	private final RoundRectangle2D.Double innerRectangleFillShape = new RoundRectangle2D.Double();
	private final Color innerRectangleFillColor = new Color(150, 150, 150);
	
	private ScrollBar() {
	}
	
	public static ScrollBar getInstance() {
		return scrollBar;
	}
	
	@Override
	public void render(Graphics2D g) {
		if (ExpandMusicPlayerButton.getInstance().isSelected()) {
			g.setColor(outerRectangleFillColor);
			g.fill(outerRectangleFillShape);
			
			// determine scroll bar size and change in scrollbar placement
			float scrollBarChange = 14.0F / State.songs.length;
			float scrollBarSize = scrollBarChange * Consts.SCROLL_BAR_PIXEL_HEIGHT; 
			float restOfScroll = Consts.SCROLL_BAR_PIXEL_HEIGHT - scrollBarSize;
			float restOfScrollIncrement = restOfScroll / (State.songs.length - 14.0F);
			float scrollBarPlacement =  restOfScrollIncrement * State.block;
			
			innerRectangleFillShape.setRoundRect(327, 187 + (int)(scrollBarPlacement), 5, (int)(scrollBarSize), 3, 3);
			
			g.setColor(innerRectangleFillColor);
			g.fill(innerRectangleFillShape);
		}
	}
	

}
