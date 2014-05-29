package com.ballu.falloutcardgame.card.enemy;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.ballu.falloutcardgame.card.Card;

public class Enemy extends Card {
	
	private JLabel					life, attack;
	private Rectangle				lifeRec			= new Rectangle(0, 110,
															100, 20);
	private Rectangle				attackRec		= new Rectangle(0, 130,
															100, 20);
	private JLabel[]				labels			= { life, attack };
	private Rectangle[]				bounds			= { lifeRec, attackRec };
	
	// Card types
	public static final int			INFERNO			= 0;
	public static final int			LAUNCHER		= 1;
	public static final int			SNIPER			= 2;
	public static final int			SOLDIER			= 3;
	
	// Names
	private static final String[]	names			= { "Inferno", "Launcher",
			"Sniper", "Soldier"					};
	
	// Info
	private static final String[]	descriptions	= {
			"Cards attacked with this card will be damaged 1 health for 2 turns if caught on fire. 50% chance to set on fire",
			"Causes massive damage to card", "Headshot: Instant kill one card", "No special abilities" };
	
	// Health
	private static final String[]	health			= { "5", "5", "3", "5" };
	
	// Attacks
	private static final String[]	attacks			= { "5", "10", "8", "6" };
	
	public Enemy(int input) {
		super(names[input], descriptions[input]);
		
		String[] strings = { "Health: " + health[input],
				"Attack: " + attacks[input] };
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
