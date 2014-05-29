package com.ballu.falloutcardgame.card.enemy;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.ballu.falloutcardgame.card.Card;

public class Enemy extends Card {
	
	private JLabel		life, attack, upgrade;
	private Rectangle	lifeRec		= new Rectangle(0, 110, 100, 20);
	private Rectangle	attackRec	= new Rectangle(0, 130, 100, 20);
	private Rectangle	upgradeRec	= new Rectangle(50, 0, 50, 50);
	private JLabel[]	labels		= { life, attack, upgrade };
	private Rectangle[]	bounds		= { lifeRec, attackRec, upgradeRec };
	
	public Enemy(String string, String description, int life, int damage,
			int level) {
		super(string, description);
		String[] strings = { "Health: " + convert(life),
				"Attack: " + convert(damage), convert(level) };
		System.out.println("Beginning Enemy Creation");
		setEnemy(true);
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(strings[i]);
			labels[i].setBounds(bounds[i]);
			if (i == 2) {
				labels[i].setFont(new Font("Times Roman", 0, 32));
				labels[i].setHorizontalAlignment(SwingConstants.CENTER);
				labels[i].setVerticalAlignment(SwingConstants.BOTTOM);
			}
			add(labels[i]);
		}
		System.out.println("Finished Enemy Creation");
	}
	
	@Override
	public void flip() {
		if (!flipped) {
			removeAll();
			add(super.labels[1]);
			repaint();
		} else {
			removeAll();
			for (int i = 0; i < labels.length; i++) {
				add(labels[i]);
			}
			add(super.labels[0]);
			repaint();
		}
	}
}
