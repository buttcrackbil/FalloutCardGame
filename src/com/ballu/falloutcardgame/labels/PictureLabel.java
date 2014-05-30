package com.ballu.falloutcardgame.labels;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.ballu.falloutcardgame.listeners.MainListener;

public class PictureLabel extends JLabel {
	
	public PictureLabel(String text) {
		setOpaque(true);
		setSize(100, 100);
		setBackground(Color.GREEN);
		setText(text);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.BOTTOM);
		addMouseListener(new MainListener());
	}
}
