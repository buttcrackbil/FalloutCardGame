package com.ballu.falloutcardgame.card.weapon;

import java.awt.Rectangle;

import javax.swing.JLabel;

import com.ballu.falloutcardgame.card.Card;

public class Weapon extends Card {
	
	private JLabel		attack;
	private Rectangle	attackRec	= new Rectangle(0, 130, 100, 20);
	
	public Weapon(String title, String description, int damage) {
		super(title, description);
		System.out.println("Beggining Weapon Creation");
		attack = new JLabel("+" + damage);
		attack.setBounds(attackRec);
		add(attack);
		setWeapon(true);
		repaint();
	}
	
	@Override
	public void flip() {
		if (!flipped) {
			removeAll();
			add(super.labels[1]);
			repaint();
		} else {
			removeAll();
			add(attack);
			add(super.labels[0]);
			repaint();
		}
	}
}
