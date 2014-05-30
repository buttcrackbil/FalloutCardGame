package com.ballu.falloutcardgame.card;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.ballu.falloutcardgame.card.enemy.Enemy;
import com.ballu.falloutcardgame.listeners.ComponentMover;
import com.ballu.falloutcardgame.listeners.SelectionListener;

public abstract class Card extends JPanel {
	
	ComponentMover			cm			= new ComponentMover();
	
	private JLabel			name, back;
	
	private Rectangle		nameRec		= new Rectangle(0, 0, 150, 40);
	private Rectangle		backRec		= new Rectangle(0, getHeight() - 150,
												150, 50);
	
	private JLabel[]		labels		= { name, back };
	private Rectangle[]		bounds		= { nameRec, backRec };
	
	private boolean			enemy, weapon, chem, clothing, food, magazine,
			book, selected, flipped, selectable;
	
	private static Card[]	cardList	= new Card[100];
	
	private static int		idTracker	= 0;
	private int				id;
	
	public Card(String title, String description) {
		addMouseListener(new SelectionListener());
		setLayout(null);
		setSize(150, 225);
		bounds[1] = new Rectangle(0, getHeight() - 100, 150, 50);
		String[] strings = new String[2];
		if (!title.contains("<html>")) {
			strings[0] = wrap(title);
			strings[1] = wrap(description);
			cardList[idTracker] = this;
			id = idTracker;
			idTracker++;
			System.out.println("Card ID " + id + " was assigned to " + title);
		} else {
			strings[0] = title;
			strings[1] = description;
		}
		setBackground(Color.GREEN);
		System.out.println("Beginning card creation");
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(strings[i]);
			labels[i].setBounds(bounds[i]);
			labels[i].setVerticalAlignment(SwingConstants.NORTH);
			add(labels[i]);
		}
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		System.out.println("Created new card");
	}
	
	private String wrap(String input) {
		String output = "<html>" + input + "</html>";
		return output;
	}
	
	public Card setPlace(int x, int y) {
		setLocation(x, y);
		return this;
	}
	
	public String getName() {
		return labels[0].getText();
	}
	
	public String getInfo() {
		return labels[1].getText();
	}
	
	public static String convert(int in) {
		return Integer.toString(in);
	}
	
	public void setWeapon(boolean b) {
		weapon = b;
	}
	
	public void setEnemy(boolean b) {
		enemy = b;
	}
	
	public void setChem(boolean b) {
		chem = b;
	}
	
	public void setBook(boolean b) {
		book = b;
	}
	
	public void setClothing(boolean b) {
		clothing = b;
	}
	
	public void setFood(boolean b) {
		food = b;
	}
	
	public void setMagazine(boolean b) {
		magazine = b;
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
	
	public void setMovable(boolean b) {
		if (b)
			cm.registerComponent(this);
		if (!b)
			cm.deregisterComponent(this);
	}
	
	public boolean isWeapon() {
		return weapon;
	}
	
	public boolean isEnemy() {
		return enemy;
	}
	
	public boolean isChem() {
		return chem;
	}
	
	public boolean isBook() {
		return book;
	}
	
	public boolean isClothing() {
		return clothing;
	}
	
	public boolean isFood() {
		return food;
	}
	
	public boolean isMagazine() {
		return magazine;
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
	
	public int getID() {
		return id;
	}
	
	public abstract Enemy getUser();
}
