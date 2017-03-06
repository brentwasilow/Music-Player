package com.btwasilow.musicplayer.component;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;

import com.btwasilow.musicplayer.utility.Consts;

public class EqualizerBox extends NonClickableComponent {
	// singleton
	private static EqualizerBox equalizerBox = new EqualizerBox();
	
	private final RoundRectangle2D.Double outerRectangleFillShape = new RoundRectangle2D.Double(200, 155, 139, 19, 3, 3);
	private final Color outerRectangleFillColor = new Color(50, 50, 50);
	
	private final RoundRectangle2D.Double outerRectangleOutlineShape = new RoundRectangle2D.Double(200, 155, 140, 20, 4, 4);
	private final Color outerRectangleOutlineColor = new Color(30, 30, 30);
	
	private final Color eqColor1 = new Color(0, 255, 0);
	private final Color eqColor2 = new Color(128, 255, 0);
	private final Color eqColor3 = new Color(255, 255, 0);
	private final Color eqColor4 = new Color(255, 255, 0);
	private final Color eqColor5 = new Color(255, 128, 0);
	private final Color eqColor6 = new Color(255, 0, 0);
	
	public static Random rand = new Random();
	
	private EqualizerBox() {	
	}
	
	public static EqualizerBox getInstance() {
		return equalizerBox;
	}
	
	@Override
	public void render(Graphics2D g) {
		if (ExpandMusicPlayerButton.getInstance().isSelected()) {
			// draw equalizer box
			g.setColor(outerRectangleFillColor);
			g.fill(outerRectangleFillShape);
			
			g.setColor(outerRectangleOutlineColor);
			g.draw(outerRectangleOutlineShape);
			
			// equalizer box loop
			for (int width = 0; width < Consts.NUM_OF_EQUALIZER_COLUMNS; width++) {
				// change color depending on the height of the equalizer box. The higher it is the redder it is.
				for (int height = 0; height < rand.nextInt(7); height++) {
					switch (height) {
						case 0:
							g.setColor(eqColor1);
							break;
						case 1:
							g.setColor(eqColor2);
							break;
						case 2:
							g.setColor(eqColor3);
							break;
						case 3:
							g.setColor(eqColor4);
							break;
						case 4:
							g.setColor(eqColor5);
							break;
						case 5:
							g.setColor(eqColor6);
							break;
					}
					g.fillRoundRect(203+(width*9), 173-(height*3), 8, 2, 1, 2);
				}
			}
		}
		
	}

}
