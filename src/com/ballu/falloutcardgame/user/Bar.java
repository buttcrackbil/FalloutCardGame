package com.ballu.falloutcardgame.user;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bar extends JPanel {
	
	private int			usedSections;
	private Color		background;
	private JLabel[]	sections;
	
	public Bar(int max, int used, Color background, int x, int y) {
		usedSections = used;
		this.background = background;
		setLayout(null);
		JLabel label = new JLabel(max - used + "/" + max);
		setBounds(x, y, 200, 30);
		label.setBounds(75, 0, 50, getHeight());
		sections = new JLabel[max];
		int sectionSize = getWidth() / max;
		for (int i = 0; i < max; i++) {
			sections[i] = new JLabel();
			sections[i].setOpaque(true);
			sections[i].setBounds(i * sectionSize, 0, sectionSize, getHeight());
			if (i < sections.length - usedSections) {
				sections[i].setBackground(background);
			}
			add(sections[i]);
		}
	}
	
	public void updateBar(int used) {
		usedSections += used;
		for (int i = 0; i < sections.length; i++) {
			if (i < sections.length - usedSections) {
				sections[i].setBackground(background);
			}else{
				sections[i].setBackground(Color.white);
			}
		}
	}
}
