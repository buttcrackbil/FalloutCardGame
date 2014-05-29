package com.ballu.falloutcardgame.card;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ballu.falloutcardgame.listeners.FlipListener;

public abstract class Card extends JPanel {
	
	protected JLabel	name;
	protected JLabel	back;
	private Rectangle	nameRec	= new Rectangle(0, 0, 100, 20);
	private Rectangle	backRec	= new Rectangle(0, 0, 100, 150);
	public boolean		enemy, weapon, chem, clothing, food, magazine, book,
			selected, flipped, selectable;
	
	private JLabel[] labels = {name, back};
	private Rectangle[] bounds = {nameRec, backRec};
	
	public Card(String title, String description) {
		addMouseListener(new FlipListener());
		String[] strings = {title, wrap(description)};
		setLayout(null);
		setBackground(Color.GREEN);
		System.out.println("Beginning card creation");
		setSize(100, 150);
		for(int i = 0; i <labels.length; i++){
			labels[i] = new JLabel(strings[i]);
			labels[i].setBounds(bounds[i]);
			add(labels[i]);
		}
		System.out.println("Created new card");
	}
	
	private String wrap(String input) {
		String output = "<html>" + input + "</html>";
		return output;
	}
	
	public String getName() {
		return name.getText();
	}
	
	public abstract void flip();
	
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
}
