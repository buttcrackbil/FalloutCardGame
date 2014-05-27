package com.ballu.falloutcardgame.card;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ballu.falloutcardgame.listeners.FlipListener;

public class Card extends JPanel {
	private JLabel		cardName;
	private JLabel		cardLife;
	private JLabel		cardAttack;
	private JLabel		cardUpgrade;
	private JLabel		cardBack;
	private Rectangle	name			= new Rectangle(0, 0, 100, 20);
	private Rectangle	life			= new Rectangle(0, 110, 100, 20);
	private Rectangle	attack			= new Rectangle(0, 130, 100, 20);
	private Rectangle	upgrade			= new Rectangle(50, 0, 50, 50);
	private Rectangle	back			= new Rectangle(0, 0, 100, 150);
	private JLabel[]	enemyLabels		= { cardName, cardLife, cardAttack,
			cardUpgrade, cardBack		};
	private JLabel[]	weaponLabels	= { cardName, cardLife, cardAttack,
			cardBack					};
	private Rectangle[]	enemyBounds		= { name, life, attack, upgrade, back };
	private Rectangle[]	weaponBounds	= { name, life, attack, back };
	private boolean		enemy			= false;
	private boolean		weapon			= false;
	private boolean		selected		= false;
	private boolean		flipped			= false;
	private boolean		selectable		= false;
	
	public Card(String title, String description, int damage, int health,
			int level) {
		addMouseListener(new FlipListener());
		setLayout(null);
		setBackground(Color.GREEN);
		System.out.println("Beginning card creation");
		setSize(100, 150);
		String[] texts = { title, "Health: " + Integer.toString(health),
				"Attack: " + Integer.toString(health), Integer.toString(level),
				wrap(description) };
		for (int i = 0; i < 5; i++) {
			enemyLabels[i] = new JLabel();
			enemyLabels[i].setBounds(enemyBounds[i]);
			enemyLabels[i].setText(texts[i]);
			if (i == 3) {
				enemyLabels[i].setFont(new Font("Times Roman", 0, 32));
				enemyLabels[i].setHorizontalAlignment(0);
			}
		}
		System.out.println("Created new card");
		addAllEnemy();
	}
	
	public Card(String title, int damaged, int maxDamage, int damage,
			String description) {
		addMouseListener(new FlipListener());
		setLayout(null);
		setBackground(Color.GREEN);
		System.out.println("Beginning card creation");
		setSize(100, 150);
		String[] texts = {
				title,
				"Con: " + Integer.toString(maxDamage - damaged) + "/"
						+ maxDamage, "Attack: " + Integer.toString(damage),
				wrap(description) };
		for (int i = 0; i < 4; i++) {
			weaponLabels[i] = new JLabel();
			weaponLabels[i].setBounds(weaponBounds[i]);
			weaponLabels[i].setText(texts[i]);
		}
		System.out.println("Created new card");
		addAllWeapon();
	}
	
	private String wrap(String input) {
		String output = "<html>" + input + "</html>";
		return output;
	}
	
	public String getName() {
		if (isWeapon()) {
			return weaponLabels[0].getText();
		}
		if (isEnemy()) {
			return enemyLabels[0].getText();
		}
		return "Not a real card";
	}
	
	public void addAllEnemy() {
		for (int i = 0; i < 4; i++) {
			add(enemyLabels[i]);
		}
	}
	
	public void addAllWeapon() {
		for (int i = 0; i < 3; i++) {
			add(weaponLabels[i]);
		}
	}
	
	public void flip() {
		if (isEnemy()) {
			add(enemyLabels[4]);
		} else if (isWeapon()) {
			add(weaponLabels[3]);
		}
	}
	
	public void setWeapon(boolean b) {
		weapon = b;
	}
	
	public void setEnemy(boolean b) {
		enemy = b;
	}
	
	public void setFlipped(boolean b) {
		flipped = b;
	}
	
	public void setSelectable(boolean b) {
		selectable = b;
	}
	
	public void setSelected(boolean b) {
		selected = b;
	}
	
	public boolean isWeapon() {
		return weapon;
	}
	
	public boolean isEnemy() {
		return enemy;
	}
	
	public boolean isFlipped() {
		return flipped;
	}
	
	public boolean isSelectable() {
		return selectable;
	}
	
	public boolean isSelected() {
		return selected;
	}
}
